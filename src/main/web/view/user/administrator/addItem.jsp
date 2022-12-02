<%--
  Created by IntelliJ IDEA.
  User: kadsg
  Date: 2022/12/2
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>赛事发布</title>
</head>
<body>
    <div>
        <p>赛事发布</p>
        <form action="${pageContext.request.contextPath}/AddItemServlet">
            <label for="name">项目名</label>
            <input type="text" id="name" name="name">
            <label for="time">开赛时间</label>
            <input type="datetime-local" step="01" id="time" name="time"> <br>
            <label for="place">比赛地点</label>
            <input type="text" id="place" name="place">
            <label for="rule">赛事规则</label>
            <textarea name="rule" id="rule" cols="30" rows="10"></textarea>
            <input type="submit" value="发布">
        </form>
    </div>
</body>
</html>
