<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="ssi.jsp" %>
<%@ include file="../header.jsp" %>

<!-- 본문 시작 bbsDel.jsp -->
<h3>* 글 삭제 *</h3>
<p><a href="bbsList.jsp">[글목록]</a></p>
<br>
<div class="container-2">
<div class="row">
	<div class="col-sm-4"></div>
	<div class="col-sm-4">
	<form method="post" action="bbsDelProc.jsp" onsubmit="return pwCheck()">
		<input type="hidden" id="bbsno" name="bbsno" value="<%= request.getParameter("bbsno")%>">
	 	
	 	<div class="form-group">
		    <label for="password">비밀번호 입력</label><br>
		    <div >
		    <input type="password" class="form-control" id="passwd" name="passwd" required>
	    	</div>
	  	</div>
	  <input type="submit" class="btn btn-danger" value="삭제">
	</form>
	</div>
	<div class="col-sm-4"></div>
	</div>
</div>
<!-- 본문 끝 -->
<%@ include file="../footer.jsp" %>