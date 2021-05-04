<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%@ include file="../bbs/ssi.jsp" %>

<!-- 본문 시작 -->
<div class="container-2">
<h3>* 회원가입 결과*</h3>
<%
	//1) 사용자가 요청한 값 가져오기
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
	
	//2) dto객체에 담기
	//3) DB에 추가하기 
	int cnt =memberDao.insert(memberDto);
	if(cnt==0){
		out.print("<script>");
		out.print("alert('회원가입에 실패하였습니다.');");
		out.print("</script>");
		out.print("<p><a href=\"javascript:history.back()\">[다시 시도하기]</a></p>");

	}else{
		out.println("<script>");
		out.println("alert('회원가입을 축하드립니다!')");
		out.print("location.href='loginForm.jsp'");
		out.println("</script>");
	}


%>
</div>
<!-- 본문 끝 -->

<%@ include file="../footer.jsp" %>