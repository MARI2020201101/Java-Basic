<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>scopeTest2.jsp</title>
</head>
<body>
	<h1>웹페이지의 SCOPE</h1>
<%
	 pageContext.setAttribute("kor", 100);
	request.setAttribute("eng", 200);
	session.setAttribute("mat", 300);
	application.setAttribute("uname", "mari"); 
//-----------------------------------------------------------
/*
	[페이지 이동]:내장객체를 활용해서 페이지 이동하기~
	1. 방법1 : 프론트단에서 
		1) <a href걸기 
		2) <form action=""..걸기
		3) javascript함수 걸어서 location.href이동
	2. 방법2 : 벡앤드에서
		1) forward
		2) redirect
			-servlet 에서는. response.sendRedirect()써야함
*/
%>
	<strong>1) href로 이동하기</strong>
		<br>
		<a href="scopeResult.jsp">scopeResult.jsp</a>
		<br>
		<br>
	<strong>2) form 태그로 이동하기</strong>
		<form action="scopeResult.jsp" >
			<input type="submit" value="결과 페이지로 이동하기">
		</form>
		<br>
	<!-- 
	<strong>3) 자바스크립트로 이동하기</strong>
	<script>
		alert("result 페이지로 이동");
		location.href="scopeResult.jsp";
	</script> -->
	<%-- 
	<strong>4) jsp의 액션태그로 이동하기 : forward</strong>
	<jsp:forward page="scopeResult.jsp"></jsp:forward> --%>
	<%-- 	
	<strong>5) redirect</strong>
	<% response.sendRedirect("scopeResult.jsp"); %> --%>
<%
	String view="scopeResult.jsp";
	RequestDispatcher rd =request.getRequestDispatcher(view);	
	rd.forward(request, response);
%>
	
</body>
</html>