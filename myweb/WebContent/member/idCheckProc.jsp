<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../bbs/ssi.jsp" %>

<%@ include file="auth.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

  <meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
 
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>idCheckproc.jsp</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/layout.css">
</head>
<body>
<div class="container-2">

<%
String id =request.getParameter("id").trim();
int result = memberDao.duplicateID(id);
out.print("<strong style='color:black;'>입력 ID: "+id+"</strong>");
if(result==0){
	out.print("<p style='color:red;'>해당 아이디는 사용하실 수 있습니다!</p>");
	out.print("<p><a href='javascript:apply(\""+id+"\")'>[아이디 사용하기]</a></p>");
	out.print("<hr>");
}else{
	out.print("<p style='color:red;'>해당 아이디는 이미 사용 중입니다.</p>");	
}
%>
<p><a href='javascript:history.back()'>[다시 검색하기]</a></p>
<p><a href='javascript:window.close()'>[창 닫기]</a></p>
<script>
function apply(id){
	//opener.memfrm.id.value=id;
	$(opener.document).find("#memfrm").find("#id").val(id);
	window.close();
}
</script>
</div>
</body>
</html>