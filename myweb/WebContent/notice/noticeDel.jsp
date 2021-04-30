<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../bbs/ssi.jsp" %>
<%@ include file="../header.jsp" %>

<!-- 본문 시작 noticeDel.jsp -->
<h3>* 공지사항 삭제 *</h3>
<p><a href="noticeList.jsp">[공지사항 목록]</a></p>
<br>
<%

int noticeno = Integer.parseInt(request.getParameter("noticeno"));

int cnt = noticeDao.delete(noticeno);

if(cnt==0){
	out.print("<br>");
	out.println("<div><strong>공지사항 삭제 실패</strong></div>");
	out.println("<p><a href='javascript:history.back()'>[다시 시도하기]</a></p>");
}else{
%>
	<script>
	alert('공지사항 삭제 성공!');
	location.href='noticeList.jsp';
	</script>
<% 
}

%>
<!-- 본문 끝 -->
<%@ include file="../footer.jsp" %>