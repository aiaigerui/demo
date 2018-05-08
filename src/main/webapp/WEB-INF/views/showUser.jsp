<%--
  Created by IntelliJ IDEA.
  User: aiaig
  Date: 2018/3/18
  Time: 18:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>showUser</title>
</head>
<body>
<c:forEach items="${userList}" var="user">
    ${user.id}
</c:forEach>
</body>
</html>
