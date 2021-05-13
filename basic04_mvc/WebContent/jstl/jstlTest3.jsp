<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTLTest3</title>
</head>
<body>
	<h3>* JSTL 함수 *</h3>
	<c:set var="txt" value="  white space	"></c:set>
	글자갯수 : ${fn:length(txt) }
	<c:set var="txt" value="Hi my name is mari 	"></c:set>
	문자열 자르기 : ${fn: substring(txt,0,3) }
	
	<hr>
	특수문자 변환 : <c:out value="${fn:escapeXml('<>') }"></c:out>
	공백제거 : @<c:out value="${fn:trim(txt) }"></c:out>@

	<hr>
<%
	//1)JSP
	String content="";
	content.replace("\n", "<br>");
	
	//2)EL+JSTL
	pageContext.setAttribute("cn","\n");
%>
<c:set var="content" value="
Hi
My
name
is
Mari

"></c:set>
<c:out value="${content }"></c:out>
<br>
${fn:replace(content,cn,"<br>") }
<hr>
<c:set var="info" value="
Hi
My				name		is
Mari

"></c:set>
${fn:replace(fn:replace(fn:escapeXml(info),cn,'<br>'),' ','&nbsp;')}
</html>