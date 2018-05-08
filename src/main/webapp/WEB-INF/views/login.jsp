<%--
  Created by IntelliJ IDEA.
  User: E-LINTER-002
  Date: 2018/1/1
  Time: 18:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login page</title>
</head>
<body>
<form action="http://localhost:9092/login" method="post">
    <input type="text" name="username"/>
    <input type="text" name="password"/>
    <input type="submit" value="login"/>
</form>
</body>
</html>
