<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="ssi.jsp" %>
<%@ include file="../header.jsp" %>

<%

	String uname = request.getParameter("wname").trim();
	String subject = request.getParameter("subject").trim();
	String content = request.getParameter("content").trim();
	String passwd = request.getParameter("passwd").trim();
	String ip = request.getRemoteAddr();

	dto.setWname(uname);
	dto.setSubject(subject);
	dto.setContent(content);
	dto.setPasswd(passwd);
	dto.setIp(ip);
	int cnt = dao.insert(dto);
	if(cnt==0){
		out.print("<script>");
		out.print("alert('새글쓰기에 실패하였습니다.');");
		out.print("</script>");
		out.print("<p><a href=\"javascript:history.back()\">[다시 시도하기]</a></p>");

	}else{
		out.println("<script>");
		out.println("alert('새글쓰기 성공!')");
		out.print("location.href='bbsList.jsp'");
		out.println("</script>");
	}
%>

