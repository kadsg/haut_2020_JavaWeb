<%@ page import="java.util.List" %>
<%@ page import="bean.item.Item" %><%--
  Created by IntelliJ IDEA.
  User: kadsg
  Date: 2022/12/4
  Time: 18:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Item> itemList = (List<Item>) request.getAttribute("itemList");
%>
<html>
<head>
    <title>志愿服务登记</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/image/css/table.css">
<body>
    <jsp:include page="../index.jsp"/>
    <div>
        <p>志愿服务登记</p>
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
                <td>TEST</td>
                <td><%=item.getTime()%>
                </td>
                <td><%=item.getPlace()%>
                </td>
                <td><a href="${pageContext.request.contextPath}/ServicePageServlet?id_item=<%=item.getId()%>">进入</a></td>
            </tr>
            <%
                    }
                }
            %>
        </table>
    </div>
</body>
</html>
