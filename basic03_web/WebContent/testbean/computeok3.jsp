<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="net.testbean.*" %>

<%--
<jsp:forward page=""></jsp:forward> 페이지 이동
<jsp:include page=""></jsp:include> 공통페이지 가져오기
<jsp:useBean id=""></jsp:useBean> 객체 생성
--%>

<!-- 액션태그 -->
<jsp:useBean id="comp" class="net.testbean.Compute" scope="page"></jsp:useBean>

<%--
	[Java Bean 객체생성]
	<jsp:useBean id="객체명" class="패키지명.클래스명"></jsp:useBean>
		빈을 이용해서 scope를 조절, 여러 페이지에서 오브젝트를 공유할 수 있다 (scope)
		scope 종류: application, page, session, request
	
	[SCOPE 유효범위]
	- scope: "page"
				현재 페이지에서만 유효. 생략시 기본값
	- scope: "request"
				다른 페이지에서도 공유 가능. 부모-자식
	- scope: "session"
				다른 페이지에서도 공유 가능. 해당 사용자만
	- scope: "application"
				다른 페이지에서도 공유 가능. 모든 사용자
	
	[주의사항]
	코드상 문제가 되지 않는데 자꾸 빈을 못만들었다고 에러가 나는 경우가 있다.(이클립스 바보~!!!) 
	useBean 생성 오류시 
		프로젝트 refresh -> validate -> project clean 후 재테스트 해보기!
	
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>compute 3</title>
</head>
<body>
	<h1>* 계산 결과 *</h1>
	<h2>3) Java Bean 이용</h2>
<%
	int num1 = Integer.parseInt(request.getParameter("num1").trim());
	int num2 = Integer.parseInt(request.getParameter("num2").trim());
	
	
	//객체 생성
	//-> RAM의 heap영역에 메모리가 할당되는 것. 
	//-> new 생성자함수()
		
	out.print(num1+"+"+num2+"="+comp.add(num1,num2));
	out.print("<br>");
	out.print(num1+"-"+num2+"="+comp.sub(num1,num2));
	out.print("<br>");
	out.print(num1+"*"+num2+"="+comp.mul(num1,num2));
	out.print("<br>");
	out.print(num1+"/"+num2+"="+comp.div(num1,num2));
	out.print("<br>");
	out.print(num1+"%"+num2+"="+comp.mod(num1,num2));
	out.print("<br>");
%>	
</body>
</html>