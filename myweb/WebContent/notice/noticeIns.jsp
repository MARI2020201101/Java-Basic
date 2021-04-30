<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../bbs/ssi.jsp" %>
<%@ include file="../header.jsp" %>

<%

	String subject = request.getParameter("subject").trim();
	String content = request.getParameter("content").trim();

	noticeDto.setSubject(subject);
	noticeDto.setContent(content);

	int cnt = noticeDao.insert(noticeDto);
	if(cnt==0){
		out.print("<script>");
		out.print("alert('공지사항 등록에 실패하였습니다.');");
		out.print("</script>");
		out.print("<p><a href=\"javascript:history.back()\">[다시 시도하기]</a></p>");

	}else{
		out.println("<script>");
		out.println("alert('공지사항 등록 성공!')");
		out.print("location.href='noticeList.jsp'");
		out.println("</script>");
	}
%>

