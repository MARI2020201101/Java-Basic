<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>scopeTest.jsp</title>
</head>
<body>
	<h1> 웹페이지의 SCOPE(유효범위) </h1>
<%
	/*
	[JSP 내장객체]
		- JSP페이지가 서블릿으로 변환될때(즉, .class가될때) 
			JSP컨테이너(나는 톰캣 웹서버)가 자동으로 제공한다.
		- JSP페이지 내에서 제공하는 특수한 형태의 특수한 레퍼런스(참조)타입의 변수
		- 따라서- jsp안에서는 객체생성없이 바로 사용가능하다. 톰캣이 이미 자동으로 주니까!!
		- BUT MVC패턴에서는 내가 직접 다룬다! ->HttpServlet에서 꺼내씀~
		- mvc에서는 내가 직접 선언하고 쓴다!!
		- 이 내장객체들을 잘 써야만- 사용자의 요청의 흐름. 문맥. context를 유지시킬수있다
			1번문서2번문서3번문서를 다 연결시켜준다-사실은 각자각자 따로의 페이지라 할지라도.
-------------------------------------------------------------------------			
	[.jsp ->.servlet ->.java ->.class]로 컴파일되고 실행된다. 
										이 작업을 위해 톰캣이 필요.
-------------------------------------------------------------------------

	[SCOPE의 종류]
		1) page : 현재 페이지에서만 유효. 기본값. 당연- 하나의 도큐먼트.
		2) request : 부모페이지와 자식페이지에서만 유효
		3) session : 모든 페이지에서 유효
						사용자 개별개별 각자가 가지고 있음. 시간단위. 
						setSessionTimeout으로 조절
		4) application : 모든 페이지에서 유효
							해당 어플리케이션- 해당 프로젝트를 이용하는 모든 사용자에게 유효
							모든 사용자가 공유가능하고 접근가능한 값.
							서버의 정보. 
							applicaiton.getContextPath => myweb
							따라서 당연히 크롬에서도 익스플로러에서도 같은 값이 나온다. 
							하나의 어플리케이션. 하나의 프로젝트 안에서 같은 값 공유
	[SCOPE이용]
		: 변수를 사용해서 넣고. 변수를 사용해서 빼낸다. 
			map이라고 생각하면 될듯
	
	[내장객체 선언 형식] 
		: 별도의 자료형이 없다. jsp에서 그냥 꺼내쓴다. 	
		pageContext.setAttribute(arg0, arg1);
		request.setAttribute(arg0, arg1);
		session.setAttribute(arg0, arg1);
		application.setAttribute("변수명", "값");
	[내장객체 값 가져오기] : getAttribute();
						모든 객체의 타입은 object가 된다. 받아올때 형변환할수있음
	[내장객체 값 삭제하기] : removeAttribute();'
	*/
	application.setAttribute("uname", "mari");
	out.print(application.getAttribute("uname")+"<br>");
	
	pageContext.setAttribute("kor", 100);
	request.setAttribute("eng", 200);
	session.setAttribute("mat", 300);
	out.print("kor"+pageContext.getAttribute("kor")+"<br>");
	out.print("eng"+request.getAttribute("eng")+"<br>");
	out.print("mat"+session.getAttribute("mat")+"<br>");
	int kor =(int)pageContext.getAttribute("kor");
	int eng =(int)request.getAttribute("eng");
	int mat =(int)session.getAttribute("mat");
	
	out.print("<hr>");
	out.print("pageContext) kor : "+kor+"<br>");
	out.print("request) eng : "+eng+"<br>");
	out.print("session) mat : "+mat+"<br>");
	
	out.print("<hr>");
	out.print("remove이후");
	out.print("<br>");
	pageContext.removeAttribute("kor");
	request.removeAttribute("eng");
	session.removeAttribute("mat");
	application.removeAttribute("uname");
	out.print("kor :" + pageContext.getAttribute("kor")+"<br>");//null
%>
</body>
</html>