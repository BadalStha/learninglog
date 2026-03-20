<%--
  Created by IntelliJ IDEA.
  User: badal
  Date: 3/20/26
  Time: 8:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Register Page
    <div class="main">
        <%
            String errorMessage = (String) request.getAttribute("error");
            if (errorMessage == null){
                errorMessage="";
            }
        %>
        <%= errorMessage %>
        <form method="POST" action="register">
            <div class="input-field">
                    <label for="username">Username</label>
                    <input type="text" name="username" id="username" />
            </div>
            <div class="input-field">
                <label for="email">Email</label>
                <input type="email" name="email" id="email" />
            </div>
            <div class="input-field">
                <label for="password">Password</label>
                <input type="password" name="password" id="password" />
            </div>
            <div class="input-field">
                <button>Submit</button>
            </div>
        </form>
    </div>
</body>
</html>
