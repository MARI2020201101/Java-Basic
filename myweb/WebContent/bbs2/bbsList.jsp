<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<!-- 본문 시작 bbs2List.jsp -->
<h3>* 글 목록 *</h3>
<p><a href="bbsform.do">[글쓰기]</a></p>
<div class="container-2">
<br>
	<table class="table table-hover text-left">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
		 </thead>
		<tbody>
		<c:forEach var="article" items="${list }">
		<tr>
			<td>
				<c:out value="${number }"></c:out>
				<c:set var="number" value="${number-1 }"></c:set>
			</td>
			<td>
				<c:if test="${article.re_level>0 }"></c:if>
					<c:forEach var="i" begin="1" end="${article.re_level}" step="1">
					<img src = "../images/reply.gif">
					</c:forEach>		
				${article.subject }	
			</td>
			<td>${article.writer }</td>
			<td>${article.reg_date }</td>
			<td>${article.readcount}</td>
		</tr>		
		</c:forEach>
		</tbody>
	</table>
<!-- 페이지 리스트 -->
<c:if test="${count>0 }">
	<c:set var="pageCount" value="${totalPage }"/>
	<c:set var="startPage" value="${startPage }"/>
	<c:set var="endPage" value="${endPage }"/>
	<c:if test="${ endPage>pageCount }">
		<c:set var="endPage" value="${pageCount+1 }"/>
	</c:if>
	<c:if test="${ startPage>0}">
		<a href="bbsList.do?pageNum=${startPage }">[prev]</a>
	</c:if>
	<c:forEach var="i" begin="${startPage+1 }" end="${endPage-1 }">
		<a href="bbsList.do?pageNum=${i}">[${i }]</a>
	</c:forEach>
	<c:if test="${ endPage<pageCount}">
		<a href="bbsList.do?pageNum=${startPage +11}">[next]</a>
	</c:if>
</c:if>
</div>
<!-- 본문 끝 -->
<%@ include file="../footer.jsp" %>