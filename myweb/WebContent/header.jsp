<%@page import="net.utility.Utility"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <title>MyWeb</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
 
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
  <!-- 사용자정의 CSS + javascript -->
  <!-- 주의사항 : CSS와 JS는 각 웹 브라우저에서 쿠키삭제하고 확인할 것. -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/layout.css">
  <script src="<%=request.getContextPath()%>/js/myscript.js"></script>
</head>
<body>

<!-- Navar 메인카테고리-->
<nav class="navbar navbar-default">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="<%=request.getContextPath()%>/index.jsp">HOME</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="<%=request.getContextPath()%>/bbs/bbsList.jsp">게시판</a></li>
        <li><a href="<%=request.getContextPath()%>/notice/noticeList.jsp">공지사항</a></li>
      
        <li><a href="<%=request.getContextPath()%>/member/loginForm.jsp">로그인</a></li>
        <li><a href="<%=request.getContextPath()%>/pds/pdsList.jsp">포토갤러리</a></li>
        <li><a href="<%=request.getContextPath()%>/mail/mailForm.jsp">메일보내기</a></li>
        <li><a href="<%=request.getContextPath()%>/bbs2/bbsList.do">MVC게시판</a></li>
        <li><a href="<%=request.getContextPath()%>/member2/loginForm.do">MVC로그인</a></li>
      </ul>
    </div>
  </div>
</nav><!--Navbar End 메인카테고리 끝-->


<!--콘텐츠 시작-->
<div class="container-2 bg-3 text-center">
	<div class="row">
	