<%--
  Created by IntelliJ IDEA.
  User: kadsg
  Date: 2022/12/3
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>志愿者导航条</title>
</head>
<body>
    <div id="guide">
        <a href="${pageContext.request.contextPath}/QueryItemServlet?identity=volunteer">赛事查看</a>
        <a href="${pageContext.request.contextPath}/VolunteerSignUpViewServlet">加入赛事志愿组</a>
        <a href="${pageContext.request.contextPath}">志愿服务登记</a>
        <a href="${pageContext.request.contextPath}">我的志愿服务</a>
        <a href="${pageContext.request.contextPath}/DisplayScoreIndexServlet?identity=volunteer">查看项目成绩</a>
        <a href="${pageContext.request.contextPath}/">登出</a>
    </div>
</body>
</html>
