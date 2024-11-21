<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<br/>
<form class="form-horizontal" action="calculator" method="get">

  <div class="form-group">
    <label class="control-label col-sm-2" for="num_first">First operand</label>
    <div class="col-sm-6">
      <input type="number" name="num_first" id="num_first" placeholder="Enter number">
    </div>
  </div>

  <div class="form-group">
    <label class="control-label col-sm-2" for="select">Operator:</label>
    <div class="col-sm-6">
      <select name="valueselect" id="select">
        <option value="add">add</option>
        <option value="subtraction">subtraction</option>
        <option value="division">division</option>

      </select>
    </div>
  </div>

  <div class="form-group">
    <label class="control-label col-sm-2" for="num_second">Second operand:</label>
    <div class="col-sm-6">
      <input type="number" name="num_second" id="num_second" placeholder="Enter number">
    </div>
  </div>

  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Calculator</button>
    </div>
  </div>

</form>
</body>
</html>