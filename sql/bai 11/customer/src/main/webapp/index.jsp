<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<form action="/customer" method="get">
    <button type="submit" class="btn btn-primary" name="action" value="showAll">Show all Customer</button>

</form>
</br>
<form action="/customer" method="get">
    <button type="submit" class="btn btn-error" name="action" value="create" >Create Customer</button>
</form>


</body>
</html>