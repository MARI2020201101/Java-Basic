<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<!-- 본문 시작 -->
<h3>* 글 삭제 *</h3>
<p><a href="pdList.jsp">[글목록]</a></p>
<br>
<div class="container-2">
<div class="row">
	<div class="col-sm-4"></div>
	<div class="col-sm-4">
	<form method="post" action="pdsDelProc.jsp" onsubmit="return pwCheck()">
		<input type="hidden" id="pdsno" name="pdsno" value="<%= request.getParameter("pdsno")%>">
	 	
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