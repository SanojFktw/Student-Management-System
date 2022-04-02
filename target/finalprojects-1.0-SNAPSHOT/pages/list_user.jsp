<%--
  Created by IntelliJ IDEA.
  User: macbookpro
  Date: 3/24/22
  Time: 8:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
<%--    for each ko lagi--%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<%@ include file="../include/navbar.jsp" %>
<table class="table">
    <a href="user?page=newUsers">Add a New User</a>
    <tr>
        <th scope="col">id</th>
        <th scope="col">userName</th>
        <th scope="col">fullName</th>
        <th scope="col">password</th>

    </tr>

    <c:forEach var="users" items="${userLists}">
        <tr>
            <td>${users.id}</td>
            <td>${users.userName}</td>
            <td>${users.fullName}</td>
            <td>${users.password}</td>
<%--                &id=${users.id} le url ma id dekhauxa ani teslai tya bata tanna chai request.get parameter garera servlet bata value tanne--%>
            <td><a href="user?page=userDetails&id=${users.id}">View Details</a> </td>

        </tr>
    </c:forEach>
</table>
</body>
</html>
