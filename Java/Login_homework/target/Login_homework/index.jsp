<%@ page language="java" contentType="text/html;charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<form action="Login.jsp" method="post">
    <table cellpadding="2" align="center">
        <tr>
            <td align="right">用户名:</td>
            <td>
                <label>
                    <input type="text" name="name" />
                </label>
            </td>
        </tr>
        <tr>
            <td align="right">密码:</td>
            <td>
                <label>
                    <input type="password" name="password" />
                </label>
            </td>
        </tr>
        <tr >
            <td colspan="2" align="center" >
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="登陆" />
            </td>
        </tr>
    </table>
</form>

</body>
</html>
