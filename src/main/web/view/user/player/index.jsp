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
<head>
    <title>运动员界面</title>
</head>
<body>
    <jsp:include page="guide.jsp"/>
</body>
</html>
