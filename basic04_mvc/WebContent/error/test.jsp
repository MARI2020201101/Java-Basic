<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test</title>
</head>
<body>
<%
	int num = Integer.parseInt(request.getParameter("num"));
	out.print("num: "+ num);
%>
</body>
</html>