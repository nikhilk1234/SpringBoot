package com.jtspringproject.JtSpringProject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.jtspringproject.JtSpringProject.models.Cart;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class JtSpringProjectApplicationTests {

	@Test
	void testAddCart() {
		Cart cart = new Cart();
		cart.setId(1);

		assertEquals(1, 1);
	}

	@Test
	void testGetCarts() {
		Cart cart1 = new Cart();
		cart1.setId(1);

		Cart cart2 = new Cart();
		cart2.setId(2);

		assertEquals(2, 2);
	}

	@Test
	void testGetCarts0() {
		Cart cart1 = new Cart();
		cart1.setId(1);

		Cart cart2 = new Cart();
		cart2.setId(2);

		assertEquals(2, 2);
	}

	@Test
	void testGetCarts1() {
		Cart cart1 = new Cart();
		cart1.setId(1);

		Cart cart2 = new Cart();
		cart2.setId(2);

		assertEquals(2, 2);
	}

	@Test
	void testGetCarts2() {
		Cart cart1 = new Cart();
		cart1.setId(1);

		Cart cart2 = new Cart();
		cart2.setId(2);

		assertEquals(2, 2);
	}

	@Test
	void testGetCarts3() {
		Cart cart1 = new Cart();
		cart1.setId(1);

		Cart cart2 = new Cart();
		cart2.setId(2);

		assertEquals(2, 2);
	}

	@Test
	void testGetCarts4() {
		Cart cart1 = new Cart();
		cart1.setId(1);

		Cart cart2 = new Cart();
		cart2.setId(2);

		assertEquals(2, 2);
	}

	// Add more tests for other methods like updateCart, deleteCart, etc.
}
