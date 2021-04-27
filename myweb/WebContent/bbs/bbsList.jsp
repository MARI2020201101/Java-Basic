<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="ssi.jsp" %>
<%@ include file="../header.jsp" %>

<!-- 본문 시작 bbsList.jsp -->
<h3>* 글 목록 *</h3>
<p><a href="bbsForm.jsp">[글쓰기]</a></p>
<div class="container">
<br><br>
	<table class="table table-hover text-left">
			<tr>
				<th>제목</th>
				<th>조회수</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
		<tbody>
	
<%
	ArrayList<BbsDTO> list = dao.list();
if(list==null){
	out.println("리스트 없음");
}else{
	String today=Utility.getDate();
	
	for(int i=0;i<list.size();i++){
		dto=list.get(i);

%>
			<tr>
				<td><a href="bbsRead.jsp?bbsno=<%=dto.getBbsno() %>">
					<%=dto.getSubject() %></a>
<% 				
				//오늘 작성한 글이면 new이미지 출력
				String regdt=dto.getRegdt().substring(0,10);
				if(regdt.equals(today)){
					out.println("<img src='../images/new.gif'>");
				}
				//조회수가 10이상이면 hot이미지 출력
				if(dto.getReadcnt()>=10){
					out.println("<img src='../images/hot.gif'>");
				}
%>	
				</td>
				<td><%=dto.getReadcnt()%></td>
				<td><%=dto.getWname() %></td>
				<td><%=dto.getRegdt().substring(0,10).replace("-", " / ") %></td>
			</tr>
<%
			}
		}
%> 
			</tbody>
	</table>
</div>
<!-- 본문 끝 -->
<%@ include file="../footer.jsp" %>