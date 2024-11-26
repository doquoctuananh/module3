<%--
  Created by IntelliJ IDEA.
  User: Tuấn Anh
  Date: 11/27/2024
  Time: 12:05 AM
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
            color: #000000;

        }
        .btn{
            margin-bottom: 16px;
        }
    </style>
</head>
<body>
<div class="container">
    <button class="btn btn-primary">
        <a href="/user?action=showAllUser">Back</a>
    </button>
    <div class="panel panel-default">
        <div class="panel-body">Result Search</div>
    </div>

    <c:if test="${users.size()>0}">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>STT</th>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Country</th>
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
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
    <c:if test="${users.size()==0}">
        <div class="panel panel-default">
            <div class="panel-body">Result Search Not Found</div>
        </div>
    </c:if>
</div>
</body>
</html>
