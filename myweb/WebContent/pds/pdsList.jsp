<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../bbs/ssi.jsp" %>
<%@ include file="../header.jsp" %>

<!-- 본문 시작 pdsList.jsp -->
<h3>* 포토 갤러리 *</h3>
<p><a href="pdsForm.jsp">[사진 업로드 하기]</a></p>
<div class="container-2">
<%
int recordPerPage = 2;
ArrayList<PdsDTO> list =pdsDao.list(col, word, nowPage, recordPerPage);
int total = pdsDao.count(col, word);

if(list==null){
	out.println("게시글 없음");
}else{
	

%>
<br>
	<table class="table table-hover text-left">
		<thead>
			<tr>
				<th>넘버</th>
				<th>작성자</th>
				<th>제목</th>
				<th>사진</th>
				<th>조회수</th>
				<th>작성일</th>
			</tr>
		 </thead>
	<tbody>
	<%
for(int i=0; i<list.size(); i++){
	pdsDto= list.get(i);


%>
	
			<tr>
				<td><%=pdsDto.getPdsno() %></td>
				<td><%=pdsDto.getWname() %></td>
				<td><a href="pdsRead.jsp?pdsno=<%=pdsDto.getPdsno() %>&word=<%=word%>&col=<%=col%>"><%=pdsDto.getSubject() %></td>
				<td><img src="../storage/<%=pdsDto.getFilename() %>" width="150"></td>
				<td><%=pdsDto.getReadcnt() %></td>
				<td><%=pdsDto.getRegdate().substring(0,10) %></td>
			</tr>
<%
}
}
%>

		</tbody>
	</table>

</div>
<!-- 본문 끝 -->

<!-- 검색 start -->		
				<div style="background-color:lightgrey;height:50px;padding-top:8px;">
					<form action="pdsList.jsp" onsubmit="return searchCheck()">
						<div class="row">
						<div class="col-sm-2">
						</div>
						<div class="col-sm-2">
							<select class="form-control" name="col" id="col" >
								<option value="subject">제목</option>
								<option value="subject_filename">제목+이미지명</option>
							</select>
						</div>
						<div class="col-sm-4">
							<input type="text" class="form-control" name="word" id="word" >
						</div>
						<div class="col-sm-2">
							<input type="submit" class="btn btn-primary" value="검색하기" >
						</div>
						<div class="col-sm-2">
						</div>
						</div>
					</form>
				</div><!-- 검색 end -->
				
<!-- 페이지네이션 start -->
<%
	Paging paging = new Paging();
	out.print(paging.paging2(total, nowPage, recordPerPage, col, word, "pdsList.jsp"));
%><!-- 페이지네이션 end -->

<%@ include file="../footer.jsp" %>