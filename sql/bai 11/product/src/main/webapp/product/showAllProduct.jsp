<%--
  Created by IntelliJ IDEA.
  User: Tuấn Anh
  Date: 11/24/2024
  Time: 12:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Show all Product</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h2>Table Product Laptop</h2>
    <form action="/product" method="get">
        <button class="btn btn-primary" name="action" value="create">Create a product</button>
        <button class="btn btn-primary" name="action" value="showDetailProduct">Show Detail a product</button>
        <button class="btn btn-default">
            <a href="/">Back home Page</a>
        </button>

        <input type="text" name="search">
            <button class="btn btn-default" name="action" value="searchProduct">
                Search
            </button>
        </input>


    </form>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>STT</th>
            <th>Id</th>
            <th>Name</th>
            <th>Price</th>
            <th>Color</th>
            <th>Description</th>
            <th>Update</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${products}" var="product" varStatus="loop">
            <tr>
                <td>${loop.count}</td>
                <td>${product.getId()}</td>
                <td>${product.getName()}</td>
                <td>${product.getPrice()}</td>
                <td>${product.getColor()}</td>
                <td>${product.getDescription()}</td>
                <td>
                    <form action="/product" method="get">
                        <button class="btn btn-info">Update</button>
                        <input type="hidden" name="id" value="${product.getId()}">
                        <input type="hidden" name="action" value="update">
                    </form>
                </td>
                <td>
                    <form action="/product" method="get">
                        <button class="btn btn-danger">Delete</button>
                        <input type="hidden" name="id" value="${product.getId()}">
                        <input type="hidden" name="action" value="delete">
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
