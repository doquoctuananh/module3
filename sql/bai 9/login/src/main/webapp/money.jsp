<%--
  Created by IntelliJ IDEA.
  User: Tuấn Anh
  Date: 11/20/2024
  Time: 9:02 AM
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
  <form action="money" method="get" class="container-lg">
    <div class="form-group">
      <label for="exchange_rate">Nhap ti gia</label>
      <input type="number" class="form-control" placeholder="Nhap ti gia" id="exchange_rate" name="exchange_rate">
    </div>
    <div class="form-group">
      <label for="usd">Nhap usd chuyen doi</label>
      <input type="number" class="form-control" placeholder="so usd tien muon chuyen doi" id="usd" name="usd">
    </div>

    <button type="submit" class="btn btn-primary">Chuyen doi</button>
  </form>
  <p>So tien chuyen doi duoc la : ${money} VND</p>
  </body>
</html>
