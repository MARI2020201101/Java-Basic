<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>elTest3.jsp</title>
</head>
<body>
<h3>*EL의 Collection*</h3>
<%
	/*
	EL의 Collection(내장객체)
	-> param, pageScope, requestScope, sessionScope, applicationScope 등
	
	JSP의 내장객체
	-> pageContext, request, session, application
	*/

	//웹의 내장변수 선언
	pageContext.setAttribute("kor", 100);
	request.setAttribute("eng", 90);
	session.setAttribute("mat", 80);
	application.setAttribute("name", "이름");
%>
<h4>page</h4>
${kor }
<h4>request</h4>
${eng }
<h4>session</h4>
${mat }
<h4>application</h4>
${name }
<hr>
없는경우 : 빈문자열(그래서 나중에 JSTL써서. empty로 점검함. null이 아니고""인경우 체크)
<br>
@${uname }@
</body>
</html>