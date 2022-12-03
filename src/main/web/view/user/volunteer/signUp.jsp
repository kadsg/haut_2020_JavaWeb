<%@ page import="bean.EventVolunteer" %>
<%@ page import="java.util.List" %>
<%@ page import="bean.item.Item" %><%--
  Created by IntelliJ IDEA.
  User: kadsg
  Date: 2022/12/3
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  List<Item> itemList = (List<Item>) request.getAttribute("itemList");
  List<EventVolunteer> signUpList = (List<EventVolunteer>) request.getAttribute("signUpList");
%>
<html>
<head>
    <title>赛事志愿组</title>
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

        <%
                boolean isSignUp = false;
                // 报名表非空
                if (signUpList != null)
                    for (EventVolunteer eventVolunteer : signUpList)
                        if (eventVolunteer.getId_item().equals(item.getId()))
                            isSignUp = true;

                if (isSignUp) {
            %>
      <td>已加入</td>
        <%
                } else {
            %>
      <td><a href="${pageContext.request.contextPath}/VolunteerSignUpServlet?id=<%=item.getId()%>">点击加入</a></td>
        <%
                }
                }
            }
            %>
  </table>
</div>
</body>
</html>
