<%--
  Created by IntelliJ IDEA.
  User: kadsg
  Date: 2022/12/2
  Time: 0:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
    <div>
        <form action="${pageContext.request.contextPath}/LoginServlet">
            <label for="account">请输入账号</label>
            <input type="text" id="account" name="account">
            <label for="password">请输入密码</label>
            <input type="text" id="password" name="password">
            <p>请选择登录身份</p>
            <label for="administrator">管理员</label>
            <input type="radio" name="identity" id="administrator" value="administrator">
            <label for="referee">裁判</label>
            <input type="radio" name="identity" id="referee" value="referee">
            <label for="player">运动员</label>
            <input type="radio" name="identity" id="player" value="player">
            <label for="volunteer">志愿者</label>
            <input type="radio" name="identity" id="volunteer" value="volunteer">
            <input type="submit" value="登录">
            <a href="${pageContext.request.contextPath}/view/register/index.jsp">没有账号？点击注册</a>
        </form>
    </div>
</body>
</html>
