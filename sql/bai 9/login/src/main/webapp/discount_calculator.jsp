<%--
  Created by IntelliJ IDEA.
  User: Tuấn Anh
  Date: 11/20/2024
  Time: 2:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <form action="display-discount" method="post">
        <div class="mb-3 mt-3">
            <label for="description" class="form-label">Description:</label>
            <input type="text" class="form-control" id="description" placeholder="Enter description" name="description">
        </div>
        <div class="mb-3">
            <label for="price" class="form-label">List Price:</label>
            <input type="number" class="form-control" id="price" placeholder="Enter Price" name="price">
        </div>

        <div class="mb-3">
            <label for="discount" class="form-label">Discount percent: </label>
            <input type="number" class="form-control" id="discount" placeholder="Enter discount" name="discount">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>

    <div class="panel-group">
        <div class="panel panel-default">
            <div class="panel-heading">Calculator</div>

        </div>

        <div class="panel panel-primary">
            <div class="panel-heading">Description</div>
            <div class="panel-body">${description}</div>
        </div>
        <div class="panel panel-primary">
            <div class="panel-heading">Price</div>
            <div class="panel-body">${price}</div>
        </div>
        <div class="panel panel-primary">
            <div class="panel-heading">Discount</div>
            <div class="panel-body">${discount}</div>
        </div>

        <div class="panel panel-primary">
            <div class="panel-heading">discount_price</div>
            <div class="panel-body">${discount_price}</div>
        </div>
    </div>
</div>

</body>
</html>
