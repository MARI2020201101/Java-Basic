<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTLTest2</title>
</head>
<body>
<h3>* JSTL 제어문 연습 *</h3>
<form action="jstlTest2ok.jsp" method="post">
<input type="text" name="name">
<input type="text" name="age">

<input type="submit" value="submit">
</form>

</body>
</html>