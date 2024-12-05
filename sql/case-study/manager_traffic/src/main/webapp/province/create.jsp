<%--
  Created by IntelliJ IDEA.
  User: Tuấn Anh
  Date: 12/2/2024
  Time: 10:46 PM
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
            color: white;
        }
    </style>
</head>
<body>
<div class="container">
    <button class="btn btn-primary">
        <a href="province">Back</a>
    </button>
    <button class="btn btn-primary">
        <a href="/">Back home page</a>
    </button>
    <c:if test="${result ==false}">
        <h2>Create fail.You need create again</h2>
    </c:if>
    <form action="/province" method="post">

        <div class="form-group">
            <label for="name">Name Province:</label>
            <input type="text" class="form-control" id="name" name = name>
        </div>
        <button type="submit" class="btn btn-primary" name="action" value="createProvinceForm">Create Province</button>
    </form>
</div>
</body>
</html>
