<%--
  Created by IntelliJ IDEA.
  User: Tuấn Anh
  Date: 12/10/2024
  Time: 9:07 AM
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
        <a href="/vehicle">Back</a>
    </button>
    <button class="btn btn-default">
        <a href="/">Back Home Page</a>
    </button>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Color</th>
            <th>Price</th>
            <th>YearManufactured</th>
            <th>Id_Province</th>
            <th>Id_Person</th>
            <th>Type</th>
            <c:if test="${vehicle.getTypeVehicle().equals('Car')}">
                <th>Numbet Seats</th>
            </c:if>
            <c:if test="${vehicle.getTypeVehicle().equals('Motorbike')}">
                <th>Speed</th>
            </c:if>
        </tr>
        </thead>
        <tbody>
            <tr>
                <td>${vehicle.getId()}</td>
                <td>${vehicle.getNameVehicle()}</td>
                <td>${vehicle.getColor()}</td>
                <td>${vehicle.getPrice()}</td>
                <td>${vehicle.getYearManufactured()}</td>
                <td>${vehicle.getIdProvince()}</td>
                <td>${vehicle.getIdPerson()}</td>
                <td>${vehicle.getTypeVehicle()}</td>
                <c:if test="${vehicle.getTypeVehicle().equals('Car')}">
                    <td>${vehicle.getNumerSeats()}</td>
                </c:if>
                <c:if test="${vehicle.getTypeVehicle().equals('Motorbike')}">
                    <td>${vehicle.getSpeed()}</td>
                </c:if>
            </tr>
        </tbody>
    </table>
</div>
</body>
</html>
