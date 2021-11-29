<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--展示信息，读取msg，需要用到java代码--%>
<%--<%--%>
<%--   Object msg= request.getAttribute("msg");--%>
<%--   session.getAttribute("abc");--%>
<%--   out.print(msg);--%>
<%--   out.println(msg);--%>
<%--%>--%>

<%--<%=msg%>--%>
<%--<%=request.getAttribute("msg")%>--%>
<%--<%=new Date()%>--%>
<%
    pageContext.setAttribute("msg","张三");
%>

${requestScope.msg}
${list}
</body>
</html>
