<%@ page import="models.CarItem" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: thund
  Date: 0027, August 27, 2018
  Time: 6:44 PM
  To change this template use File | Settings | File Templates.
    --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Admin home</title>
</head>
<body>

<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/admin/home">Admin Mode</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="/login.jsp">User Mode</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/admin/logout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
        </ul>
    </div>
</nav>

<div style="margin-top: 64px;font-size: 24pt;">
    &nbsp<a href="/admin/car/info">Add New Car</a>
</div>

<div class="container-fluid my-list" style="margin-top: 16px;font-size: 18pt;">
    <c:forEach items="${_lstCar}" var="_item">
        <div class="row" style="border: 1px solid grey;">
            <div class="col-sm-4">
                    <%--<a href="car?id=${_item.getCarId()}"> ${_item.getCarName()} </a>--%>
                <img src="${_item.getImage()}" style="width:25vw;">
            </div>
            <div class="col-sm-6">
                    ${_item.getCarName()}
                <ul>
                    <li>Brand: ${_item.getBrand()}</li>
                    <li>CarType: ${_item.getCarType()}</li>
                    <li>Transmission: ${_item.getTransmission()}</li>
                    <li>Only $${_item.getPrice()}</li>
                </ul>
            </div>
            <div class="col-sm-2">
                <ul>
                    <li><a href="/admin/car/info?id=${_item.getCarId()}"> Edit </a></li>
                    <li><a href="/admin/car/delete?id=${_item.getCarId()}"> Delete </a></li>
                </ul>
            </div>
        </div>
    </c:forEach>
</div>


</body>
</html>
