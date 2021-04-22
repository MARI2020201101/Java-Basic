<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>*다양한 폼 컨트롤 요소 결과*</h1>
<%
	request.setCharacterEncoding("UTF-8");
	String uid=request.getParameter("uid").trim();
	String upw=request.getParameter("upw").trim();
	String uname=request.getParameter("uname").trim();
	String content=request.getParameter("content").trim();
	content=content.replaceAll("\n", "<br/>");
	String[] num = request.getParameterValues("num");
	for(String n : num){
		out.print(n+"<br>");
	}
	List<String> nums = Arrays.asList(num);
	
	String gender= request.getParameter("gender");
	String agree=request.getParameter("agree");
	String telecom=request.getParameter("telecom");
	String page1=request.getParameter("page");
	String attach= request.getParameter("attach");
	if(agree==null){
		out.print(agree);
		out.print("약관에 동의해주십시요 <br>");
	}else{
		out.print("약관에 동의하셨습니다. <br>");
	}
%>
<%=uid %>
<hr>
<%=upw %>
<hr>
<%=uname %>
<hr>
<%=content %>
<hr>
<%=gender %>
<hr>
<%=telecom %>
<hr>
pagenum: <%=page1 %>
<hr>
<%=attach %>
</body>
</html>