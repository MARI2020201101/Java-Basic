<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../bbs/ssi.jsp" %>
<%@ include file="../header.jsp" %>

<!-- 본문 시작 noticeList.jsp -->
<h3>* 공지사항 목록 *</h3>
<p><a href="noticeForm.jsp">[공지사항 등록]</a></p>
<div class="container">
<br>
	<table class="table table-hover text-left">
		<thead>
			<tr>
				<th>제목</th>
				<th style="text-align:center">작성일</th>
			</tr>
		 </thead>
		<tbody>
	
<%
	int recordPerPage = 5;//한페이지당 출력할 행의 개수
	int total = noticeDao.count(col,word);
    ArrayList<NoticeDTO> notices =noticeDao.list(col,word,nowPage, recordPerPage);

	if(notices==null){
		out.println("리스트 없음");
	}else{
	
	for(int i=0;i<notices.size();i++){
		noticeDto=notices.get(i);
%>
			<tr>
				<td>
				<a href="noticeRead.jsp?noticeno=<%=noticeDto.getNoticeno() %>&word=<%=word%>">
					<%=noticeDto.getSubject() %></a>
				</td>
				<td style="text-align:center"><%=noticeDto.getRegdt().substring(0,10).replace("-", " / ") %></td>
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
					<form action="noticeList.jsp" onsubmit="return searchCheck()">
						<div class="row">
						<div class="col-sm-1">
						</div>
						<div class="col-sm-3">
							<select class="form-control" name="col" id="col" style="width:140px;left:140px;position:relative;">
								<option value="subject">제목</option>
								<option value="subject_content">제목+내용</option>
							</select>
						</div>
						<div class="col-sm-4">
							<input type="text" class="form-control" name="word" id="word" style="width:450px;">
						</div>
						<div class="col-sm-3">
							<input type="submit" class="btn btn-primary" value="검색하기" style="width:100px;left:0px;position:relative;">
						</div>
						<div class="col-sm-1">
						</div>
						</div>
					</form>
				</div><!-- 검색 end -->
				
<!-- 페이지네이션 start -->
<%
	Paging paging = new Paging();
	out.print(paging.paging2(total, nowPage, recordPerPage, col, word, "noticeList.jsp"));
%><!-- 페이지네이션 end -->
</div>

<!-- 본문 끝 -->
<%@ include file="../footer.jsp" %>