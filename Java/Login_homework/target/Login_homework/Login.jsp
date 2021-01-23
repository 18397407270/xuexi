<%--
  Created by IntelliJ IDEA.
  User: hzh
  Date: 2020/12/15
  Time: 15:55:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%  String username= request.getParameter("name");
    String password=request.getParameter("password");

    application.setAttribute("name",username);
    application.setAttribute("password",password);
%>


<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="LoginAccess.jsp">查询账户名与账户密码</a>
</body>
</html>
