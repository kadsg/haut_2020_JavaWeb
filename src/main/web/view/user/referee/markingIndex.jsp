<%@ page import="java.util.List" %>
<%@ page import="bean.item.Item" %><%--
  Created by IntelliJ IDEA.
  User: kadsg
  Date: 2022/12/3
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Item> itemList = (List<Item>) request.getAttribute("itemList");
%>
<html>
<head>
    <title>赛事评判</title>
</head>
<body>
    <jsp:include page="guide.jsp"/>
    <div id="table">
        <p>加入赛事裁判组</p>
        <table>
            <tr>
                <th>项目编号</th>
                <th>名称</th>
                <th>规则（点击查看）</th>
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
                <td><a href="/MarkingPageServlet?id=<%=item.getId()%>">进入</a></td>
            </tr>
            <%
                    }
                }
            %>
        </table>
    </div>
</body>
</html>
