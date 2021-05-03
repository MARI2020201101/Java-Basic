<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../bbs/ssi.jsp" %>
<%@ include file="../header.jsp" %>

<%

memberDto.setId(request.getParameter("id"));
memberDto.setPasswd(request.getParameter("passwd"));
String mlevel=memberDao.loginProc(memberDto);

if(mlevel.equals("")||mlevel==null){
	out.print("<script>");
	out.print("alert('비밀번호와 패스워드가 일치하지 않습니다.');");
	out.print("history.back();");
	out.print("</script>");
}
else{
	out.println("<script>");
	out.print("alert('로그인 성공!');");
	out.print("location.href='../index.jsp'");
	out.println("</script>");
}

%>

