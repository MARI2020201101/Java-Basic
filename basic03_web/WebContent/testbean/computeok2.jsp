<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="net.testbean.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>compute 2</title>
</head>
<body>
	<h1>* 계산 결과 *</h1>
	<h2>2) new 연산자 이용</h2>
<%
	int num1 = Integer.parseInt(request.getParameter("num1").trim());
	int num2 = Integer.parseInt(request.getParameter("num2").trim());
	
	
	//객체 생성
	//-> RAM의 heap영역에 메모리가 할당되는 것. 
	//-> new 생성자함수()
	Compute comp = new Compute();
	
	out.print(num1+"+"+num2+"="+comp.add(num1,num2));
	out.print("<br>");
	out.print(num1+"-"+num2+"="+comp.sub(num1,num2));
	out.print("<br>");
	out.print(num1+"*"+num2+"="+comp.mul(num1,num2));
	out.print("<br>");
	out.print(num1+"/"+num2+"="+comp.div(num1,num2));
	out.print("<br>");
	out.print(num1+"%"+num2+"="+comp.mod(num1,num2));
	out.print("<br>");
%>
</body>
</html>