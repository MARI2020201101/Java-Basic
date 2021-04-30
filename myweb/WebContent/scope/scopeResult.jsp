<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>scopeResult Page</title>
</head>
<body>
	<h1>웹페이지의 SCOPE 결과</h1>
<%
	out.print("kor : " + pageContext.getAttribute("kor")+"<br>");
	out.print("eng : " + request.getAttribute("eng")+"<br>");
	out.print("mat : " + session.getAttribute("mat")+"<br>"); 
	out.print("uname : " + application.getAttribute("uname")+"<br>");
//------------------------------------------------------------------------
/*
	session하고 applicationContext는 살아있는데
	pageContext하고 request는 null나옴
*/
%>
</body>
</html>