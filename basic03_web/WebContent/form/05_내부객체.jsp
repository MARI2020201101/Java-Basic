<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- JSP에는 미리 만들어놓은 내장객체가 있다
	그래서 사용자가 new하지 않아도 그냥 사용할 수 있음
	ex) out.print 란
		out이라는 이름을 갖고있는 객체의 print라는 메소드를 사용한다는것
		근데 난 out이라는 애 만든적 없는데?? 
			-> 미리JSP가 준비해놓고 기다리고 있었습니다!!
	[JSP 내장객체]
	- 톰캣 서버에 의해 자동으로 생성된 객체
	- 개발자는 별도의 객체를 선언하지 않고 가져다 사용만 한다
 -->
<% 
	/*
	[JSP 내장객체]
			
		1) out
			: 본문(body태그)를 가리키는 출력객체
		2) request
			: 사용자가 요청한 정보를 관리하는 객체
		3) response
			: 요청한 사용자에게 응답을 해주기 위한 객체. 응답을 관리하는 객체
		4) session
			: 서버입장에서. 요청한 사용자를 구분하기 위해서 session객체가 필요함!!
			서버는 요청후에- 접속을 끊어버리기 때문에- 개별개별을 식별하기 위해서는?? session이 필요
		5) application
			: 모든 사용자가 공유하는 값. 서버에 대한 정보를 담고 있음. 어플리케이션 전체에 적용되는. 
			log를 기록하거나. MIME타입을 알려주거나. serverInfo를 알려주거나. (tomcat)
		6) pageContext
			: JSP, JSTL, EL
			같은 페이지에 공존할 수 있지만 서로 다른문법이다!
			이때 - 서로 다른 문법끼리의 값을 공유하기 위해서 pageContext라는 공간을 활용한다 
		
		=> 이런애들은 내가 new하지 않고도 JSP내부에서 사용할수가 있다!!
		
		PageContext pageContext
	    HttpSession session
	    ServletContext application
	    ServletConfig config
	    JspWriter out
	    Object page
	    HttpServletRequest request
	    HttpServletResponse response
	*/
%>

</body>
</html>