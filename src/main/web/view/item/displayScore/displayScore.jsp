<%@ page import="bean.item.Item" %>
<%@ page import="java.util.List" %>
<%@ page import="bean.Score" %>
<%@ page import="bean.user.Player" %><%--
  Created by IntelliJ IDEA.
  User: kadsg
  Date: 2022/12/4
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>赛事成绩</title>
</head>
<%
    Item item = (Item) request.getAttribute("item");
    List<Score> scoreList = (List<Score>) request.getAttribute("scoreList");
    List<Player> playerList = (List<Player>) request.getAttribute("playerList");

%>
<body>
    <div>
        <p><%=item.getName()%>赛事成绩</p>
        <table id="table">
            <tr>
                <th>选手编号</th>
                <th>选手姓名</th>
                <th>得分</th>
                <th>排名</th>
            </tr>
            <%
                if (scoreList != null)
                    for (int i = 0 ; i < scoreList.size(); ++i) {
            %>
            <tr>
                <td><%=playerList.get(i).getAccount()%></td>
                <td><%=playerList.get(i).getName()%></td>
                <td><%=scoreList.get(i).getScore()%></td>
                <td><%=scoreList.get(i).getRank()%></td>
            </tr>
            <%
                    }
            %>
        </table>
    </div>
</body>
</html>
