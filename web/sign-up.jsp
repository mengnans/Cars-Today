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

    <link rel="stylesheet" href="styles/sign-up.css"/>
    <title>Sign up</title>
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
                <li><a href="/sign-up.jsp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                <li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
            </ul>
        </div>
    </nav>

    <div class="container-fluid my-form">
        <form action="/sign-up" method="post">
            <div class="form-group">
                <label for="userName">Username:</label>
                <input type="text" class="form-control" id="userName" placeholder="Enter your user name" name="userName">
            </div>
            <div class="form-group">
                <label for="pwd">Password:</label>
                <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="password">
            </div>
            <div class="form-group">
                <label for="repeatPwd">Repeat Password:</label>
                <input type="password" class="form-control" id="repeatPwd" placeholder="Enter password again" name="repeatPassword">
            </div>
            <button type="submit" class="btn btn-default">Submit</button>
        </form>

    </div>


</div>

</div>


</body>
</html>
