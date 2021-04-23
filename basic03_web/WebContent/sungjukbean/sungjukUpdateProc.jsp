<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="ssi.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sungjukUpdate process</title>
</head>
<body>
<%
	
	int kor = Integer.parseInt(request.getParameter("kor").trim());
	int mat = Integer.parseInt(request.getParameter("mat").trim());
	int eng = Integer.parseInt(request.getParameter("eng").trim());
	int aver=(kor+mat+eng)/3;
	
	dto.setSno(Integer.parseInt(request.getParameter("sno")));
	dto.setUname(request.getParameter("uname").trim());
	dto.setKor(kor);
	dto.setMat(mat);
	dto.setEng(eng);
	dto.setAver(aver);
	dto.setAddr(request.getParameter("addr").trim());
	
	int cnt = dao.update(dto);
	
	if(cnt==0){
		out.println("<p>성적 수정에 실패했습니다.</p>");
		out.println("<p><a href='javascript:history.back()'>[다시 시도하기]</a></p>");
	}else{
		out.println("<script>");
		out.println("alert('성적수정 성공!');");
		out.println("location.href='sungjukList.jsp';");
		out.println("</script>");
	}
%>
</body>
</html>