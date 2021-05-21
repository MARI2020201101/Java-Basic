<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<!-- 본문 시작 bbsForm.jsp -->
<h3>* 글쓰기 *</h3>
<form method="post" name="writeform" action="./bbsinsert.do">
<input type="hidden" name="num"      value="${requestScope.num}">
<input type="hidden" name="ref"      value="${requestScope.ref}">
<input type="hidden" name="re_step"  value="${requestScope.re_step}">
<input type="hidden" name="re_level" value="${requestScope.re_level}">

<table class="table">
<tr>
  <td align="right" colspan="2"><a href="${root }/bbs2/bbsList.do">글목록</a></td>
</tr>
<tr>
  <td>이름</td>
  <td><input type="text" name="writer" class="form-control"></td>
</tr>
<tr>
  <td>제목</td>
  <td><input type="text" name="subject" class="form-control"></td>
</tr>
<tr>
  <td>이메일</td>
  <td><input type="text" name="email" class="form-control"></td>
</tr>
<tr>
  <td>내용</td>
  <td><textarea name="content" rows="5" cols="40" class="form-control"></textarea></td>
</tr>
<tr>
  <td>비밀번호</td>
  <td><input type="password" name="passwd" class="form-control"></td>
</tr>
<tr>
  <td colspan="2" align="center">
  <input type="submit" value="글쓰기" class="btn btn-primary">
  <input type="reset"  value="취소" class="btn btn-warning">
  <input type="button" value="목록보기" class="btn btn-info" onClick="location.href='./bbsList.do'">
  </td>
</tr>
</table>
</form>
<!-- 본문 끝 -->
<%@ include file="../footer.jsp" %> 
</html>