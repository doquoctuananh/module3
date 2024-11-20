<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<%--<a href="hello-servlet">Hello Servlet</a>--%>
<form action="login" method="post" class="col-lg-4 offset-4">
    <h1>Login</h1>
    <div class="mb-3 mt-3">
        <label for="email" class="form-label">Email:</label>
        <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
    </div>
    <div class="mb-3">
        <label for="pwd" class="form-label">Password:</label>
        <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pswd">
    </div>

    <button type="submit" class="btn btn-primary">Submit</button>
    <p>${email}</p>
</form>
<h2>
    <a href="money.jsp">Page Money</a>
</h2>
<h2>
    <a href="dictionary.jsp">Page Dictionary</a>
</h2>
<h2>
    <a href="discount_calculator.jsp">Page Calculator</a>
</h2>
</body>
</html>