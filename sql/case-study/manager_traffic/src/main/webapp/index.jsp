<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
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
        <a href="/province">Province</a>
    </button>

    <button class="btn btn-default">
        <a href="/person">Person</a>
    </button>
    <form action="vehicle" method="get">
        <button class="btn btn-default" name="action">
            Vehicle
        </button>
        <input type="hidden" name="typeVehicle" value="">
    </form>

</div>
</body>
</html>