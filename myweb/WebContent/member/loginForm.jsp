<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<!-- 본문 시작 loginForm.jsp -->
<div class="container">
<h3>* 로 그 인 *</h3>
<br>
	<form method="post" action="loginProc.jsp" onsubmit="return loginCheck()">
		<div class="row">
			<div class="col-sm-4"></div>
			<div class="form-group col-sm-4">
				<label>아이디</label> 
				<input type="text" class="form-control" id="id" name="id" placeholder="Enter id">
			</div>
			<div class="col-sm-4"></div>
		</div>
		<div class="row">
			<div class="col-sm-4"></div>
			<div class="form-group col-sm-4">
				<label>비밀번호</label> 
				<input type="password" class="form-control" id="passwd" name="passwd" placeholder="Password">
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
				<input type="checkbox" >&nbsp;로그인 기억하기
			</div>
			<div class="row">
				<a href="">회원가입</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="">아이디 / 비밀번호 찾기</a>
			</div>
			</div>
			<div class="col-sm-4" ></div>	
		</div>
	</form>
			
</div>

<!-- 본문 끝 -->
<%@ include file="../footer.jsp" %>