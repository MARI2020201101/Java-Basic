<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../bbs/ssi.jsp" %>
<%@ include file="../header.jsp" %>

<!-- 본문 시작 noticeUpdate.jsp -->
<h3>* 공지사항 수정 *</h3>
<%

	int noticeno= Integer.parseInt(request.getParameter("noticeno"));
	String subject = request.getParameter("subject").trim();
	String content = request.getParameter("content").trim();
	
	noticeDto.setSubject(subject);
	noticeDto.setContent(content);
	noticeDto.setNoticeno(noticeno);
	
	int cnt = noticeDao.update(noticeDto);
	
	if(cnt==0){
		out.print("<br>");
		out.println("<div><strong>공지사항 수정실패</strong></div>");
		out.println("<p><a href='javascript:history.back()'>[다시 시도하기]</a></p>");
	}else{
%>
		<script>
		alert('공지사항 수정 성공!');
		location.href='noticeList.jsp';
		</script>
<% 
	}
%>

<!-- 본문 끝 -->
<%@ include file="../footer.jsp" %>