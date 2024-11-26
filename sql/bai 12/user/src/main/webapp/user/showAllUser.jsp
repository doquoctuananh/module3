<%--
  Created by IntelliJ IDEA.
  User: Tuấn Anh
  Date: 11/25/2024
  Time: 11:54 PM
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
    <div class="panel panel-default">
        <div class="panel-body">Lists User</div>
    </div>
    <c:if test="${resultCreate == 'true'}">
        <div class="panel panel-default">
            <div class="panel-body">Create Success</div>
        </div>
    </c:if>
    <form action="/user" method="get">
        <button class="btn btn-primary" name = "action" value="create">
            Create User
        </button>
        <button class="btn btn-primary" name = "action" value="sortName">
            Sort User By Name
        </button>
    </form>
    <form action="/user" method="get">
        <input placeholder="Search Name" type="text" name="searchName">
        <button class="btn btn-primary" name="action" value="searchName">Search</button>
    </form>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>STT</th>
            <th>ID</th>
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
                <td>${loop.count}</td>
                <td>${user.getId()}</td>
                <td>${user.getName()}</td>
                <td>${user.getEmail()}</td>
                <td>${user.getCountry()}</td>
                <td>
                    <form action="/user" method="get">
                        <button class="btn btn-info" name = "action" value="update">
                                Update
                        </button>
                        <input type="hidden" name="updateId" value="${user.getId()}">
                        <input type="hidden" name="userName" value="${user.getName()}">
                        <input type="hidden" name="userEmail" value="${user.getEmail()}">
                        <input type="hidden" name="userCountry" value="${user.getCountry()}">
                    </form>

                </td>
                <td>
                    <form action="/user" method="get">
                        <button class="btn btn-danger" name = "action" value="delete">
                            Delete
                        </button>
                        <input type="hidden" name="deleteId" value="${user.getId()}">
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
