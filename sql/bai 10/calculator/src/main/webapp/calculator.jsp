<%--
  Created by IntelliJ IDEA.
  User: Tuấn Anh
  Date: 11/21/2024
  Time: 10:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<p>ket qua ${first}
    <c:if test="${selectOption =='add'}">
        <span>+</span>
    </c:if>
    <c:if test="${selectOption =='subtraction'}">
        <span>-</span>
    </c:if>
    <c:if test="${selectOption =='division'}">
        <span>/</span>
    </c:if>
    ${second} = ${result}</p>
</body>
</html>
