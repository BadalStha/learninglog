<%@ page import="com.learninglog.learninglogproject.user.model.User" %><%--
  Created by IntelliJ IDEA.
  User: badal
  Date: 4/3/26
  Time: 8:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<%
    User userObj = (User) session.getAttribute("user");
    int id = 0;
    if (userObj != null) {
        id = userObj.getId();
    }
%>

<body>
    <form method="post" action="topic">
        <input type="hidden" value="add" name="action">

        <label>UserId</label>
        <input type="text" value="<%=id%>" name="user-id">
        <label>Topic Name</label>
        <input type="text" name="topic-name">
        <button>Submit</button>
    </form>
</body>
</html>
