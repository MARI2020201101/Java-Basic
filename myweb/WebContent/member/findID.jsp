<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%@ include file="../bbs/ssi.jsp" %>
<!-- 본문 시작 -->
<div class="container-2">
<form action="findIDproc.jsp" method="post" >
<div class="row">
			<div class="col-sm-4"></div>
			<div class="form-group col-sm-4">
				<label>아이디</label> 
				<input type="text" class="form-control" id="id" name="id" placeholder="Enter id" required>
			</div>
			<div class="col-sm-4"></div>
		</div>
		<div class="row">
			<div class="col-sm-4"></div>
			<div class="form-group col-sm-4">
				<label>가입당시 이메일</label> 
				<input type="email" class="form-control" id="email" name="email" placeholder="Email" required>
			</div>
			<div class="col-sm-4"></div>
		</div>
		<div class="row">
			<button type="submit" class="btn btn-primary">임시 비밀번호 발급 요청하기</button>
		</div>	
</form>	
</div>
<!-- 본문 끝 -->

<%@ include file="../footer.jsp" %>