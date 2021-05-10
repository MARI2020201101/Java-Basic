<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<!-- 본문 시작 pdsForm.jsp -->
<div class="container-2">
<h3>* 글쓰기 *</h3>
<p><a href="pdsList.jsp">[포토갤러리로 가기]</a></p>
<form name="photofrm" id="photofrm" method="post" action="pdsIns.jsp" 
		enctype="multipart/form-data" 
		onsubmit="return pdsCheck()">
<table class="table">
<tr>
   <th>작성자</th>
   <td><input type="text" name="wname" id="wname" class="form-control" maxlength="20" required></td>
</tr>
<tr>
   <th>제목</th>
   <td><input type="text" name="subject" id="subject" class="form-control" maxlength="100" required></td>
</tr>
<tr>
   <th>비밀번호</th>
   <td><input type="password" name="passwd" id="passwd" class="form-control" maxlength="10" required></td>
</tr>
<tr>
   <th>첨부파일</th>
   <td><input type="file" name="filename" id="filename" class="form-control"></td>
</tr>
<tr>
    <td colspan="2" align="center">
       <input type="submit" value="사진올리기" class="btn btn-success ">
       <input type="reset"  onclick="history.back();" value="취소" class="btn btn-danger">
    </td>
</table>
</form>
</div>
<!-- 본문 끝 -->

<%@ include file="../footer.jsp" %>