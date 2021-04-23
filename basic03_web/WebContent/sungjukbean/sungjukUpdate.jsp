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
<title>SungjukUpdate Page</title>
<style>
	.table-info{width:230px;}

	input{ width:200px;
			border: 1px solid lightgray;}
	input.btn{width:100px;}
</style>
</head>
<body>
<br>
<div class="container">
<h1>*성적 데이터 수정*</h1>
	<br>
	<p>
		<a href="sungjukForm.jsp">[성적쓰기]</a>
		<a href="sungjukList.jsp">[성적목록]</a>
	</p>
<%
	int sno = Integer.parseInt(request.getParameter("sno")); 
	dto=dao.read(sno);
	if(dto==null){
		out.println("해당 글없음!");
	}else{	
%>
	<br>
		<form method="post" action="sungjukUpdateProc.jsp">
		<input type="hidden" name="sno" value="<%=sno %>">
		<table class="table table-hover table-bordered align-middle">
		<tr>
		  <th class="table-info">이름</th>
		  <td><input type="text" name="uname" maxlength="20" required autofocus value="<%=dto.getUname() %>"></td>
		</tr> 
		<tr>
		  <th class="table-info">국어</th>
		  <td><input type="number" name="kor" size="5" min="0" max="100" placeholder="숫자입력" value="<%=dto.getKor() %>"></td>
		</tr> 
		<tr>
		  <th class="table-info">영어</th>
		  <td><input type="number" name="eng" size="5" min="0" max="100" placeholder="숫자입력" value="<%=dto.getEng() %>"></td>
		</tr> 
		<tr>
		  <th class="table-info">수학</th>
		  <td><input type="number" name="mat" size="5" min="0" max="100" placeholder="숫자입력" value="<%=dto.getMat() %>"></td>	
		</tr> 
		<tr>
		  <th class="table-info">주소</th>
		  <td>
		  	<%String addr= dto.getAddr(); %>
		      <select name="addr">
		            <option value="Seoul" <%if(addr.equals("Seoul")){out.println("selected");} %>>서울</option>
		            <option value="Jeju" <%if(addr.equals("Jeju")){out.println("selected");} %>>제주</option>
		            <option value="Suwon" <%if(addr.equals("Suwon")){out.println("selected");} %>>수원</option>
		            <option value="Busan" <%if(addr.equals("Busan")){out.println("selected");} %>>부산</option>
		      </select> 
		  </td>
		</tr> 
		<tr>
		  <td colspan="2" align="center">
		     <input class="btn btn-primary" type="submit" value="수정">
		     <input class="btn btn-primary" type="reset"  value="취소">
		  </td>
		</tr>
		</table>
	</form>
	</div>	
<%		
	}
%>
</body>
</html>