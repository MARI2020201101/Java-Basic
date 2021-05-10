<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../bbs/ssi.jsp" %>
<%@ include file="../header.jsp" %>

<!-- 본문 시작 pdsList.jsp -->
<h3>* 포토 갤러리 *</h3>
<p><a href="pdsForm.jsp">[사진 업로드 하기]</a></p>
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
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
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

</div>
<!-- 본문 끝 -->
<%@ include file="../footer.jsp" %>