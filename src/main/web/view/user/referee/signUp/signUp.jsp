<%@ page import="bean.item.Item" %>
<%@ page import="java.util.List" %>
<%@ page import="bean.EventPlayer" %>
<%@ page import="bean.EventReferee" %><%--
  Created by IntelliJ IDEA.
  User: kadsg
  Date: 2022/12/2
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Item> itemList = (List<Item>) request.getAttribute("itemList");
    List<EventReferee> signUpList = (List<EventReferee>) request.getAttribute("signUpList");
%>
<html>
<head>
    <title>赛事裁判组</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/image/css/table.css">
<body>
<jsp:include page="../index.jsp"/>
<div id="table">
    <h3>加入赛事裁判组</h3>
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
            <td><a href="${pageContext.request.contextPath}/view/item/displayRule.jsp?rule=<%=item.getRule()%>" target="_blank">查看</a></td></td>
            <td><%=item.getTime()%>
            </td>
            <td><%=item.getPlace()%>
            </td>

            <%
                boolean isSignUp = false;
                // 报名表非空
                if (signUpList != null)
                    for (EventReferee eventReferee : signUpList)
                        if (eventReferee.getId_item().equals(item.getId()))
                            isSignUp = true;

                if (isSignUp) {
            %>
            <td>已加入</td>
            <%
                } else {
            %>
            <td><a href="/RefereeSignUpServlet?id=<%=item.getId()%>">点击加入</a></td>
            <%
                }
                }
            }
            %>
    </table>
</div>
</body>
</html>