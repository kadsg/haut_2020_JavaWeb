<%@ page import="bean.user.User" %><%--
  Created by IntelliJ IDEA.
  User: kadsg
  Date: 2022/12/2
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  User user = (User) session.getAttribute("user");
%>
<html>
<head>
    <title>管理员界面</title>
</head>
<body>
    <jsp:include page="guide.jsp"/>
</body>
</html>
