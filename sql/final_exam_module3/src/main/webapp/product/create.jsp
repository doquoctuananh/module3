<%--
  Created by IntelliJ IDEA.
  User: Tuấn Anh
  Date: 12/12/2024
  Time: 7:17 PM
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
    </style>
</head>
<body>
<div class="container">
    <form action="product" method="post">
        <div class="form-group">
            <label for="nameProduct">Name Product:</label>
            <input type="text" class="form-control" id="nameProduct" name="nameProduct">
        </div>
        <div class="form-group">
            <label for="price">Price Product:</label>
            <input type="number" class="form-control" id="price" name="price" min="10000000">
        </div>
        <div class="form-group">
            <label for="quantity">Quantity Product:</label>
            <input type="number" class="form-control" id="quantity" name="quantity" min="1">
        </div>
        <div class="form-group">
            <label for="color">Color:</label>
            <input type="text" class="form-control" id="color" name="color">
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <textarea type="text" class="form-control" id="description" name="description"></textarea>
        </div>

        <div class="form-group">
            <label for="catetory">Catetory:</label>

            <select id="catetory" name="id_catetory">
                <c:forEach items="${categories}" var="catetory">
                    <option value="${catetory.getId()}">${catetory.getName()}</option>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-primary" name = "action" value="createForm">Create</button>
        <button class="btn btn-default">
            <a href="product">Back</a>
        </button>
    </form>
</div>
</body>
</html>
