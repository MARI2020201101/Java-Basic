<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>*성적입력*</h1>
	<form name="sungjukform" id="sungjukform" action="06_ok.jsp" method="post">
	<label for="uname">이름: </label>
	<input type="text" id="uname" name="uname" maxlength="20" placeholder="Enter name..." size="10" required="true">
	<br>
	<label for="kor">국어: </label>
	<input type="number" id="kor" name="kor" size="5" min="0" max="100">
	<br>
	<label for="eng">영어: </label>
	<input type="number" id="eng" name="eng" size="5" min="0" max="100">
	<br>
	<label for="mat">수학: </label>
	<input type="number" id="mat" name="mat" size="5" min="0" max="100">
	<br><br>
	<input type="submit" value="전송">
	<input type="reset" value="취소">
	</form>
<%
	/*
		[form]: 사용자가 입력한 정보를 서버로 전송하기 위한 양식
		name : 폼이름. 서버에서 접근할때
		id	: 폼 아이디. 프론트엔드에서 식별자로 사용
		method: 폼 전송방식 . get과 post. 기본은 get(생략시)
		action: 사용자가 요청한 정보를 서버가 받아서 처리할 결과 페이지
		enctype: 폼에서 파일을 첨부해서 서버로 전송하고자 할때. enctype="multipart/form-data"추가
		
		[form 전송방식]
		1)method=get방식
		- 생략하면 기본값
		- 사용자가 요청한 정보가 URL에 노출된다
		- 형식) 요청페이지?변수=값&변수=값...
		
		2)method=post방식
		- 사용자가 요청한 정보가 URL에 노출되지 않고 패키지화되어서 서버로 전송된다
	*/
%>
</body>
</html>