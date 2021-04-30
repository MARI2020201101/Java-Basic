<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../bbs/ssi.jsp" %>
<%@ include file="../header.jsp" %>

<!-- 본문 시작 noticeRead.jsp -->
<h3>* 글 수정하기 *</h3>
<p><a href="noticeForm.jsp">[공지사항 등록]</a></p>
<p><a href="noticeList.jsp">[공지사항 목록]</a></p>

<%
	int noticeno= Integer.parseInt(request.getParameter("noticeno"));
	noticeDto = noticeDao.read(noticeno);
	
	if(noticeDto==null){
		out.println("상세보기할 글을 불러오지 못했습니다.");	
	}else{

%>
<div class="container">
<form action="noticeUpdateProc.jsp" method="post" onsubmit="return noticeCheck()">
	<input type="hidden" name="noticeno" value="<%= request.getParameter("noticeno")%>">
	<table class="table">
	<tr>
	   <th>제목</th>
	   <td><input type="text" name="subject" id="subject" class="form-control readbox-color" maxlength="100" value="<%=noticeDto.getSubject() %>"></td>
	</tr>
	<tr>
	   <th>내용</th>
	   <td><textarea rows="10" class="form-control readbox-color" name="content" id="content" ><%=noticeDto.getContent() %></textarea></td>
	</tr>
	</table>

	 <input type="submit" value="수정" class="btn btn-warning" >

</form>
</div>
<%
	}
%>
<!-- 본문 끝 -->
<%@ include file="../footer.jsp" %>