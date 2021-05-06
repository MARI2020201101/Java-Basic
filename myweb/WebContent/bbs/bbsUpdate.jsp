<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="ssi.jsp" %>
<%@ include file="../header.jsp" %>

<!-- 본문 시작 bbsRead.jsp -->
<h3>* 글 수정하기 *</h3>
<p><a href="bbsForm.jsp">[글쓰기]</a></p>
<p><a href="bbsList.jsp">[글목록]</a></p>

<%
	int bbsno= Integer.parseInt(request.getParameter("bbsno"));
	dto = dao.read(bbsno);
	if(dto==null){
		out.println("상세보기할 글을 불러오지 못했습니다.");	
	}else{
		dao.incrementCnt(bbsno);

%>
<div class="container-2">
<form action="bbsUpdateProc.jsp" method="post" onsubmit="return bbsCheck()">
	<input type="hidden" name="bbsno" value="<%= request.getParameter("bbsno")%>">
	<table class="table">
	<tr>
	   <th>작성자</th>
	   <td><input type="text" name="wname" id="wname" class="form-control readbox-color" maxlength="20" value="<%=dto.getWname() %>" required></td>
	</tr>
	<tr>
	   <th>제목</th>
	   <td><input type="text" name="subject" id="subject" class="form-control readbox-color" maxlength="100" value="<%=dto.getSubject() %>" required></td>
	</tr>
	<tr>
	   <th>내용</th>
	   <td><textarea rows="10" class="form-control readbox-color" name="content" id="content" required><%=Utility.convertCharTA(dto.getContent()) %></textarea></td>
	</tr>
	<tr>
	   <th>비밀번호</th>
	   <td><input type="password" name="passwd" id="passwd" class="form-control" maxlength="10" required></td>
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