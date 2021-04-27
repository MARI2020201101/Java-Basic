<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="ssi.jsp" %>
<%@ include file="../header.jsp" %>

<!-- 본문 시작 bbsDel.jsp -->
<h3>* 글 삭제 *</h3>
<p><a href="bbsList.jsp">[글목록]</a></p>
<div class="container">
<form>
<type="hidden" id="bbsno" name="bbsno" value="<%= dto.getBbsno()%>">
 <div class="form-group">
    <label for="password">비밀번호 입력</label>
    <small id="passwd" class="form-text text-muted ">삭제를 위하여 비밀번호를 입력해 주십시요.</small>
    <input type="password" class="form-control" id="passwd" name="passwd" placeholder="Enter password">
    <button class="btn btn-danger">삭제</button>
  </div>
</form>
</div>
<!-- 본문 끝 -->
<%@ include file="../footer.jsp" %>