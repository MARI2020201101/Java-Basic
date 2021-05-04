<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../bbs/ssi.jsp" %>
<%@ include file="../header.jsp" %>

<!-- 본문 시작 unregister.jsp -->
<h3>* 회원 탈퇴 *</h3>
<a href="javascript:history.back()">[뒤로 가기]</a>
<br>
<br>
<div class="container">
<div class="row">
	<div class="col-sm-4"></div>
	<div class="col-sm-4">
		<form method="post" action="unregisterProc.jsp">
			<input type="hidden" id="id" name="id" value="<%= request.getParameter("id")%>">	
		 	<p>정말로 탈퇴하시겠습니까?</p>	 	
		 	<div class="form-group">
			    <label for="password">비밀번호 입력</label><br>
			    <div >
			    <input type="password" class="form-control" id="passwd" name="passwd" required>
		    	</div>
		  	</div>
		  <input type="submit" class="btn btn-danger" value="진행">
		</form>
	</div>
	<div class="col-sm-4"></div>
	</div>
</div>
<!-- 본문 끝 -->
<%@ include file="../footer.jsp" %>