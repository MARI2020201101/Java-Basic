<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>*request 내장객체의 다양한 메소드 결과*</h1>
<% 
	request.setCharacterEncoding("UTF-8");
	String uid =request.getParameter("uid");
	out.print(uid);
	out.print("<hr>");
	out.print(request.getRemoteAddr());//유저 ip 주소
	out.print("<hr>");
	out.print(request.getRemoteHost());
	out.print("<hr>");
	out.print(request.getRemotePort());
	out.print("<hr>");
	out.print(request.getRequestedSessionId());
	out.print("<hr>");
//----------------------------------------------
	// 해당 프로젝트 이름
	// /basic03_web 
	out.print(request.getContextPath()); 
	out.print("<hr>");
	
	// 유저가 요청한 페이지명 또는 명령어의 전체경로
	// http://localhost:8081/basic03_web/form/09_ok.jsp
	out.print(request.getRequestURL()); 
	out.print("<hr>");
	
	// 유저가 요청한 페이지명 또는 명령어 만! 
	// /basic03_web/form/09_ok.jsp
	out.print(request.getRequestURI());
	out.print("<hr>");
	
	// images 라는 폴더의 실제 물리적경로 (첨부파일 저장시 필요)
	// C:\java202102\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\basic03_web\images
	// but 위 경로는 이클립스가 복사한 톰캣의 경로이기 때문에 실제 서비스경로와는 달라진다.
	// '진짜' 톰캣경로로 바꾸어주어야 - 서비스하는 서버의 경로가 된다.
	out.print(request.getRealPath("/images"));
	out.print("<hr>");
	
	// request에서 제공하는 getRealPath는 deprecated되므로 아래메소드를 추천함
	out.print(application.getRealPath("/images"));
	out.print("<hr>");
	
	//request.setAttribute("변수명",값);
	//request.getAttribute("변수명",값);
	request.setAttribute("user","korea");
	out.print(request.getAttribute("user"));
%>
</body>
</html>