<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="ssi.jsp" %>
<%@ include file="../header.jsp" %>

<!-- 본문 시작 bbsDel.jsp -->
<h3>* 글 수정 *</h3>
<%

	int bbsno = Integer.parseInt(request.getParameter("bbsno"));
	String uname = request.getParameter("wname").trim();
	String subject = request.getParameter("subject").trim();
	String content = request.getParameter("content").trim();
	String passwd = request.getParameter("passwd").trim();
	
	dto.setWname(uname);
	dto.setSubject(subject);
	dto.setContent(content);
	dto.setPasswd(passwd);
	dto.setBbsno(bbsno);
	
	int cnt = dao.update(dto);
	
	if(cnt==0){
		out.print("<br>");
		out.println("<div><strong>수정실패</strong></div>");
		out.println("<p>글 비밀번호가 일치하지 않습니다.</p>");
		out.println("<p><a href='javascript:history.back()'>[다시 시도하기]</a></p>");
	}else{
%>
		<script>
		alert('글수정 성공!');
		location.href='bbsList.jsp';
		</script>
<% 
	}
%>

<!-- 본문 끝 -->
<%@ include file="../footer.jsp" %>