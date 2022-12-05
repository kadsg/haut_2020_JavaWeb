<%@ page import="bean.item.Item" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: kadsg
  Date: 2022/12/4
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Item> itemOnGoingList = (List<Item>) request.getAttribute("itemOnGoingList");
    List<Item> itemHasOverList = (List<Item>) request.getAttribute("itemHasOverList");
%>
<html>
<head>
    <title>运动项目成绩公布</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/image/css/table.css">
<body>
    <jsp:include page="../index.jsp"/>
<div>
    <h3>成绩公布</h3>
    <table>
        <tr>
            <th>项目编号</th>
            <th>名称</th>
            <th>规则</th>
            <th>比赛时间</th>
            <th>比赛地点</th>
            <th>状态</th>
        </tr>
        <%
            // 正在进行的赛事
            if (itemOnGoingList != null) {
                for (Item item : itemOnGoingList) {
        %>
        <tr>
            <td><%=item.getId()%>
            </td>
            <td><%=item.getName()%>
            </td>
            <td><a href="${pageContext.request.contextPath}/view/item/displayRule.jsp?rule=<%=item.getRule()%>" target="_blank">查看</a></td></td>
            <td><%=item.getTime()%>
            </td>
            <td><%=item.getPlace()%>
            </td>
            <td><a href="${pageContext.request.contextPath}/AnnounceServlet?id_item=<%=item.getId()%>" target="_blank">成绩公布</a>
            </td>
        </tr>
        <%
                }
            }
            // 已经结束的赛事
            if (itemHasOverList != null) {
                for (Item item : itemHasOverList) {
        %>
        <tr>
            <td><%=item.getId()%>
            </td>
            <td><%=item.getName()%>
            </td>
            <td>TEST</td>
            <td><%=item.getTime()%>
            </td>
            <td><%=item.getPlace()%>
            </td>
            <td>已公布</a>
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
