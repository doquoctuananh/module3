<%--
  Created by IntelliJ IDEA.
  User: Tuấn Anh
  Date: 11/21/2024
  Time: 7:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        img{
            width: 50px;
            height: 50px;
        }
        .r_table{
            height: 60px;
        }
    </style>
</head>
<body>
<h2>Danh sach khach hang</h2>
<table class="table table-hover">
    <thead>
    <tr>
        <th>Name</th>
        <th>Birthday</th>
        <th>Address</th>
        <th>Image</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${dataCustomer}" var="customer" varStatus="loop">
        <tr class="r_table">
            <td>${customer.name}</td>
            <td>${customer.birthday}</td>
            <td>${customer.address}</td>
            <td>
                    <img src="${customer.image}"></img>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
