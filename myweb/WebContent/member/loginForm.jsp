<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%@ include file="auth.jsp" %>
<%@ include file="../bbs/ssi.jsp" %>
<!-- 본문 시작 loginForm.jsp -->

<%
String c_id = "";
String c_passwd = "";
if(s_id.equals("guest")||s_passwd.equals("guest")||s_mlevel.equals("guest")){
	Cookie[] cookies = request.getCookies();
	
	if(cookies!=null){	
		for(Cookie cookie : cookies){
			if(cookie.getName().equals("c_id")){
				c_id = cookie.getValue();	
			}
	}
}

%>
<div class="container-2">
<h3>* 로 그 인 *</h3>
<br>
<form method="post" action="loginProc.jsp" onsubmit="return loginCheck()">
		<div class="row">
			<div class="col-sm-4"></div>
			<div class="form-group col-sm-4">
				<label>아이디</label> 
				<input type="text" class="form-control" id="id" name="id" placeholder="Enter id" value="<%=c_id %>">
			</div>
			<div class="col-sm-4"></div>
		</div>
		<div class="row">
			<div class="col-sm-4"></div>
			<div class="form-group col-sm-4">
				<label>비밀번호</label> 
				<input type="password" class="form-control" id="passwd" name="passwd" placeholder="Password" value="<%=c_passwd%>">
			</div>
			<div class="col-sm-4"></div>
		</div>
		<div class="row">
			<button type="submit" class="btn btn-primary">로그인</button>
		</div>	
		<br>
		<div class="form-group">
			<div class="col-sm-4" ></div>
			<div style="border:1px solid #e7e7e7;border-radius: 10px;" class="col-sm-4" >
				<div class="row">
					<input type="checkbox" name="c_id" value="SAVE" <%if(!(c_id.isEmpty())){out.println("checked");	}%>>&nbsp;아이디 기억하기
				</div>
				<div class="row">
					<a href="agreement.jsp">회원가입</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="findID.jsp">아이디 / 비밀번호 찾기</a>
				</div>
			</div>
			<div class="col-sm-4" ></div>	
		</div>
	</form>	
</div>	
<% 
}else{
	
%>
<div class="container-2">
<h3>* 회원 메뉴 *</h3>
<br>
<div class="row">
	<label><%=s_id %> 님</label>
	<br>
	<button type="submit" class="btn btn-primary" onclick="javascript:location.href='logout.jsp'">로그아웃</button>
	<br><br>
	
	<div class="col-sm-4" ></div>	
		<div style="border:1px solid #e7e7e7;border-radius: 10px;" class="col-sm-4" >
			<a href="updateForm.jsp">회원정보 수정</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="unregisterForm.jsp">회원 탈퇴</a>
		</div>
		<div class="col-sm-4" ></div>	
</div>
<% 
}
%>
	
			
</div>

<!-- 본문 끝 -->
<%@ include file="../footer.jsp" %>