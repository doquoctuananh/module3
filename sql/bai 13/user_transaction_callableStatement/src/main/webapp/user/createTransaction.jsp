<%--
  Created by IntelliJ IDEA.
  User: Tuấn Anh
  Date: 11/30/2024
  Time: 10:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
  Created by IntelliJ IDEA.
  User: Tuấn Anh
  Date: 11/28/2024
  Time: 11:55 PM
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
        <div class="form-group">
            <label class="control-label col-sm-2" for="name">Name:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="name" id="name" placeholder="Enter name">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="email">Email:</label>
            <div class="col-sm-10">
                <input type="email" class="form-control" name ="email" id="email" placeholder="Enter email">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="country">Country:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="country" id="country" placeholder="Enter country">
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-2">Rule:</label>
            <div class="col-sm-10">
                <input type="checkbox"  name = "add"> add |
                <input type="checkbox"  name = "update"> update |
                <input type="checkbox"  name = "delete"> delete |
                <input type="checkbox"  name = "view"> view |
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary" name = "form" value="createTransactionForm">Create</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>

</body>
</html>
