<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>application Test. jsp</title>
</head>
<body>
	<h1>application 내장객체</h1>
<%
	/*
	[application]
		- ServeltContext application
		- 서버에 대한 정보를 관리하는 객체
		- 이 어플리케이션의 유저 모두가 사이좋게 공유~ 아이조아~
		- 따라서 당연히 전역 변수이다!
	*/
	//논리주소를 물리주소로 변환. RealPath
	out.print("application.getRealPath('/bbs') : ");
	out.print(application.getRealPath("/bbs"));
	out.print("<br>");
	
//--------------------------------------------------------

	/*
	[response 내장객체]
		-request를 보낸 사용자에게 응답할때 사용
		-response.sendRedirect() : 페이지 redirect
		-response.getWriter(): 응답메세지 전송
	*/
%>
</body>
</html>