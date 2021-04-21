<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>*계산기연습*</h1>
	<form name="calcform" id="calcform" method="get" action="07_calcok.jsp">
	첫번째 수:
	<input type="number" name="num1" min="0" max="100" required>
	<hr>
	연산자:
	<input type="text" name="op" size="3" required>
	<hr>
	두번째 수:
	<input type="number" name="num2" min="0" max="100" required>
	<hr>
	<input type="submit" value="계산하기">
	<input type="reset" value="취소하기">
	</form>
</body>
</html>