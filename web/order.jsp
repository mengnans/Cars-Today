<%--
  Created by IntelliJ IDEA.
  User: thund
  Date: 0027, August 27, 2018
  Time: 6:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="models.Order" %>
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

    <link rel="stylesheet" href="styles/order.css"/>
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
                <li class="active"><a href="/admin/login.jsp">Admin Mode</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/order"><span class="glyphicon glyphicon-user"></span> My Orders</a></li>
                <li><a href="/logout"><span class="glyphicon glyphicon-log-in"></span> Log out</a></li>
            </ul>
        </div>
    </nav>

    <div class="container-fluid my-content">

        <c:forEach items="${orders}" var="order">
            <a href="/detail?cid=${order.getCarId()}">
                <div class="row my-row">
                    <div class="col-sm-4">
                        <img src="${order.getCarImage()}" class="img-rounded my-img" alt="$${order.getCarName()}"/>
                    </div>
                    <div class="col-sm-2" style="text-align: left"> Car Name: <br/>${order.getCarName()}
                        <br/><br/><br/>
                        Phone: <br/>${order.getPhone()}</div>
                    <div class="col-sm-2" style="text-align: left"> Date: <br/> ${order.getDate()}
                        <br/><br/><br/>
                        Address: <br/>${order.getAddress()}
                    </div>
                    <div class="col-sm-2" style="text-align: left"> Status: <br/> ${order.getStatus()} </div>
                </div>
            </a>
        </c:forEach>

    </div>


</div>

</div>

</body>
</html>
