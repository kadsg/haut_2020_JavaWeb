<%--
  Created by IntelliJ IDEA.
  User: kadsg
  Date: 2022/12/3
  Time: 9:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>裁判员导航条</title>
</head>
<body>
    <div id="guide">
        <a href="${pageContext.request.contextPath}/QueryItemServlet?identity=referee">赛事查看</a>
        <a href="${pageContext.request.contextPath}/RefereeSignUpViewServlet">加入赛事裁判组</a>
        <a href="${pageContext.request.contextPath}/MarkingIndexServlet">赛事评判</a>
        <a href="${pageContext.request.contextPath}/">登出</a>
    </div>
</body>
</html>
