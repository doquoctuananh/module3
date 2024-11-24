<%--
  Created by IntelliJ IDEA.
  User: Tuấn Anh
  Date: 11/22/2024
  Time: 10:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<h1>
    <a href="http://localhost:8080">Tro ve trang chu</a>
</h1>

<table class="table">
    <thead>
    <tr>
        <th>STT</th>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${customerList}" var="customer" varStatus="loop" >
        <tr>
            <td>${loop.count}</td>
            <td>${customer.getId()}</td>
            <td>${customer.getName()}</td>
            <td>${customer.getEmail()}</td>
            <td>${customer.getAddress()}</td>
            <td>
                <form action="/customer" method="get">
                    <button type="submit" name = "action" value = "update">
                        Update
                    </button>
                    <input type="hidden" name = "id" value="${customer.getId()}">
                </form>

            </td>
            <td>
                <form action="/customer" method="get">
                    <button type="submit" name = "action" value = "delete">
                        Delete
                    </button>
                    <input type="hidden" name = "id" value="${customer.getId()}">
                </form>

            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
