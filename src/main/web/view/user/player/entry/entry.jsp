<%@ page import="bean.EventPlayer" %>
<%@ page import="java.util.List" %>
<%@ page import="bean.item.Item" %>
<%@ page import="bean.user.User" %><%--
  Created by IntelliJ IDEA.
  User: kadsg
  Date: 2022/12/2
  Time: 23:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User user = (User) session.getAttribute("user");
    // 运动员参赛表
    List<EventPlayer> eventPlayerList = (List<EventPlayer>) request.getAttribute("eventPlayerList");
    // 对应参赛项，下标对应
    List<Item> itemList = (List<Item>) request.getAttribute("itemList");
%>
<html>
<head>
    <title>参加赛事</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/image/css/table.css">
<body>
    <jsp:include page="../index.jsp"/>
    <div>
        <p>参加赛事</p>
        <table>
            <tr>
                <th>项目编号</th>
                <th>名称</th>
                <th>规则</th>
                <th>比赛时间</th>
                <th>比赛地点</th>
                <th>动作</th>
            </tr>
            <%
                if (eventPlayerList != null) {
                    for (int i = 0; i < eventPlayerList.size(); ++i) {
            %>
            <tr>
                <td><%=itemList.get(i).getId()%>
                </td>
                <td><%=itemList.get(i).getName()%>
                </td>
                <td><a href="${pageContext.request.contextPath}/view/item/displayRule.jsp?rule=<%=itemList.get(i).getRule()%>" target="_blank">查看</a></td></td>
                <td><%=itemList.get(i).getTime()%>
                </td>
                <td><%=itemList.get(i).getPlace()%>
                </td>

                    <%
                // 未参赛
                if (!eventPlayerList.get(i).isJoin()) {
            %>
                <td><a href="${pageContext.request.contextPath}/EntryServlet?id_player=<%=user.getAccount()%>&id_item=<%=itemList.get(i).getId()%>">参赛</a></td>
                    <%
                } else {
            %>
                <td>已参赛</td>
                    <%
                }
                }
            }
            %>
        </table>
    </div>
</body>
</html>
