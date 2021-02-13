<%--
  Created by IntelliJ IDEA.
  User: 29659
  Date: 2021/2/12
  Time: 18:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <p>openId的值为：${pageContext.getSession().getAttribute("openId")}</p>
  <form action="${pageContext.request.contextPath}/admin/checkLogin" method="post">
    <input type="text" name="userName">
    <input type="text" name="password">
    <input type="submit">
  </form>
  <form action="${pageContext.request.contextPath}/admin/checkOpenId" method="post">
    <input type="text" name="openId" value="${pageContext.getSession().getAttribute("openId")}">
    <input type="submit">
  </form>
  </body>
</html>
