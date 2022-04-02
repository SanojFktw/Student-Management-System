<%--
  Created by IntelliJ IDEA.
  User: macbookpro
  Date: 3/23/22
  Time: 8:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="user?page=register" method = "post">
Username</br> <input type="text" name="userName" placeholder="Type in your username"></br>
Password</br> <input type="password" name="password" placeholder="Type in your password"></br>
<%--<input type="password" name="cpassword" placeholder="confirm your password">--%>
FullName</br><input type="text" name="fullName" placeholder="Type in your fullname"></br>
<input type="submit" value="Register">
</form>
</body>
</html>
