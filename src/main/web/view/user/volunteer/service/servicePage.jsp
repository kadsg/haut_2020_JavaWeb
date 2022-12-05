<%@ page import="bean.item.Item" %>
<%@ page import="java.util.List" %>
<%@ page import="bean.user.Player" %><%--
  Created by IntelliJ IDEA.
  User: kadsg
  Date: 2022/12/4
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  Item item = (Item) request.getAttribute("item");
  List<Player> playerList = (List<Player>) request.getAttribute("playerList");
%>
<html>
<head>
    <title><%=item.getName()%>志愿者服务</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/image/css/table.css">
<body>
    <jsp:include page="../index.jsp"/>
    <div>
      <table>
        <tr>
          <th>运动员编号</th>
          <th>运动员姓名</th>
          <th>动作</th>
        </tr>
        <%
          if (playerList != null) {
            for (Player player : playerList) {
        %>
        <tr>
          <td><%=player.getAccount()%></td>
          <td><%=player.getName()%></td>
          <td><a href="${pageContext.request.contextPath}/view/user/volunteer/service/service.jsp?id_item=<%=item.getId()%>&id_player=<%=player.getAccount()%>">登记</a></td>
        </tr>
        <%
            }
          }
        %>
      </table>
    </div>
</body>
</html>
