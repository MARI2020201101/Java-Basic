<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSP 사용자 정의 함수</h1>
	최대값: <%=max(3,5) %>
	<hr>
	두수 사이의 차이 : <%= diff(2,6) %>
<%!
	public int max(int a, int b){
	return Math.max(a,b);
}
	public int diff(int a, int b){
		return Math.abs(a-b);
	}
%>
</body>
</html>