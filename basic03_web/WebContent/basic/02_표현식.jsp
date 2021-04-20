<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>성적프로그램</h1>
<%
	String name="김이름";
	int kor=80,mat=100,eng=40;
	int aver=(kor+mat+eng)/3;
	
	out.println(aver);
	out.println(name);
%>
<hr>
	<table border="1">
		<tr>
		<th>이름</th>
		<td><%=name %></td>
		</tr>
		<tr>
		<th>평균</th>
		<td><%=aver %></td>
		</tr>
		<tr>
		<th>국어</th>
		<td><%=kor %></td>
		</tr>
		<tr>
		<th>수학</th>
		<td><%=mat %></td>
		</tr>
		<tr>
		<th>영어</th>
		<td><%=eng %></td>
		</tr>
	</table>
<!-- 표현식(Expression) : out.print를 좀더 쉽게 쓸수있다 -->
</body>
</html>