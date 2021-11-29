<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/11/10
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <title>用户列表页面</title>
</head>
<body>
<table class="table table-bordered">
    <tr>
        <th>id</th>
        <th>用户名</th>
        <th>密码</th>
        <th>邮箱</th>
    </tr>
<c:forEach items="${requestScope.pageBean.list}" var="user">
    <tr>
        <td>${user.id}</td>
        <td>${user.uname}</td>
        <td>${user.upwd}</td>
        <td>${user.email}</td>
    </tr>
</c:forEach>
</table>
<div style="float: left">
    <nav>
        <ul class="pagination">
            <%-- 判断是否是第一页--%>
            <c:if test="${pageBean.currentPage==1}">
                <li class="disabled"><span aria-hidden="true">&laquo;</span></li>
            </c:if>
            <c:if test="${pageBean.currentPage!=1}">
                <li>
                    <a href="${pageContext.request.contextPath}/getusersbypage?currentPage=${pageBean.currentPage-1}&rows=3"
                       aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
            </c:if>
            <c:forEach var="i" varStatus="s" step="1" begin="1" end="${pageBean.totalPage}">
                <c:if test="${pageBean.currentPage == i}">
                    <li class="active">
                        <a href="${pageContext.request.contextPath}/getusersbypage?currentPage=${i}&rows=3"
                           name="li">${i}</a></li>
                </c:if>
                <c:if test="${pageBean.currentPage != i}">
                    <li>
                        <a href="${pageContext.request.contextPath}/getusersbypage?currentPage=${i}&rows=3"
                           name="li">${i}</a></li>
                </c:if>
            </c:forEach>
            <%-- 判断是否是最后页--%>
            <c:if test="${pageBean.currentPage >= pageBean.totalPage}">
                <li class="disabled"><span aria-hidden="true">&raquo;</span></li>
            </c:if>
            <c:if test="${pageBean.currentPage!=pageBean.totalPage}">
                <li>

                    <a href="${pageContext.request.contextPath}/getusersbypage?currentPage=${pageBean.currentPage+1}&rows=3"
                       aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </c:if>
            <span style="font-size: 25px ;margin-left: 5px">共${pageBean.totalCount}条数据，共${pageBean.totalPage}页</span>
        </ul>
    </nav>
</div>
</div>
</body>
</html>
