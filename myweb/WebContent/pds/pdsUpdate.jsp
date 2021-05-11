<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../bbs/ssi.jsp" %>
<%@ include file="../header.jsp" %>
<%@ include file="../member/auth.jsp" %>

<!-- 본문 시작 pdsUpdate.jsp -->
<h3>* 포토 수정하기 *</h3>
<p><a href="pdsList.jsp">[포토갤러리 목록]</a></p>
<p><a href="pdsForm.jsp">[포토갤러리 작성]</a></p>

<%
	int pdsno= Integer.parseInt(request.getParameter("pdsno"));
	
	pdsDto = pdsDao.read(pdsno);
	
	if(pdsDto==null){
		out.println("사진을 불러오지 못했습니다.");	
	}
	
	if(s_id=="guest"){
		out.println("수정 권한이 없습니다.");
	}else{
		

%>
<form action="pdsUpdateProc.jsp" enctype="multipart/form-data" 
		onsubmit="return pdsCheck()">
<div class="container">
	<table class="table">
	<tr>
	   <th>제목</th>
	   <td><input type="text" name="subject" id="subject" class="form-control readbox-color" maxlength="100" value="<%=pdsDto.getSubject() %>"></td>
	</tr>
	<tr>
	   <th>사진</th>
	   <td><img src ="../storage/<%=pdsDto.getFilename()%>" width="400">
	   <input type="file" name="filename" id="filename" class="form-control"></td>
	</tr>
	<tr>
		<th>작성자</th>
		<td><input type="text" name="wname" id="wname" class="form-control readbox-color" value="<%=pdsDto.getWname() %>"></td>
	</tr>
		<tr>
	   <th>비밀번호</th>
	   <td><input type="password" name="passwd" id="passwd" class="form-control" maxlength="10" required></td>
	</tr>
	<tr>
    <td colspan="2" align="center">
       <input type="submit" value="수정하기" class="btn btn-success">
       <input type="reset"  onclick="history.back();" value="취소" class="btn btn-danger">
    </td>
    </tr>
	</table>
</div>
</form>
<%
	}
%>
<!-- 본문 끝 -->
<%@ include file="../footer.jsp" %>