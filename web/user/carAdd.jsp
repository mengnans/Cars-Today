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
    <title>Add new car</title>
</head>
<body>
<div>
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="navbar-header">
            <a class="navbar-brand" href="/home">Admin Mode</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="/login">User Mode</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/logout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
        </ul>
</div>
</nav>

<div class="container-fluid my-form" style="margin-top: 64px">
    <form action="/user/car/add" method="post">

        <div class="form-group">
            <label for="brand">Brand:</label>
            <input type="text" class="form-control" id="brand" placeholder="Enter the Brand" name="brand">
        </div>

        <div class="form-group">
            <label for="car_type">Car Type:</label>
            <input type="text" class="form-control" id="car_type" placeholder="Enter the Car Type" name="car_type">
        </div>

        <div class="form-group">
            <label for="car_name">Car Name:</label>
            <input type="text" class="form-control" id="car_name" placeholder="Enter the Car Name" name="car_name">
        </div>

        <div class="form-group">
            <label for="transmission">Transmission:</label>
            <input type="text" class="form-control" id="transmission" placeholder="Enter the Transmission"
                   name="transmission">
        </div>

        <div class="form-group">
            <label for="engine_type">Engine Type:</label>
            <input type="text" class="form-control" id="engine_type" placeholder="Enter the Engine Type"
                   name="engine_type">
        </div>

        <div class="form-group">
            <label for="image">Image:</label>
            <input type="text" class="form-control" id="image" placeholder="Enter the Image" name="image">
        </div>

        <div class="form-group">
            <label for="price">Price:</label>
            <input type="number" class="form-control" id="price" placeholder="Enter the Price" name="price" min="0"
                   max="100000000">
        </div>

        <div class="form-group">
            <label for="description">Description:</label>
            <input type="text" class="form-control" id="description" placeholder="Enter the Description"
                   name="description">
        </div>

        <div class="form-group">
            <label for="location">Location:</label>
            <input type="text" class="form-control" id="location" placeholder="Enter the Location" name="location">
        </div>

        <div class="form-group">
            <label for="location">Mileage:</label>
            <input type="number" class="form-control" id="milage" placeholder="Enter the Milage" name="milage" min="0"
                   max="1000000">
        </div>

        <div class="form-group">
            <input type="hidden" class="form-control" id="stock" placeholder="Enter the Stock" name="stock" value="1">
        </div>

        <div class="form-group">
            <input type="hidden" class="form-control" id="seller_id" placeholder="Enter the Stock" name="seller_id"
                   value=<%=(request.getAttribute("userId"))%>>
        </div>

        <button type="submit" class="btn btn-default">Submit</button>
    </form>
</div>


</div>

</div>

</body>
</html>
