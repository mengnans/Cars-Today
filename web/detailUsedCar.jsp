<%--
  Created by IntelliJ IDEA.
  User: thund
  Date: 0027, August 27, 2018
  Time: 6:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="models.CarItem" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="styles/detail.css"/>
    <title>${car.carName}</title>
</head>
<body>
<div>
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="/home">Cars Today</a>
            </div>
            <ul class="nav navbar-nav">
                <li class="active"><a href="/admin/login">Admin Mode</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/order"><span class="glyphicon glyphicon-user"></span> My Orders</a></li>
                <li><a href="/logout"><span class="glyphicon glyphicon-log-in"></span> Log out</a></li>
            </ul>
        </div>
    </nav>

    <div class="container-fluid my-content">
            <img src="${car.image}" class="img-rounded img-detailed" alt="${car.carName}"/>
            <div class="car-detail-box">
                <div class="row">
                    <div class="col-sm-2"></div>
                    <div class="col-sm-4"><h2 class="my-header">${car.carName}</h2></div>
                </div>
                <div class="row">
                    <div class="col-sm-2"></div>
                    <div class="col-sm-4">Brand: ${car.brand}</div>
                    <div class="col-sm-6">Car Type: ${car.carType}</div>
                </div>
                <div class="row">
                    <div class="col-sm-2"></div>
                    <div class="col-sm-4">Transmission: ${car.transmission}</div>
                    <div class="col-sm-6">Price: ${car.price}</div>
                </div>
                <div class="row">
                    <div class="col-sm-2"></div>
                    <div class="col-sm-4">Location: ${car.location}</div>
                    <div class="col-sm-6">Mileage: ${car.milage}</div>
                </div>
                <div class="row">
                    <div class="col-sm-2"></div>
                    <div class="col-sm-4">Engine Type: ${car.engineType}</div>
                    <div class="col-sm-6">Stock: ${car.stock}</div>
                </div>
                <div class="row">
                    <div class="col-sm-2"></div>
                    <div class="col-sm-8">${car.description}</div>
                </div>
            </div>

        <div class="button-box">
            <a class="btn btn-primary my-button" href="/add-bid?cid=${car.carId}" role="button">Bid Now</a>
        </div>
    </div>


</div>

</div>

</body>
</html>
