<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="net.testbean.*" %>
<jsp:useBean id="calc" class="net.testbean.CalcBean"></jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>calc ok page</title>
</head>
<body>
	<h1>* Java Bean 이용한 계산 결과 *</h1>
<%
	int a = Integer.parseInt(request.getParameter("num").trim());
	
	out.print("절대값 : "+calc.abs(a));
	out.print("<br>");
	out.print("팩토리얼 : "+calc.fact(a));
	out.print("<br>");

%>
</body>
</html>