<%--
  Created by IntelliJ IDEA.
  User: badal
  Date: 4/17/26
  Time: 8:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <jsp:include page="/components/header.jsp"/>

    <h2>Edit Form</h2>
    <form method="post" action="edit-topic">
        Id: <input type="text" value="${topicData.id}" name="id" readonly>
        <br>
        Name: <input type="text" value="${topicData.name}" name="name">
        <button>Edit</button>
    </form>

    <jsp:include page="/components/footer.jsp"/>
</body>
</html>
