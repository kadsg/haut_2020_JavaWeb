<%@ page import="bean.user.Player" %>
<%@ page import="bean.user.User" %><%--
  Created by IntelliJ IDEA.
  User: kadsg
  Date: 2022/12/2
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  User user = (User) session.getAttribute("user");
%>
<html>
<link rel="stylesheet" href="${pageContext.request.contextPath}/image/css/header.css">
<head>
    <title>运动员界面</title>
</head>
<body>
    <div class="header"><h3>欢迎使用河南工业大学运动会管理系统</h3></div>
    <jsp:include page="guide.jsp"/>
</body>
</html>
