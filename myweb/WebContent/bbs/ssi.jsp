<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- ssi : serverside interface
			공통 코드 모아놓는 페이지--%>
<%@ page import="java.io.*" %>    
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="net.utility.*" %>
<%@ page import="net.bbs.*" %>
<%@ page import="net.notice.*" %>
<%@ page import="net.member.*" %>
<%@ page import="net.pds.*" %>


<jsp:useBean id="dao" class="net.bbs.BbsDAO" scope="page"></jsp:useBean>
<jsp:useBean id="dto" class="net.bbs.BbsDTO" scope="page"></jsp:useBean>
<jsp:useBean id="noticeDao" class="net.notice.NoticeDAO" scope="page"></jsp:useBean>
<jsp:useBean id="noticeDto" class="net.notice.NoticeDTO" scope="page"></jsp:useBean>
<jsp:useBean id="memberDao" class="net.member.MemberDAO" scope="page"></jsp:useBean>
<jsp:useBean id="memberDto" class="net.member.MemberDTO" scope="page"></jsp:useBean>
<jsp:useBean id="pdsDao" class="net.pds.PdsDAO" scope="page"></jsp:useBean>
<jsp:useBean id="pdsDto" class="net.pds.PdsDTO" scope="page"></jsp:useBean>
<% request.setCharacterEncoding("UTF-8");%>

<%
	//검색-----------------------------------------------------------------
	String col =request.getParameter("col");
	String word =request.getParameter("word");
	col=Utility.checkNull(col);
	word=Utility.checkNull(word);
	
	//페이지네이션-----------------------------------------------------------
	//1) 현재페이지
	int nowPage=1;
	if(request.getParameter("nowPage")!=null) 
		nowPage=Integer.parseInt(request.getParameter("nowPage"));
	//2) 다음페이지
	
	
%>