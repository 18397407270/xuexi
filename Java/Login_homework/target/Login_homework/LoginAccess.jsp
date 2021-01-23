<%--
  Created by IntelliJ IDEA.
  User: hzh
  Date: 2020/12/15
  Time: 16:08:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% String name = (String)application.getAttribute("name");
    String password = (String)application.getAttribute("password");
%>
账户名:<%out.println(name);%>
密码:<%out.println(password);%>
</body>
</html>
