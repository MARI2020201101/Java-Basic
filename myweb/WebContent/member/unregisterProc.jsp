<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../bbs/ssi.jsp" %>
<%@ include file="../header.jsp" %>

<!-- 본문 시작 unregisterProc.jsp -->

<%
	String passwd = request.getParameter("passwd");
	String id = request.getParameter("id");
	memberDto.setId(id);
	memberDto.setPasswd(passwd);
	
	int cnt = memberDao.unregister(memberDto);
	
	if(cnt==0){
		out.print("<br>");
		out.println("<div><strong>탈퇴 실패</strong></div>");
		out.println("<p>회원 비밀번호가 일치하지 않습니다.</p>");
		out.println("<p><a href='javascript:history.back()'>[다시 시도하기]</a></p>");
	}else{
%>
		<script>
		alert('회원 탈퇴하였습니다.');
		location.href='../index.jsp';
		</script>
<% 
	}
%>

<!-- 본문 끝 -->
<%@ include file="../footer.jsp" %>