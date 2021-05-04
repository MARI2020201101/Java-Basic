<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="ssi.jsp" %>
<%@ include file="../header.jsp" %>
<%@ include file="../member/auth.jsp" %>

<!-- 본문 시작 bbsRead.jsp -->
<h3>* 게시판 상세보기 *</h3>
<p><a href="bbsForm.jsp">[글쓰기]</a></p>
<p><a href="bbsList.jsp?col=<%=col%>&word=<%=word%>">[글목록]</a></p>

<%
	int bbsno= Integer.parseInt(request.getParameter("bbsno"));

	dto = dao.read(bbsno);
	
	if(dto==null){
		out.println("상세보기할 글을 불러오지 못했습니다.");	
	}else{
		dao.incrementCnt(bbsno);

%>
<div class="container">
	<table class="table">
	<tr>
	   <th>작성자</th>
	   <td><input type="text" name="wname" id="wname" class="form-control readbox-color" maxlength="20" readonly value="<%=dto.getWname() %>"></td>
	</tr>
	<tr>
	   <th>제목</th>
	   <td><input type="text" name="subject" id="subject" class="form-control readbox-color" maxlength="100" readonly value="<%=dto.getSubject() %>"></td>
	</tr>
	<tr>
	   <th>내용</th>
	   <td><textarea rows="10" class="form-control readbox-color" name="content" id="content" readonly><%=Utility.convertCharTA(dto.getContent()) %></textarea></td>
	</tr>
	<tr>
		<th>조회수</th>
		<td><input type="text" class="form-control readbox-color" readonly value="<%=dto.getReadcnt() %>"></td>
	</tr>
	<tr>
		<th>작성일</th>
		<td><input type="text" class="form-control readbox-color" readonly value="<%=dto.getRegdt() %>"></td>
	</tr>
	<tr>
		<th>IP</th>
		<td><input type="text" class="form-control readbox-color" readonly value="<%=dto.getIp() %>"></td>
	</tr>
	</table>
	 <input type="button" value="답변" class="btn btn-success" onclick="location.href='bbsReply.jsp?bbsno=<%=dto.getBbsno()%>'">
	 <input type="button" value="수정" class="btn btn-warning" onclick="location.href='bbsUpdate.jsp?bbsno=<%=dto.getBbsno()%>'">
<%
if(s_mlevel.equals("A1")){
%>
<input type="button"  value="삭제" class="btn btn-danger" onclick="location.href='bbsDel.jsp?bbsno=<%=dto.getBbsno()%>'">
<% 	
}
%>      
   
</div>
<%
	}
%>
<!-- 본문 끝 -->
<%@ include file="../footer.jsp" %>