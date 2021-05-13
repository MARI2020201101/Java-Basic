<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTLTest1</title>
</head>
<body>
<h3>* jstlTest1.jsp *</h3>

<c:set var="b" value="5"></c:set>
<c:out value="2"></c:out>
<c:out value="${b }"></c:out>
<c:set var="dt" value="<%=new Date() %>"></c:set>
<c:out value="${dt }"></c:out>
</body>
</html>