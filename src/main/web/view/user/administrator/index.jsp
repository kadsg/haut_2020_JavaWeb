<%@ page import="bean.user.User" %>
<%@ page import="bean.user.Administrator" %><%--
  Created by IntelliJ IDEA.
  User: kadsg
  Date: 2022/12/2
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员界面</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/image/css/header.css">
<body>
    <div class="header"><h3>欢迎使用河南工业大学运动会管理系统</h3></div>
    <jsp:include page="guide.jsp"/>
</body>
</html>
