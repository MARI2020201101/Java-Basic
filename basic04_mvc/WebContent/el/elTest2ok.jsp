<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>elTest2.jsp</title>
</head>
<body>
<h3>*EL(Expression Language) 표현언어*</h3>
<%
request.setCharacterEncoding("UTF-8");
%>
${param.id }
${param.name }
</body>
</html>