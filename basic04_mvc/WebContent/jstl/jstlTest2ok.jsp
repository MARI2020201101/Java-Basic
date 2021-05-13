<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTLTest2 ok</title>
</head>
<body>
<h3>* jstlTest2 결과 *</h3>

<c:set var="name" value="${param.name }"></c:set>
<c:set var="age" value="${param.age }"></c:set>
<c:out value="${name }"></c:out>
<c:out value="${age }"></c:out>
<br>
<hr>
<c:if test="${name eq 'mari'}">마리입니다.</c:if>
<c:choose>
	<c:when test="${age<10 }">어린이</c:when>
	<c:when test="${age<20 }">청소년</c:when>
	<c:otherwise>성인</c:otherwise>
</c:choose>

<c:forEach var="a" begin="1" end="${age }" step="1">
<c:out value="#"></c:out>
</c:forEach>

<hr>

<c:forEach var="a" begin="1" end="${age }" step="1">
<c:choose>
	<c:when test="${a%2==1 }">
		<span style='color:red;'>
		<c:out value="${a }"></c:out>
		</span>
	</c:when>
	<c:otherwise>
		<span style='color:blue;'>
		<c:out value="${a }"></c:out>
		</span>
	</c:otherwise>
</c:choose>
</c:forEach>
</body>
</html>