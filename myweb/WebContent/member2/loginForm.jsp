<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<!-- 본문 시작 loginForm.jsp -->
<c:if test="${empty sessionScope.memid}">
<%
	String c_id = "";
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
<form method="post" action="loginPro.do" onsubmit="return loginCheck()">
		<div class="row">
			<div class="col-sm-4"></div>
			<div class="form-group col-sm-4">
				<label>아이디</label> 
				<input type="text" class="form-control" id="id" name="id" placeholder="Enter id" >
			</div>
			<div class="col-sm-4"></div>
		</div>
		<div class="row">
			<div class="col-sm-4"></div>
			<div class="form-group col-sm-4">
				<label>비밀번호</label> 
				<input type="password" class="form-control" id="passwd" name="passwd" placeholder="Password" >
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
					<input type="checkbox" name="c_id" value="SAVE" >&nbsp;아이디 기억하기
				</div>
				<div class="row">
					<a href="agreement.jsp">회원가입</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="findID.jsp">아이디 / 비밀번호 찾기</a>
				</div>
			</div>
			<div class="col-sm-4" ></div>	
		</div>
	</form>	
	<br>
</c:if>
<c:if test="${not empty sessionScope.memid }">
<div class="container-2">
<h3>* 회원 메뉴 *</h3>
<br>
<div class="row">
	<label><c:out value="${sessionScope.memid}"></c:out> 님 환영합니다.</label>
	<br>
	<form action="logout.do" method="post">
	<button type="submit" class="btn btn-primary" >로그아웃</button>
	<br><br>
	</form>
	<div class="col-sm-4" ></div>	

	<div class="col-sm-4" ></div>	
</div>
</div>		
<br>
</c:if>	
</div>
<!-- 본문 끝 -->
<%@ include file="../footer.jsp" %>