<%--
  Created by IntelliJ IDEA.
  User: Tuấn Anh
  Date: 11/24/2024
  Time: 9:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <style>
        .container{
            margin-top: 50px;
        }

        a>.btn{
            margin-bottom: 30px;
        }
    </style>
</head>
<body>
<div class="container">
    <a href="/">
        <button class="btn">Back Home page</button>
    </a>
    <form class="form-inline" action="/product" method="post">
        <div class="form-group">
            <label for="id">Enter Id:</label>
            <input type="number" class="form-control" name="id" id="id"placeholder="Enter id">
        </div>

        <button type="submit" class="btn btn-default" name="action" value="showDetailProductForm">Search Product</button>
    </form>

    <c:if test="${product == null}">
        <div class="alert alert-danger">
            <strong>Error!</strong> Not found Product .
        </div>
    </c:if>

    <c:if test="${product != null}">
        <h3>Information Product</h3>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Price</th>
                <th>Color</th>
                <th>Description</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>${product.getId()}</td>
                <td>${product.getName()}</td>
                <td>${product.getPrice()}</td>
                <td>${product.getColor()}</td>
                <td>${product.getDescription()}</td>

            </tr>

            </tbody>
        </table>
    </c:if>
</div>
</body>
</html>
