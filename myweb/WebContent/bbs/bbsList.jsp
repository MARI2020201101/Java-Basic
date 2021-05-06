<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="ssi.jsp" %>
<%@ include file="../header.jsp" %>

<!-- 본문 시작 bbsList.jsp -->
<h3>* 글 목록 *</h3>
<p><a href="bbsForm.jsp">[글쓰기]</a></p>
<div class="container-2">
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
	
	int recordPerPage = 5;//한페이지당 출력할 행의 개수
    ArrayList<BbsDTO> list = dao.list3(col, word, nowPage, recordPerPage);
	
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
		<!-- 게시글 개수 start -->
				<tr>
					<td colspan="4"></td>
				</tr>
				<tr>
					<td colspan="4"><strong>전체 게시글 개수 : </strong>&nbsp;&nbsp;<%=total %></td>
				</tr><!-- 게시글 개수 end -->
		</tbody>
	</table>
<!-- 검색 start -->		
				<div style="background-color:lightgrey;height:50px;padding-top:8px;">
					<form action="bbsList.jsp" onsubmit="return searchCheck()">
						<div class="row">
							<div class="col-sm-2">
							</div>
							<div class="col-sm-2">
								<select class="form-control" name="col" id="col" >
									<option value="subject">제목</option>
									<option value="content">내용</option>
									<option value="wname">작성자</option>
									<option value="subject_content">제목+내용</option>
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
	out.print(paging.paging2(total, nowPage, recordPerPage, col, word, "bbsList.jsp"));
%><!-- 페이지네이션 end -->

</div>
<!-- 본문 끝 -->
<%@ include file="../footer.jsp" %>