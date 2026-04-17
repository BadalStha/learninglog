<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="com.learninglog.learninglogproject.topic.model.Topic" %><%--
  Created by IntelliJ IDEA.
  User: badal
  Date: 4/9/26
  Time: 8:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/components/header.jsp"/>
<html>
<head>
    <title>Topics</title>
</head>
<body>
TopicList


<table border="1">
  <tr>
    <th>Id</th>
    <th>Name</th>
    <th>UserId</th>
    <th>CreatedDate</th>
  </tr>
  <tbody>
  <c:forEach var="t" items="${topics}">
    <tr>
      <td>${t.getId()}</td>
      <td>${t.getName()}</td>
      <td>${t.getUser_id()}</td>
      <td>${t.getCreatedAt()}</td>

      <td>
        <a href="topic?page=edit&id=${t.getId()}">Edit</a>
        <a href="topic?page=delete&id=${t.getId()}">Delete</a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
<jsp:include page="/components/footer.jsp"/>
