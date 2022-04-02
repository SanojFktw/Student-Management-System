<%--
  Created by IntelliJ IDEA.
  User: macbookpro
  Date: 3/24/22
  Time: 8:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
<%@ include file="../include/navbar.jsp" %>

<div class="container">
<form action="user?page=editUser" method="post">
    <div class="form-group">
        <label>Email address</label>
        <input type="text" class="form-control" placeholder="Enter username" name="userName" value="${user.userName}">
    </div>

    <div class="form-group">
        <label>Password</label>
        <input type="password" class="form-control" placeholder="Password" name="password" value="${user.password}">
    </div>

    <div class="form-group">
        <label>Password</label>
        <input type="text" class="form-control" placeholder="fullName" name="fullName" value="${user.fullName}">
    </div>

    <input type="hidden" name="id" value="${user.id}">

    <button type="submit" class="btn btn-primary">UPDATE USER</button>
</form>
</div>
<%--<form action="user?page=editUser" method="post">--%>
<%--ID    <input type="hidden" name="id" value="${user.id}">--%>
<%--UserName    <input type="text" name="username" value="${user.userName}" required="" placeholder="Type in your username"></br>--%>
<%--Password    <input type="password" name="password" required="" placeholder="Type in your password"></br>--%>
<%--fullName    <input type="text" name="fullname" value="${user.fullName}" required="" placeholder="Type in your fullName"></br>--%>
<%--<input type="submit" value="update user"></br>--%>
<%--</form>--%>

</body>
</html>
