<%--
  Created by IntelliJ IDEA.
  User: Tuấn Anh
  Date: 11/22/2024
  Time: 10:22 AM
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
    <form action="customer" method = "post">

        </br>
        <input type="text" class="form-control" name = "name" placeholder="Enter name">
        </br>
        <input type="email" class="form-control" name = "email" placeholder="Enter email">
        </br>
        <input type="text" class="form-control" name = "address" placeholder="Enter address">
        </br>
        <button type="submit" class="btn btn-prmary" name="action" value="create">Create</button>
    </form>
</div>

</body>
</html>