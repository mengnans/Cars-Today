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

    <link rel="stylesheet" href="styles/login.css"/>
    <title>Log in</title>
</head>
<body>
<div>
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="/home">Cars Today</a>
            </div>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/order"><span class="glyphicon glyphicon-user"></span> My Orders</a></li>
                <li><a href="/logout"><span class="glyphicon glyphicon-log-in"></span> Log out</a></li>
            </ul>
        </div>
    </nav>

    <div class="container-fluid my-form">
        <form action="/purchase" method="post">
            <div class="form-group">
                <input type="hidden" class="form-control" id="cid" name="cid" value="${cid}">
            </div>
            <div class="form-group">
                <label for="address">Address:</label>
                <input type="text" class="form-control" id="address" placeholder="Enter your address" name="address">
            </div>
            <div class="form-group">
                <label for="phone">Phone:</label>
                <input type="text" class="form-control" id="phone" placeholder="Enter your phone number" name="phone">
            </div>
            <button type="submit" class="btn btn-default">Purchase</button>
        </form>

    </div>


</div>

</div>

</body>
</html>
