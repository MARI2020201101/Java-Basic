<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>*성적결과*</h1>
	<%
		/*
		[HttpServeltRequest request]
		: 	JSP내장객체
			사용자가 요청한 모든 정보를 관리하는 녀석
		*/
		request.setCharacterEncoding("UTF-8");
		String uname = request.getParameter("uname");
		int kor = Integer.parseInt(request.getParameter("kor"));
		int mat = Integer.parseInt(request.getParameter("mat"));
		int eng = Integer.parseInt(request.getParameter("eng"));
	
		out.print(request.getParameter("uname"));
		out.print(request.getParameter("kor"));
		out.print(request.getParameter("mat"));
		out.print(request.getParameter("eng"));
	 
		/*
		(주의점)
		1) method=post일때 한글이 깨진다. setCharacterEncoding를 이용한다.
		2) getParameter의 리턴형은 String이다. 
			다른 타입을 사용하고싶으면- 형변환이 필요함: parseInt 등.
		*/
		
	%>
	<hr>
	<table border="1">
		<tr>
		<th>이름</th>
		<td><%=uname %></td>
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
</body>
</html>