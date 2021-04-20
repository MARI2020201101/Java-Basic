<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<%-- 
	1) 
		JSP 주석: Ctrl + Shift + /
		JSP 지시자(Directive): 	<%@ page %>
								<%@ include %>
								<%@ taglib %>
		page directive를 반드시 선언해주어야 함
		contentType은 필수! 아주 중요하다
		include : 다른 페이지를 가져온다
		
	2) <%@ page %>지시자
		language 생략가능
		contentType = 필수. 내가 지금 만드는 문서는 html문서이다- 라고 알려주는 것
						body라고 하는 구조. head라고 하는- 구조화된 문서이다.
						 <-> text/plain = 리얼 그냥 텍스트
						그러니까 html형식대로 읽어!! 라고 direct지시한다!
		pageEncoding 생략가능 
		import = 자바 package및 클래쓰 선언할때 씀( 평범한 java의 임포트)
		
		JSP는 서버에의해서 해석되는 언어이기 때문에 반드시 directive가 필요하다
		안그러면 해석할수없어서 오류남 !!
		
	3) 한글 인코딩 
		: 섞어쓰지 않도록 주의한다.
			조합형과 완성형이 있다
			조합형= UTF-8, 초성+중성+종성 으로 접근. 
					그래서 완성형보다 더 많은 한글글자 표현이 가능해짐
			완성형= EUC-KR (= MS949)
		한글이 깨지지 않게끔 인코딩방식은 한개로 통일하기-> UTF-8
	
	4) JSP코드 작성 영역
		<% %> ==> 서버에 의해 해석된다. 스크립트릿(Scriptlet)
	
	5) .jsp페이지에서 사용가능한 문법
		: HTML tag, CSS, JavaScript, JSP코드
		하나의 페이지에서 서로다른 문법들이 공존할수있다(스파게티꺄악~~)
		--> 각자의 공간을 잘 확보하여줍시다-
		ex) CSS: <style></style>
			JavaScript: <script></script>
			JSP코드: <%%>
			
	6) 물리적 경로 /WebContent/어쩌구~~
		로 접근하지 않고
		프로젝트 경로 /basic03_web/~~어쩌구
		로 접근해야한다!!
		논리적 경로!!
		
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>01_JSP 기초문법</title>
</head>
<body>
	<h1>JSP 기초문법</h1>
	<p>1+2+3</p>
	<p><%= 1+2+3 %></p>
	<%
	//한줄주석
	/*여러줄 주석*/
	/*
		스크립트릿(Scriptlet)
		- JSP코드 작성영역
		- on Server에 의해 JSP코드가 해석되고 HTML문서로 Frontend단으로 응답해 줌
	*/
	
	//out.print(); HTML문서에 출력
	out.print("무궁화");
	out.print(5+7);
	out.println(8.9);
	out.println(8.9);
	
	//HTML태그를JSP에서 사용하는 경우 ""안에서 작성하기
	out.print("<h1>천사</h1>");
	out.print("<img src ='../images/angel.png'>");
	out.print("<hr>");
	%>
	
	<%
	out.println("<style>.txt{color:red}</style>");
	out.println("<p class=\"txt\">오필승코리아</p>");
	%>
	
</body>
</html>