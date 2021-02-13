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
  <form action="${pageContext.request.contextPath}/admin/checkLogin" method="post">
    <input type="text" name="userName">
    <input type="text" name="password">
    <input type="submit">
  </form>
  </body>
</html>
