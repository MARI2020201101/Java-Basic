<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- ssi : serverside interface
			공통 코드 모아놓는 페이지--%>
<%@ page import="java.io.*" %>    
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="net.utility.*" %>
<%@ page import="net.bbs.*" %>

<jsp:useBean id="dao" class="net.bbs.BbsDAO" scope="page"></jsp:useBean>
<jsp:useBean id="dto" class="net.bbs.BbsDTO" scope="page"></jsp:useBean>

<% request.setCharacterEncoding("UTF-8");%>