<%--
  Created by IntelliJ IDEA.
  User: macbookpro
  Date: 3/30/22
  Time: 9:26 PM
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

<table class="table table-dark">
    <tr>
        <th>
            id
            <td>${user.id}</td>
        </th>
    </tr>
    <tr>
        <th>
            userName
            <td>${user.userName}</td>
        </th>
    </tr>
    <tr>
        <th>
            fullName
        <td>${user.fullName}</td>
        </th>
    </tr>
    <tr>
        <th>
            password
        <td>${user.password}</td>
        </th>
    </tr>

    <tr>
        <td>
            <a href="user?page=userEdit&id=${user.id}">Edit</a>
        </td>
        <td>
            <a href="user?page=userDelete&id=${user.id}">DELETE</a>
        </td>
    </tr>
</table>
</body>
</html>
