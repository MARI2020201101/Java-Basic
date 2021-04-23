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
<title>SungjukRead Page</title>
</head>
<style>
	.table-info{width:230px;}
	td{text-align:center; }
</style>
<body>
<br>
	<div class="container">
		<h1>*성적 상세보기*</h1>
		<br>
		<p>
			<a href="sungjukForm.jsp">[성적쓰기]</a>
			<a href="sungjukList.jsp">[성적목록]</a>
		</p>
		<br>
	
<%
	int sno = Integer.parseInt(request.getParameter("sno"));
	dto=dao.read(sno);
	if(dto==null){
		out.println("해당 항목은 존재하지 않습니다.");
	}else{
%>
		<table class="table table-hover">
			<tr>
				<th class="table-info">이름</th>
				<td><%=dto.getUname() %></td>
			</tr>
			<tr>
				<th class="table-info">국어</th>
				<td><%=dto.getKor() %></td>
			</tr>
			<tr>
				<th class="table-info">영어</th>
				<td><%=dto.getEng() %></td>
			</tr>
			<tr>
				<th class="table-info">수학</th>
				<td><%=dto.getMat() %></td>
			</tr>
			<tr>
				<th class="table-info">평균</th>
				<td><%=dto.getAver() %></td>
			</tr>
<%
			String addr= dto.getAddr();
			if(addr.equals("Seoul")){
				addr = "서울";
			}else if(addr.equals("Jeju")){
				addr = "제주";
			}else if(addr.equals("Busan")){
				addr = "부산";
			}else{
				addr = "수원";
			}

%>
			<tr>
				<th class="table-info">주소</th>
				<td><%=addr %></td>		
			</tr>
			<tr>
				<th class="table-info">등록일</th>
				<td><%=dto.getWdate().substring(0,10) %></td>
			</tr>
	</table>	
<% 
	}
%>
	<!--
		<a href="sungjukUpdate.jsp?sno=<%=sno%>">[수정하기]</a>
		<a href="sungjukDel.jsp?sno=<%=sno %>">[삭제하기]</a>
	-->
	<button class="btn btn-warning" onclick="location.href='/basic03_web/sungjukbean/sungjukUpdate.jsp?sno=<%=sno%>'">수정</button>
	<button class="btn btn-danger" onclick="location.href='sungjukDel.jsp?sno=<%=sno%>'">삭제</button>
	</div>
</body>
</html>