<%--
  Created by IntelliJ IDEA.
  User: kadsg
  Date: 2022/12/2
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>运动员导航条</title>
</head>
<body>
    <div id="guide">
        <a href="${pageContext.request.contextPath}/QueryItemServlet?identity=player">赛事查看</a>
        <a href="${pageContext.request.contextPath}/PlayerSignUpViewServlet">赛事报名</a>
        <a href="${pageContext.request.contextPath}/EntryViewServlet">参加赛事</a>
        <a href="">查看成绩</a>
    </div>
</body>
</html>
