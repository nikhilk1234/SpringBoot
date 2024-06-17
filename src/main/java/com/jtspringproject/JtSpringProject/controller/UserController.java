package com.jtspringproject.JtSpringProject.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jtspringproject.JtSpringProject.models.Cart;
import com.jtspringproject.JtSpringProject.models.Product;
import com.jtspringproject.JtSpringProject.models.User;
import com.jtspringproject.JtSpringProject.services.cartService;
import com.jtspringproject.JtSpringProject.services.productService;
import com.jtspringproject.JtSpringProject.services.userService;

@Controller
public class UserController {

	@Autowired
	private userService userService;

	@Autowired
	private productService productService;

	@GetMapping("/register")
	public String registerUser() {
		return "register";
	}

	@GetMapping("/buy")
	public String buy() {
		return "buy";
	}

	@GetMapping("/")
	public String userlogin(Model model) {

		return "userLogin";
	}

	@RequestMapping(value = "userloginvalidate", method = RequestMethod.POST)
	public ModelAndView userlogin(@RequestParam("username") String username, @RequestParam("password") String pass,
			Model model, HttpServletResponse res) {

		System.out.println(pass);
		User u = this.userService.checkLogin(username, pass);
		System.out.println(u.getUsername());

		if (username.equals(u.getUsername())) {

			res.addCookie(new Cookie("username", u.getUsername()));
			ModelAndView mView = new ModelAndView("index");
			mView.addObject("username", u.getUsername());

			List<Product> products = this.productService.getProducts();
			if (products.isEmpty()) {
				mView.addObject("msg", "No products are available");
			} else {
				mView.addObject("products", products);
			}
			return mView;

		} else {
			ModelAndView mView = new ModelAndView("userLogin");
			mView.addObject("msg", "Please enter correct email and password");
			return mView;
		}

	}

	@GetMapping("/user/products")
	public ModelAndView getproduct() {

		ModelAndView mView = new ModelAndView("uproduct");

		List<Product> products = this.productService.getProducts();

		if (products.isEmpty()) {
			mView.addObject("msg", "No products are available");
		} else {
			mView.addObject("products", products);
		}

		return mView;
	}

	@RequestMapping(value = "newuserregister", method = RequestMethod.POST)
	public ModelAndView newUseRegister(@ModelAttribute User user) {
		// Check if username already exists in database
		boolean exists = this.userService.checkUserExists(user.getUsername());

		if (!exists) {
			System.out.println(user.getEmail());
			user.setRole("ROLE_NORMAL");
			this.userService.addUser(user);

			System.out.println("New user created: " + user.getUsername());
			ModelAndView mView = new ModelAndView("userLogin");
			return mView;
		} else {
			System.out.println("New user not created - username taken: " + user.getUsername());
			ModelAndView mView = new ModelAndView("register");
			mView.addObject("msg", user.getUsername() + " is taken. Please choose a different username.");
			return mView;
		}
	}

	@GetMapping("/logout")
	public String logout(Model model) {
		System.out.println("logout page");

		// Add attributes to the model
		model.addAttribute("author", "jay gajera");
		model.addAttribute("id", 40);

		List<String> friends = new ArrayList<>();
		friends.add("xyz");
		friends.add("abc");
		model.addAttribute("f", friends);

		// Return the view name
		return "logout";
	}

	@Autowired
	private cartService cartService;

	@GetMapping("cartsproduct")
	public ModelAndView getCartDetail() {
		ModelAndView mv = new ModelAndView();
		try {
			List<Cart> carts = cartService.getCarts();
			// Add the list of carts to the ModelAndView object

			for (Iterator iterator = carts.iterator(); iterator.hasNext();) {
				Cart cart = (Cart) iterator.next();
				System.out.println(cart.getId() + " " + cart.getCustomer());
			}
			mv.addObject("carts", carts);
			// Set the view name
			mv.setViewName("cartsproduct"); // Assuming "cartDetail" is your view name
		} catch (Exception e) {
			e.printStackTrace();
			// Redirect to an error page or handle the exception accordingly
			mv.setViewName("error"); // Set the appropriate error page name
		}
		return mv;
	}

	@GetMapping("/error")
	public String handleError() {
		// Handle the error and return the appropriate error page
		return "error"; // Assuming "error" is the name of your error page HTML file
	}

}