<%--
  Created by IntelliJ IDEA.
  User: Tuấn Anh
  Date: 11/24/2024
  Time: 10:43 AM
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
            margin-top: 30px;
        }
        a,a:hover{
            text-decoration: none;
            color:#ffffff;
        }
    </style>
</head>
<body>
<div class="container">
    <button class="btn btn-primary">
        <a href="/product?action=showallproduct">Back to Show All Product</a>
    </button>
    <h1>Result search with : "${search}"</h1>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>STT</th>
            <th>Id</th>
            <th>Name</th>
            <th>Price</th>
            <th>Color</th>
            <th>Description</th>
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
                    </tr>


            </c:forEach>
    </tbody>
    </table>
</div>

</body>
</html>
