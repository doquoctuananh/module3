<%--
  Created by IntelliJ IDEA.
  User: Tuấn Anh
  Date: 12/12/2024
  Time: 4:43 PM
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
    <h2>Product Table</h2>
    <form action="product" method="get">
        <button class="btn btn-primary" name="action" value="createProduct">Create Product</button>
    </form>

    <form class="form-inline" action="/product">
        <div class="form-group">
            <label for="name">Name Product:</label>
            <input type="text" class="form-control" id="name" name="name">
        </div>

        <div class="form-group">
            <label for="price">Price over:</label>
            <input type="number" class="form-control" id="price" name="price" value="0">
        </div>

        <button type="submit" class="btn btn-primary" name="action" value="searchProduct">Search</button>
    </form>

    <table class="table table-bordered">
        <thead>
        <tr>
            <th>STT</th>
            <th>nameProduct</th>
            <th>price</th>
            <th>quantity</th>
            <th>color</th>
            <th>category</th>
            <th>Update</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${products}" var="product" varStatus="loop">
            <tr>
                <td>${loop.count}</td>
                <td>${product.getName()}</td>
                <td>${product.getPrice()}</td>
                <td>${product.getQuantity()}</td>
                <td>${product.getColor()}</td>
                <td>${product.getCategory()}</td>

                <td>
                    <form action="product" method="get">
                        <button class="btn btn-info" name="action" value="updateProduct">Update</button>
                        <input type="hidden" name="id" value="${product.getId()}">
                    </form>
                </td>
                <td>
                    <button type="button" class="btn btn-danger" data-toggle="modal"
                            data-target="#myModal_${product.getId()}">delete</button>

                    <!-- Modal -->
                    <div id="myModal_${product.getId()}" class="modal fade" role="dialog">
                        <div class="modal-dialog">

                            <!-- Modal content-->
                            <div class="modal-content">
                                <div class="modal-body">
                                    <p>Ban co chac chan muon xoa san pham khong?</p>
                                </div>

                                <div class="modal-footer">
                                    <button type="button" data-dismiss="modal" class="btn btn-default">No</button>
                                    <button class="btn btn-warning" >
                                        <a href="product?action=deleteProduct&id=${product.getId()}">Delete</a>
                                    </button>
                                </div>
                            </div>

                        </div>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
