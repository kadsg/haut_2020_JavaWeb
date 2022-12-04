<%--
  Created by IntelliJ IDEA.
  User: kadsg
  Date: 2022/12/2
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>导航条</title>
</head>
<body>
    <div id="guide">
        <a href="addItem.jsp">发布运动会项目</a>
        <a href="${pageContext.request.contextPath}/QueryItemServlet?identity=administrator">赛事查看</a>
        <a href="">运动项目成绩公布</a>
        <a href="${pageContext.request.contextPath}/">登出</a>
    </div>
</body>
</html>
