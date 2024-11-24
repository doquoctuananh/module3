<%--
  Created by IntelliJ IDEA.
  User: Tuấn Anh
  Date: 11/24/2024
  Time: 8:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <style>
        .container{
            margin-top: 50px;
        }
    </style>
</head>
<body>
<div class="container">
    <form class="form-horizontal" action="/product" method="post">
        <input type="hidden" name="id" value="${product.getId()}">
        <div class="form-group">
            <label class="control-label col-sm-2" for="name">Name:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="name" value="${product.getName()}" id="name" placeholder="Enter Name">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="price">Price:</label>
            <div class="col-sm-10">
                <input type="number" class="form-control" name="price" value="${Double.parseDouble(product.getPrice())}" id="price" placeholder="Enter Price">
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-2" for="color">Color:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control"name="color" value="${product.getColor()}" id="color" placeholder="Enter Color">
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-2" for="description">Description:</label>
            <div class="col-sm-10">
                <textarea type="text" class="form-control" name="description"  id="description" placeholder="Enter Description">${product.getDescription()}</textarea>
            </div>
        </div>


        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary" name="action" value="updateForm">Update Product</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
