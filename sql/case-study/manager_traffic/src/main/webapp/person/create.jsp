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
        a,a:hover{
            text-decoration: none;
            color: white;

        }
        #id_province{
            min-width: 200px;
            height: 20px;
            border-radius: 5px;
            font-size: 16px;
            margin-left: 15px;
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <button class="btn btn-primary">
        <a href="person">Back</a>
    </button>
    <button class="btn btn-primary">
        <a href="/">Back home page</a>
    </button>
    <c:if test="${result ==false}">
        <h2>Create fail.You need create again</h2>
    </c:if>
    <form action="/person" method="post">

        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" class="form-control" id="name" name = "name">
        </div>
        <div class="form-group">
            <label for="birthday">Birthday:</label>
            <input type="date" class="form-control" id="birthday" name = "birthday">
        </div>
        <div class="form-group">
            <label for="address">Address:</label>
            <input type="text" class="form-control" id="address" name = "address">
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" class="form-control" id="email" name = "email">
        </div>
        <div class="form-group">
            <label for="phone">Phone:</label>
            <input type="text" class="form-control" id="phone" name = "phone">
        </div>
        <div class="form-group">
            <label for="id_province">Province:</label>
            <select name="id_province" id="id_province">
                <c:forEach items="${provinceList}" var="province">
                    <option  value="${province.getCode()}">${province.getName()}</option>
                </c:forEach>
            </select>
        </div>

        <button type="submit" class="btn btn-primary" name="action" value="createPersonForm">Create Person</button>
    </form>
</div>
</body>
</html>
