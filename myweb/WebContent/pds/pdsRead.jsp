<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../bbs/ssi.jsp" %>
<%@ include file="../header.jsp" %>
<%@ include file="../member/auth.jsp" %>

<!-- 본문 시작 pdsRead.jsp -->
<h3>* 포토 상세보기 *</h3>
<p><a href="pdsList.jsp">[포토갤러리 목록]</a></p>
<p><a href="pdsForm.jsp">[포토갤러리 작성]</a></p>

<%
	int pdsno= Integer.parseInt(request.getParameter("pdsno"));
	
	pdsDto = pdsDao.read(pdsno);
	
	if(pdsDto==null){
		out.println("사진을 불러오지 못했습니다.");	
	}else{
		pdsDao.incrementCnt(pdsno);
	}
%>
<div class="container">
	<table class="table">
	<tr>
	   <th>제목</th>
	   <td><input type="text" name="subject" id="subject" class="form-control readbox-color" maxlength="100" readonly value="<%=pdsDto.getSubject() %>"></td>
	</tr>
	<tr>
	   <th>사진</th>
	   <td><img src ="../storage/<%=pdsDto.getFilename()%>" width="400"></td>
	</tr>
	<tr>
		<th>파일크기</th>
		<td><input type="text" class="form-control readbox-color" readonly value="<%=Utility.toUnitStr(pdsDto.getFilesize()) %>"></td>
	</tr>
	<tr>
		<th>작성자</th>
		<td><input type="text" class="form-control readbox-color" readonly value="<%=pdsDto.getWname() %>"></td>
	</tr>
	<tr>
		<th>작성일</th>
		<td><input type="text" class="form-control readbox-color" readonly value="<%=pdsDto.getRegdate().substring(0,10) %>"></td>
	</tr>
	<tr>
		<th>조회수</th>
		<td><input type="text" class="form-control readbox-color" readonly value="<%=pdsDto.getReadcnt() %>"></td>
	</tr>
	</table>
<%
if(s_id!="guest"){
%>
	<input type="button" value="삭제" class="btn btn-danger" onclick="location.href='pdsDel.jsp?pdsno=<%=pdsDto.getPdsno()%>'">
	 
	
	
<% 
}
%>
	
</div>
<!-- 본문 끝 -->
<%@ include file="../footer.jsp" %>