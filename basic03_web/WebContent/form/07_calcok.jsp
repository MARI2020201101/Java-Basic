<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>*계산기 결과*</h1>
<%
	//한글 인코딩 고려하기
	request.setCharacterEncoding("UTF-8");
	
	int num1 = Integer.parseInt(request.getParameter("num1"));
	int num2 = Integer.parseInt(request.getParameter("num2"));
	String op = request.getParameter("op");
	int res=0;
	double result=0.0;
	
	if(op.equals("+")) {res=num1+num2;}
	else if(op.equals("-")){res=num1-num2;}
	else if(op.equals("*")){res=num1*num2;}
	else if(op.equals("/")){result=((double)num1/(double)num2);}
	else if(op.equals("%")){res=num1%num2;}
	else return;
	
%>
<%if(op.equals("/")){
%>
<%= num1 %><%=op %><%=num2 %>=<%=result %>
<%}
else{
%>
<%= num1 %><%=op %><%=num2 %>=<%=res %>
<%}%>
</body>
</html>