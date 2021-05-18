<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>


<!-- 본문 시작 loginPro.jsp -->
<div class="container-2">
<h3>* 로 그 인 Pro *</h3>
<br>
<c:if test="${res==1 }">
	<c:set var="memid" value="${sessionScope.s_id }" scope="session"/>
	<meta http-equiv="Refresh" content="0;url=/myweb/member2/loginForm.do">
</c:if>
<c:if test="${res==0}">
	<span>아이디 또는 패스워드를 확인해주십시요</span>
	<br>
	<a href="javascript:history.back();">[돌아가기]</a>
</c:if>
</div>			
<!-- 본문 끝 -->
<%@ include file="../footer.jsp" %>