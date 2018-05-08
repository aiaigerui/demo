<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page import="org.slf4j.Logger,org.slf4j.LoggerFactory" %>
<%
    //设置返回码200，避免浏览器自带的错误页面
    response.setStatus(200);
    //记录日志
    Logger logger = LoggerFactory.getLogger("500.jsp");
    logger.error(exception.getMessage(), exception);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>500 - 服务异常  </title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

    <link href="${ctx}/assets/css/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="${ctx}/assets/css/ionicons.css" rel="stylesheet" type="text/css">
    <link href="${ctx}/assets/css/main.css" rel="stylesheet" type="text/css">
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400italic,300,400,700' rel='stylesheet' type='text/css'>
</head>

<body class="middle-content page-505">
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <h1>505</h1>
            <h2>服务异常 :( </h2>
            <hr />
            <div class="error-description">
                <p>服务发生异常。我们已经记录下本次错误，并将尽快解决这个问题. </p>
            </div>
        </div>
    </div>
</div>
</body>
</html>
