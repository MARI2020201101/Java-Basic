<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<!-- 본문 시작 -->
<div class="container-2">
<h3>* 파일첨부 테스트 *</h3>
<br>
<form method="post" action="pdsTestProc.jsp" enctype="multipart/form-data">
<div class="row">
<div class="col-sm-3">
<label>이름:</label>
</div>
<div class="col-sm-9">
<input type="text" name="uname" class="form-control">
</div>
</div>
<div class="row">
<div class="col-sm-3">
<label>제목:</label>
</div>
<div class="col-sm-9">
<input type="text" name="subject" class="form-control">
</div>
</div>
<div class="row">
<div class="col-sm-3">
<label>내용:</label>
</div>
<div class="col-sm-9">
<textarea rows="5" cols="20" name="content" class="form-control">

</textarea></div>
</div>
<div class="row">
<div class="col-sm-3">
<label>파일:</label>
</div>
<div class="col-sm-9">
<input type="file" name="filenm" class="form-control">
</div>
</div>
<input type="submit" value="전송하기" class="btn btn-primary">
</form>
</div>
<!-- 본문 끝 -->

<%@ include file="../footer.jsp" %>