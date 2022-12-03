<%@ page import="bean.item.Item" %>
<%@ page import="java.util.List" %>
<%@ page import="bean.Marking" %>
<%@ page import="bean.user.Player" %><%--
  Created by IntelliJ IDEA.
  User: kadsg
  Date: 2022/12/3
  Time: 12:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Item item = (Item) request.getAttribute("item");
    List<Player> playerList = (List<Player>) request.getAttribute("playerList");
    List<Marking> markingList = (List<Marking>) request.getAttribute("markingList");
%>
<html>
<head>
    <title><%=item.getName()%>判分表</title>
</head>
<body>
    <jsp:include page="guide.jsp"/>
    <form action="/MarkingServlet">
        <p><%=item.getName()%>判分表</p>
        <table>
            <tr>
                <th>运动员编号</th>
                <th>姓名</th>
                <th>成绩</th>
            </tr>
        <%
            if (markingList != null)
                for (int i = 0; i < markingList.size(); ++i) {
        %>
            <tr>
                <td><%=markingList.get(i).getId_player()%></td>
                <td><%=playerList.get(i).getName()%></td>
                <td><input type="text" name="gradeOf<%=markingList.get(i).getId_player()%>" value="<%=markingList.get(i).getGrade()%>"></td>
            </tr>
        <%
                }
        %>
        </table>
        <%
            if (markingList != null) {
        %>
        <%--项目编号--%>
        <input type="hidden" name="id" value="<%=item.getId()%>">
        <input type="submit" value="提交">
        <%
            }
        %>
    </form>
</body>
</html>
