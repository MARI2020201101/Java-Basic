<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<!-- 본문 시작 bbsForm.jsp -->
<h3>* 글쓰기 *</h3>
<p><a href="bbsList.jsp">[글목록]</a></p>
<div class="container-2">
<form method="post" action="bbsReplyProc.jsp" onsubmit="return bbsCheck()">
	<input type="hidden" name="bbsno" value="<%= request.getParameter("bbsno")%>">
	<table class="table">
	<tr>
	   <th>작성자</th>
	   <td><input type="text" name="wname" id="wname" class="form-control" maxlength="20" required></td>
	</tr>
	<tr>
	   <th>제목</th>
	   <td><input type="text" name="subject" id="subject" class="form-control" maxlength="100" required></td>
	</tr>
	<tr>
	   <th>내용</th>
	   <td><textarea rows="5"  class="form-control" name="content" id="content"></textarea></td>
	</tr>
	<tr>
	   <th>비밀번호</th>
	   <td><input type="password" name="passwd" id="passwd" class="form-control" maxlength="10" required></td>
	</tr>
	<tr>
	    <td colspan="2" align="center">
	       <input type="submit" value="쓰기" class="btn btn-success">
	       <input type="reset"  value="취소" onclick="history.back();" class="btn btn-danger">
	    </td>
	</table>
</form>
</div>
<!-- 본문 끝 -->

<%@ include file="../footer.jsp" %>