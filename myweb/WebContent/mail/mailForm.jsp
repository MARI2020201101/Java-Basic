<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<!-- 본문 시작 -->
<div class="container-2">
<h3>* 메일 보내기 *</h3>
<br>
<form method="post" action="mailProc.jsp">
<table class="table">
<tr>
    <th>받는사람</th>
	<td><input type="email" name="to" class="form-control"></td>
</tr>
<tr>
    <th>보내는사람</th>
	<td><input type="email" name="from" class="form-control"></td>
</tr>
 <tr>
   <th>제목</th>
   <td><input type="text" name="subject" class="form-control"></td>
 </tr>
 <tr>
   <th>내용</th>
   <td><textarea rows="5" cols="30" name="content" class="form-control"></textarea></td>
 </tr>
 <tr>
   <td colspan="2">
     <input type="submit" value="메일보내기" class="btn btn-primary">
     <input type="reset"  value="취소"      class="btn btn-primary">
   </td>
 </tr> 
</table>
</form>
</div>
<!-- 본문 끝 -->

<%@ include file="../footer.jsp" %>