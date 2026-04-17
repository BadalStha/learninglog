<%@ page import="com.learninglog.learninglogproject.user.model.User" %><%--
  Created by IntelliJ IDEA.
  User: badal
  Date: 3/30/26
  Time: 9:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        User userDataObj = (User) session.getAttribute("user");
    %>

    <h1>
        Name: <%= userDataObj.getName() %>
    </h1>
    <h2>
        Name: <%= userDataObj.getId() %>
    </h2>

    <a href="/pages/add-topic.jsp">Add Topic</a>
</body>
</html>
