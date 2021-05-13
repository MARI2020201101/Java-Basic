<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>elTest4.jsp</title>
</head>
<body>
<h3>*JSP와 EL의 값 공유*</h3>
<%
pageContext.setAttribute("uid", "Korea");
%>
${uid }
${pageScope.uid }
<%=pageContext.getAttribute("uid") %>
</body>
</html>