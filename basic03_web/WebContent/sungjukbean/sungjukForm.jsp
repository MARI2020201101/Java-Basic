<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>Sungjuk Form</title>
<style>
	input{ width:200px;
			border: 1px solid lightgray;}
	input.btn{width:100px;}
</style>
</head>
<body>
<div class="container">
<br>
	<h1>*성적 입력 폼*</h1>
<br>
	<p><a href="sungjukList.jsp">[성적목록]</a></p>
	 <form method="post" action="sungjukIns.jsp">
	<table class="table table-hover table-bordered align-middle">
	<tr>
	  <th class="table-info">이름</th>
	  <td><input type="text" name="uname" maxlength="20" required autofocus></td>
	</tr> 
	<tr>
	  <th class="table-info">국어</th>
	  <td><input type="number" name="kor" size="5" min="0" max="100" placeholder="숫자입력"></td>
	</tr> 
	<tr>
	  <th class="table-info">영어</th>
	  <td><input type="number" name="eng" size="5" min="0" max="100" placeholder="숫자입력"></td>
	</tr> 
	<tr>
	  <th class="table-info">수학</th>
	  <td><input type="number" name="mat" size="5" min="0" max="100" placeholder="숫자입력"></td>	
	</tr> 
	<tr>
	  <th class="table-info">주소</th>
	  <td>
	      <select name="addr">
	            <option value="Seoul">서울</option>
	            <option value="Jeju">제주</option>
	            <option value="Suwon">수원</option>
	            <option value="Busan">부산</option>
	      </select> 
	  </td>
	</tr> 
	<tr>
	  <td colspan="2" align="center">
	     <input class="btn btn-primary" type="submit" value="전송">
	     <input class="btn btn-primary" type="reset"  value="취소">
	  </td>
	</tr>
	</table>
    </form>
</div>
</body>
</html>