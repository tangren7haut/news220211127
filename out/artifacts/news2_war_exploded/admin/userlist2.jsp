<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2021/11/29
  Time: 9:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <title>Title</title>
</head>
<body>
<table class="table table-bordered">
    <tr>
        <th>id</th>
        <th>用户名</th>
        <th>密码</th>
        <th>邮箱</th>
    </tr>
    <c:forEach items="${requestScope.userlist}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.uname}</td>
            <td>${user.upwd}</td>
            <td>${user.email}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
