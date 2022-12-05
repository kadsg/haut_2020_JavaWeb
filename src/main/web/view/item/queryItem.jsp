<%@ page import="bean.item.Item" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: kadsg
  Date: 2022/12/2
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Item> itemList = (List<Item>) request.getAttribute("itemList");
%>
<html>
<head>
    <title>赛事查看</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/image/css/table.css">
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
                <th>状态</th>
            </tr>
            <%
                String message = null;
                if (itemList != null) {
                    for (Item item : itemList) {
                        if (item.isIs_over())
                            message = "已结束";
                        else
                            message = "进行中";
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
            <%
                if (message.equals("进行中")) {
            %>
                <td style="color: darkgreen"><%=message%>
                </td>
            <%
                } else {
            %>
                <td style="color: red"><%=message%>
                </td>
            </tr>
            <%
                        }
                    }
                }
            %>
        </table>
    </div>
</body>
</html>
