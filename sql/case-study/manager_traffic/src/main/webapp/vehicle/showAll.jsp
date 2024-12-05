<%--
  Created by IntelliJ IDEA.
  User: Tuấn Anh
  Date: 12/2/2024
  Time: 10:47 PM
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
        li{
            height: 36px;
        }

        .btnVehicle{
            width: 100%;
            height: 100%;
            border: none;
            background: #ffffff;
        }
        .btnVehicle:hover{
            color: white;
            background-color: #337ab7;
        }

    </style>
</head>
<body>
<div class="container">
    <div class="dropdown">
        <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Filter Vehicle
            <span class="caret"></span></button>
        <ul class="dropdown-menu">
            <li>
                <form action="vehicle" method="get">
                        <button class="btnVehicle" name = "typeVehicle" value="Car">
                            Car
                        </button>

                </form>
            </li>
            <li>
                <form action="vehicle" method="get">
                    <button class="btnVehicle" name = "typeVehicle" value="Motorbike">
                        Motorbike
                    </button>
                </form>
            </li>
            <li>
                <form action="vehicle" method="get">
                    <button class="btnVehicle" name = "typeVehicle" value="">
                        ShowAll
                    </button>
                </form>
            </li>
        </ul>
    </div>

    <h2>List vehicle</h2>

    <table class="table table-bordered">
        <thead>
        <tr>
            <th>STT</th>
            <th>ID</th>
            <th>Name</th>
            <th>Color</th>
            <th>Price</th>
            <th>YearManufactured</th>
            <th>Id_Province</th>
            <th>Id_Person</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${vehicleList}" var="vehicle" varStatus="loop">
            <tr>
                <td>${loop.count}</td>
                <td>${vehicle.getId()}</td>
                <td>${vehicle.getNameVehicle()}</td>
                <td>${vehicle.getColor()}</td>
                <td>${vehicle.getPrice()}</td>
                <td>${vehicle.getYearManufactured()}</td>
                <td>${vehicle.getIdProvince()}</td>
                <td>${vehicle.getIdPerson()}</td>
            </tr>

        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
