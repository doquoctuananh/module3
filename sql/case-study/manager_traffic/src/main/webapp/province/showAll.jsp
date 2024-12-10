<%--
  Created by IntelliJ IDEA.
  User: Tuấn Anh
  Date: 12/2/2024
  Time: 10:44 PM
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
    <form action="/province" method="get">
        <button class="btn btn-primary" name="action" value="createProvince">
            Create Province
        </button>
    </form>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Stt</th>
            <th>Code</th>
            <th>Name</th>
            <th>Update</th>
<%--            <th>Delete</th>--%>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${provinceList}" var="province" varStatus="loop">
            <tr>
                <td>${loop.count}</td>
                <td>${province.getCode()}</td>
                <td>${province.getName()}</td>
                <td>
                    <form action="/province" method="get">
                        <button class="btn btn-info" name="action" value="updateProvince">
                            Update
                        </button>
                        <input type="hidden" name = "id" value="${province.getCode()}">
                    </form>
                </td>
<%--                <td>--%>
<%--                    <form action="/province" method="get">--%>
<%--                        <button class="btn btn-danger" name="action" value="deleteProvince">--%>
<%--                            Delete--%>
<%--                        </button>--%>
<%--                        <input type="hidden" name = "id" value="${province.getCode()}">--%>
<%--                    </form>--%>
<%--                </td>--%>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
