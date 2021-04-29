<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="ssi.jsp" %>
<%@ include file="../header.jsp" %>

<!-- 본문 시작 bbsList.jsp -->
<h3>* 글 목록 *</h3>
<p><a href="bbsForm.jsp">[글쓰기]</a></p>
<div class="container">
<br>
	<table class="table table-hover text-left">
		<thead>
			<tr>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>작성일</th>
			</tr>
		 </thead>
		<tbody>
	
<%
    ArrayList<BbsDTO> list = dao.list2(col, word);
	
	int total = dao.count2(col, word);
if(list==null){
	out.println("리스트 없음");
}else{
	String today=Utility.getDate();
	
	for(int i=0;i<list.size();i++){
		dto=list.get(i);

%>
			<tr>
				<td>
<% 
			//indent개수별로 댓글indent이미지출력
			for(int n=1; n<=dto.getIndent();n++){
				out.println("<img src='../images/reply.gif'>");
			}
%>					
				<a href="bbsRead.jsp?bbsno=<%=dto.getBbsno() %>&col=<%=col%>&word=<%=word%>">
					<%=dto.getSubject() %></a>
<% 				
				//오늘 작성한 글이면 new이미지 출력
				String regdt=dto.getRegdt().substring(0,10);
				if(regdt.equals(today)){
					out.println("<img src='../images/new.gif'>");
				}
				//조회수가 20이상이면 hot이미지 출력
				if(dto.getReadcnt()>=20){
					out.println("<img src='../images/hot.gif'>");
				}
%>	
				</td>
				<td><%=dto.getWname() %></td>
				<td><%=dto.getReadcnt()%></td>
				<td><%=dto.getRegdt().substring(0,10).replace("-", " / ") %></td>
			</tr>
<%
			}
		}
%> 
				<tr>
				<td colspan="4"></td>
				</tr>
				<tr>
				<td colspan="4"><strong>전체 게시글 개수 : </strong>&nbsp;&nbsp;<%=total %></td>
				</tr>
		
				<tr style="background-color:lightgrey;">
					<form action="bbsList.jsp" onsubmit="return searchCheck()">
						<td><select class="form-control" name="col" id="col" style="width:140px;left:150px;position:relative;">
							<option value="subject">제목</option>
							<option value="content">내용</option>
							<option value="wname">작성자</option>
							<option value="subject_content">제목+내용</option>
						</select></td>
						<td>
							<input type="text" class="form-control" name="word" id="word" style="left:60px;position:relative;">
						</td>
						<td>
							<input type="submit" class="btn btn-primary" value="검색하기" style="width:100px;left:100px;position:relative;" >
						</td>
						<td></td>
					</form>
				</tr>
			</tbody>
	</table>
	<nav aria-label="...">
	  <ul class="pagination">
	    <li class="page-item disabled">
	      <a class="page-link" href="#" tabindex="-1">Previous</a>
	    </li>
	    <li class="page-item"><a class="page-link" href="#">1</a></li>
	    <li class="page-item active">
	      <a class="page-link" href="#">2 <span class="sr-only">(current)</span></a>
	    </li>
	    <li class="page-item"><a class="page-link" href="#">3</a></li>
	    <li class="page-item">
	      <a class="page-link" href="#">Next</a>
	    </li>
	  </ul>
	</nav>
</div>
<!-- 본문 끝 -->
<%@ include file="../footer.jsp" %>