<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>This is a title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>

<header class="mb-4">
    <nav class="navbar navbar-expand-md navbar-dark bg-dark">
        <div class="container-fluid">
            <img src="https://img.icons8.com/plasticine/64/null/blog.png"/>
            <a class="navbar-brand" href="#">The Blog</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse"
                    aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarCollapse">
                <ul class="navbar-nav me-auto mb-2 mb-md-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="posts">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="add-post">Add post</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="delete-post">Delete post</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="update-post">Update post</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="categories">Categories</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="add-category">Add Category</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="update-category">Update Category</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="delete-category">Delete Category</a>
                    </li>
                </ul>
                <form class="d-flex" role="search" action="${pageContext.request.contextPath}/post-list" method="get">
                    <input name="searchName" class="form-control me-2" type="search" placeholder="Search"
                           aria-label="Search">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
            </div>
        </div>
    </nav>
</header>

<div class="container">
    <h1>Recipes</h1>
    <div class="row row-cols-1 row-cols-md-2 row-cols-lg-4 g-3 align-content-center">
        <c:forEach var="r" items="${recipes}">
            <div class="col">
                <div class="card">
                    <img src="${r.pictureUrl}" class="card-img-top" alt="${r.title}">
                    <div class="card-body">
                        <h5 class="card-title">${r.title}</h5>
                        <p class="card-text">${p.content}</p>
                        <p class="recipe-category">${r.category}</p>
                        <p class="recipe-number">Recipe number ${r.id}</p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>


</body>
</html>
