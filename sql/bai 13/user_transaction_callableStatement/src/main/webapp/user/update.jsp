<%--
  Created by IntelliJ IDEA.
  User: Tuấn Anh
  Date: 11/29/2024
  Time: 8:00 AM
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
        <a href="/user">Back</a>
    </button>
    <form class="form-horizontal" action="user" method="post">
        <input type="hidden" name="id" value="${user.getId()}">
        <div class="form-group">
            <label class="control-label col-sm-2" for="name">Name:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="name" value="${user.getName()}" id="name">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="email">Email:</label>
            <div class="col-sm-10">
                <input type="email" class="form-control" name ="email" value="${user.getEmail()}" id="email">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="country">Country:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="country" value="${user.getCountry()}" id="country">
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary" name = "form" value="updateForm">Update</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>