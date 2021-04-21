<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>다양한 컨트롤 요소</h3>
	<form action="08_ok.jsp" method="post" >
	  아이디 : <input type="text" name="uid"> 
	  <hr>
	  비번   : <input type="password" name="upw">
	  <hr>
	  이름   : <input type="text" name="uname">
	  <hr>
	  내용   : <textarea rows="5" cols="20" name="content"></textarea>
	  <hr>
	  숫자1 : <input type="text" name="num"> <br>
	  숫자2 : <input type="text" name="num"> <br>
	  숫자3 : <input type="text" name="num"> <br>
	  성별 : <input type="radio" name="gender" value="M">남 <br>
	  성별 : <input type="radio" name="gender" value="M">여 <br>
	  
	  약관동의 : <input type="checkbox" value="Y" name="agree">
	  <input type="hidden" name="page" value="7">
	  <hr>
	  통신회사 :
	  <select name="telecom">
	  	<option value="sk">sk
	  	<option value="lg">lg
	  	<option value="ktf">ktf
	  </select>
	  <input type="file" name="attach">
	<input type="submit" value="전송">
	</form>
</body>
</html>