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

    <link rel="stylesheet" href="styles/error.css"/>
    <title>Error</title>
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
                <li><a href="/sign-up.jsp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                <li><a href="/login.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
            </ul>
        </div>
    </nav>
</div>
<div class="container-fluid my-error">
    <%=(String)request.getAttribute("error")%>
</div>
</body>
</html>
