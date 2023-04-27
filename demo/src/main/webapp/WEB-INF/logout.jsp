<%--
  Created by IntelliJ IDEA.
  User: Aerosson
  Date: 19/04/2023
  Time: 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration confirmed</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <style>
        <%@include file="/WEB-INF/css/style.css" %>
    </style>
</head>
<body>
<header class="mb-4">
    <nav class="navbar navbar-expand-md navbar-dark">
        <div class="container-fluid">
            <img src="https://www.sauvageboris.fr/training/javaee/recipeEE/resources/logo/60.png"/>
            <a class="navbar-brand" href="#">Super Cooker</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse"
                    aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarCollapse">
                <ul class="navbar-nav me-auto mb-2 mb-md-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/secured">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/secured/add-recipe">Add recipe</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/secured/logout">Logout</a>
                    </li>
                </ul>
                <form class="end-navbar d-flex" role="search" action="${pageContext.request.contextPath}/secured/recipes" method="get">
                    <input name="mealChoice" class="form-control me-2" type="search" placeholder="Breakfast, lunch, diner?"
                           aria-label="Search">
                    <button class="btn btn-outline-light" type="submit">Suggestion</button>
                </form>
                <form class="last-search-box end-navbar d-flex" role="search" action="${pageContext.request.contextPath}/secured/recipes" method="get">
                    <input name="keyword" class="form-control me-2" type="search" placeholder="Any specific idea?"
                           aria-label="Search">
                    <button class="btn btn-outline-light" type="submit">Search</button>
                </form>
            </div>
        </div>
    </nav>
</header>
<div class="login-box">
<h3>Are you sure you want to log out?</h3>
<form method="post" name="logout">
    <label><input type="radio" name="answer" value="yes"> Yes</label>
    <br>
    <label><input type="radio" name="answer" value="no"> No</label>
    <br>
    <input type="submit" value="Submit">
</form>
</div>
</body>
</html>

