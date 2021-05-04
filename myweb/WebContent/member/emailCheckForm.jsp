<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/layout.css">
  <meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
 
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
<title>idCheckForm.jsp</title>
</head>
<body>
<div class="container-2">
<h3>* 이메일 확인 *</h3>
<br>
<form method="post" action="emailCheckProc.jsp" onsubmit="return blankCheck()" >
<input type="email" class="form-control "name="email" id="email" >
<br>
<input type="submit" class="btn btn-primary" value="email확인" >
</form>
</div>
<script>
function blankCheck(){
	var email=$("#email").val();
	if(email.length<5){
		alert("아이디를 5자이상 입력해주십시요");
		return false;
	}else{return true;}
}
</script>
<%

%>
</body>
</html>