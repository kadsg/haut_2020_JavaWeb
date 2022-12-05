<%@ page import="java.util.List" %>
<%@ page import="bean.item.Item" %><%--
  Created by IntelliJ IDEA.
  User: kadsg
  Date: 2022/12/4
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Item> itemList = (List<Item>) request.getAttribute("itemList");
    String identity = request.getParameter("identity");
%>
<html>
<head>
    <title>赛事成绩查看</title>
</head>
<body>
<div>
    <h3>当前赛事</h3>
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
            if (itemList != null) {
                for (Item item : itemList) {
        %>
        <tr>
            <td><%=item.getId()%>
            </td>
            <td><%=item.getName()%>
            </td>
            <td><a href="${pageContext.request.contextPath}/view/item/displayRule.jsp?rule=<%=item.getRule()%>" target="_blank">查看</a></td>
            <td><%=item.getTime()%>
            </td>
            <td><%=item.getPlace()%>
            </td>
            <td><a href="${pageContext.request.contextPath}/DisplayScoreServlet?id_item=<%=item.getId()%>&identity=<%=identity%>">点击查看</a>
            </td>
        </tr>
        <%
                }
            }
        %>
    </table>
</div>
</body>
</html>
