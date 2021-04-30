<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session Test. jsp</title>
</head>
<body>
	<h1>session 내장객체</h1>
<%
	/*
	[session]
		- HttpSession session
		- request한 유저 개개별이 가지고있음
		- 세션은 전역변수
		- myweb project전체가 공유한다
		- 유저별 context를 유지하기 위함
		- 일정시간( 톰캣 default: 30분) 이 지나면 자동으로 없어짐
	*/

	String sessionID =session.getId();
	out.print("sessionID : "+sessionID);
	out.print("<br>");
	out.print("session.getLastAccessedTime(): "+session.getLastAccessedTime());
	out.print("<br>");
	out.print("session.getMaxInactiveInterval(): "+session.getMaxInactiveInterval());
	out.print("/초 단위<br>");
	out.print("<br>");
	
%>
</body>
</html>