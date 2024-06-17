<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="java.text.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ecomm Super Mart</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
          integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
    <style>
        /* Custom styles */
        body {
            padding: 20px;
            background-color: #f8f9fa; /* Light gray background */
        }
        .navbar {
            background-color: #fff; /* White navbar background */
        }
        .navbar-brand img {
            max-height: 40px; /* Limit the height of the logo */
        }
        .navbar-collapse {
            justify-content: flex-end; /* Align navbar items to the right */
        }
        .navbar-nav .nav-item {
            margin-right: 15px; /* Add space between navbar items */
        }
        .container {
            margin-top: 40px; /* Add space between navbar and content */
        }
        .card {
            border: none; /* Remove card border */
            border-radius: 10px; /* Add card border radius */
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1); /* Add card shadow */
            transition: box-shadow 0.3s ease-in-out; /* Add transition effect */
        }
        .card:hover {
            box-shadow: 0 8px 12px rgba(0, 0, 0, 0.2); /* Increase shadow on hover */
        }
        .card-body {
            height: 250px; /* Set a fixed height for the card body */
        }
        .card-img-top {
            max-height: 100px; /* Limit the height of the product image */
            object-fit: contain;
        }
    </style>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light">
    <div class="container">
        <a class="navbar-brand" href="#">
            ECOM Super Mart | Tech with Jatin
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="cartsproduct">Your Cart</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="profileDisplay">Profile</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" sec:authorize="isAuthenticated()" href="logout">Logout</a>
                </li>
            </ul>
            <span class="navbar-text">
                Welcome ${username}
            </span>
        </div>
    </div>
</nav>

<div class="container">
    <h1 class="text-center mb-4">Welcome to Ecomm Super Mart</h1>
    <div class="row">
        <c:forEach var="product" items="${products}">
            <div class="col-md-3">
                <div class="card mb-4">
                    <img class="card-img-top" src="${product.image}" alt="Product Image">
                    <div class="card-body">
                        <h5 class="card-title">${product.name}</h5>
                        <p class="card-text">Category: ${product.category.name}</p>
                        <p class="card-text">Price: ${product.price}</p>
                        <p class="card-text">Description: ${product.description}</p>
                        <a href="#" class="btn btn-primary">Add to Cart</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

</body>
</html>
