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
    <button class="btn btn-default">
        <a href="/">Back</a>
    </button>
    <form action="/vehicle" method="get">
        <button class="btn btn-primary" name="action" value="createVehicle">
            Create Vehicle
        </button>
    </form>
    <form action="vehicle" method="get">
        <label>Filter Vehicle</label>
        <div class="dropdown">
            <select name="typeVehicle">
                <option value="">Choose Vehicle</option>
                <option value="Car">Car</option>
                <option value="Motorbike">Motorbike</option>
<%--                <option value="showAll">ShowAll</option>--%>
            </select>
            <select name="color">
                <option value="">Filter color</option>
                <option value="red">red</option>
                <option value="grey">grey</option>
                <option value="yellow">yellow</option>
                <option value="black">black</option>
                <option value="white">white</option>
                <option value="blue">blue</option>
                <option value="brown">brown</option>
            </select>
            <button class="btn btn-success" name="action" value="filterVehicle">Fillter</button>
        </div>
    </form>


    <h2>List vehicle</h2>
    <c:if test="${vehicleList.size() >0}">
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
                <th>Type</th>
                <th>Update</th>
                <th>Delete</th>
                <th>View</th>
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
                    <td>${vehicle.getTypeVehicle()}</td>
                    <td>
                            <form action="vehicle" method="get">
                                <button class="btn btn-info" name="action" value="updateVehicle">
                                        Update
                                </button>
                                <input type="hidden" name="id" value="${vehicle.getId()}">
                            </form>
                    </td>
                    <td>
                        <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#myModal_${vehicle.getId()}">Delete</button>

                        <div class="modal fade" id="myModal_${vehicle.getId()}" role="dialog">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                            <h4 class="modal-title">Delete Vehicle?</h4>
                                        </div>
                                        <div class="modal-body">
                                            <p>Do you want to Delete?</p>
                                        </div>
                                        <div class="modal-footer">
<%--                                            <button type="button" class="btn btn-default" data-dismiss="modal">No</button>--%>
<%--                                            <form action="vehicle" method="get">--%>
<%--                                                <button type="submit" class="btn btn-danger" name="action"--%>
<%--                                                        value="deleteVehicle" data-dismiss="modal">Yes--%>
<%--                                                </button>--%>
<%--                                                <input type="hidden" name="id" value="${vehicle.getId()}">--%>
<%--                                            </form>--%>
                                            <a href="/vehicle?action=deleteVehicle&id=${vehicle.getId()}"class="btn btn-danger">Yes</a>
                                        </div>
                                    </div>
                                </div>
                        </div>
                    </td>
                    <td>
                        <form action="vehicle" method="get">
                            <button class="btn btn-primary" name="action" value="viewDetailVehicle">
                                View Detail
                            </button>
                            <input type="hidden" name="id" value="${vehicle.getId()}">
                        </form>
                    </td>
                </tr>

            </c:forEach>
            </tbody>
        </table>
    </c:if>


</div>
</body>
</html>
