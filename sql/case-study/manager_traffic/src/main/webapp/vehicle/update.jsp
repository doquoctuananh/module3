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
        <a href="vehicle">Back</a>
    </button>
    <button class="btn btn-primary">
        <a href="/">Back home page</a>
    </button>


    <form action="/vehicle" method="post">
        <input type="hidden" name="id" value="${vehicle.getId()}">
        <div class="form-group">
            <label for="name">Name Vehicle:</label>
            <input type="text" class="form-control" id="name" name="name" value="${vehicle.getNameVehicle()}">
        </div>
        <div class="form-group">
            <label for="year">Year Manufactured:</label>
            <input type="date" class="form-control" id="year" name = "year" value="${vehicle.getYearManufactured()}">
        </div>
        <div class="form-group">
            <label for="color">Color:</label>
            <input type="text" class="form-control" id="color" name = "color" value="${vehicle.getColor()}">
        </div>
        <div class="form-group">
            <label for="price">Price:</label>
            <input type="number" class="form-control" id="price" name = "price" value="${vehicle.getPrice()}">
        </div>
        <div class="form-group">
            <label for="province">Province:</label>
            <select name="idProvince" id="province">
                <c:forEach items="${provinceList}" var="provinceList">
                    <option value="${provinceList.getCode()}">${provinceList.getName()}</option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <label for="idperson">ID Person(Can cuoc cong dan):</label>
            <input type="number" class="form-control" id="idperson" name = "idPerson" value="${vehicle.getIdPerson()}">
        </div>


        <c:if test="${vehicle.getTypeVehicle().equals('Car')}">
            <div class="form-group">
                <label for="typeVehicle">Type vehicle:</label>
                <select id="typeVehicle" name="typeVehicle" aria-readonly="true">
                    <option value="Car">Car</option>
                </select>
            </div>
            <div id="car">
                <div class="form-group">
                    <label for="numberSeat" >NumberSeat:</label>
                    <input type="number" class="form-control" id = "numberSeat"  name = "numberSeat">
                </div>
            </div>
        </c:if>
        <c:if test="${vehicle.getTypeVehicle().equals('Motorbike')}">
            <div class="form-group">
                <label for="typeVehicleMotor">Type vehicle:</label>
                <select id="typeVehicleMotor" name="typeVehicle" aria-readonly="true">
                    <option value="Motorbike">Motorbike</option>
                </select>
            </div>
            <div id="motorbike">
                <div class="form-group">
                    <label for="speed">Speed:</label>
                    <input type="number" class="form-control" id="speed" name = "speed">
                </div>
            </div>
        </c:if>

        <button type="submit" class="btn btn-primary" name="action" value="updateVehicleForm">Update Vehicle</button>
    </form>
</div>

</body>
</html>
