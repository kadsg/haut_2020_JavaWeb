<%--
  Created by IntelliJ IDEA.
  User: kadsg
  Date: 2022/12/2
  Time: 0:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/image/css/div.css">
<html>
<head>
    <title>用户注册</title>
</head>
<body>
    <div>
        <form action="${pageContext.request.contextPath}/RegisterServlet">
            <label for="account">请输入账号</label>
            <input type="text" id="account" name="account">
            <label for="password">请输入密码</label>
            <input type="text" id="password" name="password">
            <label for="name">姓名</label>
            <input type="text" id="name" name="name">
            <p>请选择身份</p>
            <input type="radio" name="identity" id="administrator" value="administrator">
            <label for="administrator">管理员</label>
            <input type="radio" name="identity" id="referee" value="referee">
            <label for="referee">裁判</label>
            <input type="radio" name="identity" id="player" value="player">
            <label for="player">运动员</label>
            <input type="radio" name="identity" id="volunteer" value="volunteer">
            <label for="volunteer">志愿者</label>
            <input type="submit" value="注册">
        </form>
    </div>
</body>
</html>
