<%--
  Created by IntelliJ IDEA.
  User: Tuấn Anh
  Date: 11/28/2024
  Time: 11:27 PM
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
</head>
<body>
<div class="container">
    <div class="container">
        <h2>Table List User</h2>

        <form action="user" method="get">
            <button class="btn btn-primary" name="action" value="create-use-transaction">
                Create
            </button>
<%--            <button class="btn btn-primary" name="action" value="create">--%>
<%--                Create--%>
<%--            </button>--%>
        </form>

        <form action="user" method="get">
            <input type="number" name="id" placeholder="Enter Id">
            <button class="btn btn-primary" name="action" value="findUserId">
                Finf User With Id
            </button>
        </form>

        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Email</th>
                <th>Country</th>
                <th>Update</th>
                <th>Delete</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${users}" var="user" varStatus="loop">
                <tr>
                    <td>${user.getId()}</td>
                    <td>${user.getName()}</td>
                    <td>${user.getEmail()}</td>
                    <td>${user.getCountry()}</td>
                    <td>
                            <form action="user" method="get">
                                <button class="btn btn-info" name="action" value="update">
                                    Update
                                </button>
                                <input type="hidden" name="id" value="${user.getId()}">
                            </form>
                    </td>
                    <td>
                        <form action="user" method="get">
                            <button class="btn btn-danger" name="action" value="delete">
                                Delete
                            </button>
                            <input type="hidden" name="id" value="${user.getId()}">
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
