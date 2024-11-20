<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: Tuấn Anh
  Date: 11/20/2024
  Time: 9:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <form action="dictionary" method="post" class="col-lg-6 offset-3 mt-lg-5">
        <span>Enter word: </span>
        <input type="text" name="dictionary">
        <button type="submit" class="btn btn-primary"> search</button>
    </form>
    <span> Ket qua : ${result}</span>

</body>
</html>
