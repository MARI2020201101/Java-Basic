<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../bbs/ssi.jsp" %>
<%@ include file="../header.jsp" %>

<!-- 본문 시작 noticeRead.jsp -->
<h3>* 공지사항 상세보기 *</h3>
<p><a href="noticeForm.jsp">[공지사항 등록]</a></p>
<p><a href="noticeList.jsp?word=<%=word%>">[공지사항 목록]</a></p>

<%
	int noticeno= Integer.parseInt(request.getParameter("noticeno"));
	
	noticeDto = noticeDao.read(noticeno);
	
	if(noticeDto==null){
		out.println("상세보기할 글을 불러오지 못했습니다.");	
	}else{
		

%>
<div class="container">
	<table class="table">
	<tr>
	   <th>제목</th>
	   <td><input type="text" name="subject" id="subject" class="form-control readbox-color" maxlength="100" readonly value="<%=noticeDto.getSubject() %>"></td>
	</tr>
	<tr>
	   <th>내용</th>
	   <td><textarea rows="10" class="form-control readbox-color" name="content" id="content" readonly><%=noticeDto.getContent() %></textarea></td>
	</tr>
	<tr>
		<th>작성일</th>
		<td><input type="text" class="form-control readbox-color" readonly value="<%=noticeDto.getRegdt() %>"></td>
	</tr>
	</table>
	 <input type="button" value="수정" class="btn btn-warning" onclick="location.href='noticeUpdate.jsp?noticeno=<%=noticeDto.getNoticeno()%>'">
     <input type="button"  value="삭제" class="btn btn-danger" onclick="location.href='noticeDel.jsp?noticeno=<%=noticeDto.getNoticeno()%>'">
</div>
<%
	}
%>
<!-- 본문 끝 -->
<%@ include file="../footer.jsp" %>