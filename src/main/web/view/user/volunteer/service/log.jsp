<%@ page import="java.util.List" %>
<%@ page import="bean.Log" %>
<%@ page import="bean.user.Player" %>
<%@ page import="bean.item.Item" %><%--
  Created by IntelliJ IDEA.
  User: kadsg
  Date: 2022/12/4
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Log> logList = (List<Log>) request.getAttribute("logList");
    List<Player> playerList = (List<Player>) request.getAttribute("playerList");
    List<Item> itemList = (List<Item>) request.getAttribute("itemList");
%>
<html>
<head>
    <title>志愿服务记录</title>
</head>
<body>
    <jsp:include page="../guide.jsp"/>
    <div>
        <table id="table">
            <tr>
                <th>赛事编号</th>
                <th>赛事名称</th>
                <th>运动员编号</th>
                <th>运动员姓名</th>
                <th>服务时间</th>
                <th>备注</th>
            </tr>
            <%
                if (logList != null) {
                    for (int i = 0; i < logList.size(); ++i) {
            %>
            <tr>
                <td><%=itemList.get(i).getId()%></td>
                <td><%=itemList.get(i).getName()%></td>
                <td><%=playerList.get(i).getAccount()%></td>
                <td><%=playerList.get(i).getName()%></td>
                <td><%=logList.get(i).getMessage()%></td>
                <td><%=logList.get(i).getTime()%></td>
            </tr>
            <%
                    }
                }
            %>
        </table>
    </div>
</body>
</html>
