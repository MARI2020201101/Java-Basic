<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="ssi.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>sungjuk List Page</title>
</head>
<body>
<div class="container">
<br>
	<h1>*성적 목록*</h1>
	<br>
		<p><a href="sungjukForm.jsp">[성적쓰기]</a></p>
	<br>
	<table class="table table-hover">
		<thead class="table table-info"> 
			<tr>
				<th>이름</th>
				<th>국어</th>
				<th>영어</th>
				<th>수학</th>
				<th>평균</th>
				<th>등록일</th>
			</tr>
		</thead>
		<tbody>
<%
	ArrayList<SungjukDTO> list = dao.list();
	if(list==null){
		out.println("<tr>");
		out.println("<td colspan='6'>출력 자료 없음</td>");
		out.println("</tr>");
	}else{
		for(int i=0;i<list.size();i++){
			dto=list.get(i);
%>
			<tr>
				<td><a href="sungjukRead.jsp?sno=<%=dto.getSno() %>"><%=dto.getUname() %></a></td>
				<td><%=dto.getKor() %></td>
				<td><%=dto.getEng() %></td>
				<td><%=dto.getMat() %></td>
				<td><%=dto.getAver() %></td>
				<td><%=dto.getWdate().substring(0, 10) %></td>
			</tr>
<% 		
		}
	}
%>


		</tbody>
	</table>
</div>
</body>
</html>