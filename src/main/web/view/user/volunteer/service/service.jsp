<%--
  Created by IntelliJ IDEA.
  User: kadsg
  Date: 2022/12/4
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>志愿服务登记</title>
</head>
<body>
    <jsp:include page="../index.jsp"/>
    <div>
      <form action="${pageContext.request.contextPath}/ServiceServlet">
        <label for="time">选择服务时间</label>
        <input type="datetime-local" step="01" id="time" name="time"> <br><br>
        <label for="message">填写服务信息</label><textarea name="message" id="message" cols="30" rows="10"></textarea>
        <input type="hidden" id="id_item" name="id_item" value="<%=request.getParameter("id_item")%>">
        <input type="hidden" id="id_player" name="id_player" value="<%=request.getParameter("id_player")%>"> <br>
        <input type="submit" value="提交">
      </form>
    </div>
</body>
</html>
