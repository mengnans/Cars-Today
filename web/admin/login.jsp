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

    <link rel="stylesheet" href="../styles/login.css"/>
    <title>Administrator log in</title>
</head>
<body>
<div>
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="/admin/home">Admin Mode</a>
            </div>
            <ul class="nav navbar-nav">
                <li class="active"><a href="/login">User Mode</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/admin/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
            </ul>
        </div>
    </nav>

    <div class="container-fluid my-form">
        <div class="alert alert-info">
            <strong>Tip:</strong> The admin name and password are written in our report's instruction section.
        </div>
        <form action="/admin/login" method="post">
            <div class="form-group">
                <label for="adminName">Admin Name:</label>
                <input type="text" class="form-control" id="adminName" placeholder="Enter your admin name"
                       name="adminName">
            </div>
            <div class="form-group">
                <label for="pwd">Password:</label>
                <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="password">
            </div>
            <button type="submit" class="btn btn-default">Submit</button>
            <br/>
        </form>

    </div>


</div>

</div>

</body>
</html>
