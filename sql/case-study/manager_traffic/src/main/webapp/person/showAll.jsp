<%--
  Created by IntelliJ IDEA.
  User: Tuấn Anh
  Date: 12/2/2024
  Time: 10:45 PM
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
    <button class="btn btn-default">
        <a href="/">Back</a>
    </button>
    <h2>Province</h2>
    <form action="/person" method="get">
        <button class="btn btn-primary" name="action" value="createPerson">
            Create Person
        </button>
    </form>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Stt</th>
            <th>Id</th>
            <th>Name</th>
            <th>Birthday</th>
            <th>Address</th>
            <th>Email</th>
            <th>Phone</th>
            <th>ID_Province</th>
            <th>Update</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${personList}" var="person" varStatus="loop">
            <tr>
                <td>${loop.count}</td>
                <td>${person.getId()}</td>
                <td>${person.getName()}</td>
                <td>${person.getBirthday()}</td>
                <td>${person.getAddress()}</td>
                <td>${person.getEmail()}</td>
                <td>${person.getPhone()}</td>
                <td>${person.getId_province()}</td>
                <td>
                    <form action="/person" method="get">
                        <button class="btn btn-info" name="action" value="updatePerson">
                            Update
                        </button>
                        <input type="hidden" name = "id" value="${person.getId()}">
                    </form>
                </td>
                <td>
                    <form action="/person" method="get">
                        <button class="btn btn-danger" name="action" value="deletePerson">
                            Delete
                        </button>
                        <input type="hidden" name = "id" value="${person.getId()}">
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
