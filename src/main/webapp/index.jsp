<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>

<div class="main">
    <div><a href="/topic?page=list">View Topic</a></div>
    <div><a href="/topic">Add Topic</a></div>
    <div><a href="/login">Login</a></div>
    <div><a href="register">Register</a></div>
</div>

<a href="/register">Register</a>
<a href="/login">Login</a>
</body>
</html>