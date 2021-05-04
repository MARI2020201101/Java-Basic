<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../bbs/ssi.jsp" %>
<%@ include file="../header.jsp" %>

<!-- 본문 시작 updateProc.jsp -->
<h3>* 회원정보 수정 *</h3>
<%

	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	String mname = request.getParameter("mname");
	String email = request.getParameter("email");
	String tel = request.getParameter("tel");
	String zipcode = request.getParameter("zipcode");
	String address1 = request.getParameter("address1");
	String address2 = request.getParameter("address2");
	String job = request.getParameter("job");
	memberDto.setId(id);
	memberDto.setPasswd(passwd);
	memberDto.setMname(mname);
	memberDto.setEmail(email);
	memberDto.setTel(tel);
	memberDto.setZipcode(zipcode);
	memberDto.setAddress1(address1);
	memberDto.setAddress2(address2);
	memberDto.setJob(job);

		
	int cnt = memberDao.update(memberDto);
	
	if(cnt==0){
		out.print("<br>");
		out.println("<div><strong>회원정보 수정실패</strong></div>");
		
		out.println("<p><a href='javascript:history.back()'>[다시 시도하기]</a></p>");
	}else{
%>
		<script>
		alert('회원정보 수정 성공!');
		location.href='loginForm.jsp';
		</script>
<% 
	}
%>

<!-- 본문 끝 -->
<%@ include file="../footer.jsp" %>