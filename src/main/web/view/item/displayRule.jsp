<%--
  Created by IntelliJ IDEA.
  User: kadsg
  Date: 2022/12/5
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>项目规则</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/image/css/div.css">
<body>
    <div>
      <h4><%=request.getParameter("rule")%></h4>
    </div>
</body>
</html>
