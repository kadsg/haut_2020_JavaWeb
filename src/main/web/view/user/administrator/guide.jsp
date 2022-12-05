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
<link rel="stylesheet" href="${pageContext.request.contextPath}/image/css/div.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/image/css/guide.css">
<body>
    <div class="guide">
        <a href="${pageContext.request.contextPath}/view/user/administrator/addItem/addItem.jsp">发布运动会项目</a>
        <a href="${pageContext.request.contextPath}/QueryItemServlet?identity=administrator">赛事查看</a>
        <a href="${pageContext.request.contextPath}/AnnounceViewServlet">运动项目成绩公布</a>
        <a href="${pageContext.request.contextPath}/DisplayScoreIndexServlet?identity=administrator">查看项目成绩</a>
        <a href="${pageContext.request.contextPath}/">登出</a>
    </div>
</body>
</html>
