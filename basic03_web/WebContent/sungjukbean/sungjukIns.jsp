<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="ssi.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Sungjuk Page</title>
</head>
<body>
<div class="container">
	<h1>*성적 결과 페이지*</h1>
<% 
	String uname = request.getParameter("uname").trim();
	int kor = Integer.parseInt(request.getParameter("kor"));
	int mat = Integer.parseInt(request.getParameter("mat"));
	int eng = Integer.parseInt(request.getParameter("eng"));
	String addr =request.getParameter("addr");
	int aver=(kor+mat+eng)/3;
	
	//1) dto객체를 사용하기 전 
	//int cnt=dao.insert(uname,kor,mat,eng,aver,addr);
	
	//2) dto객체를 사용한 경우( 추천 )
	dto.setUname(uname);
	dto.setKor(kor);
	dto.setMat(mat);
	dto.setEng(eng);
	dto.setAver(aver);
	dto.setAddr(addr);
	
	int cnt = dao.create(dto);
	if(cnt==0){
		out.print("<p>성적 입력을 실패하였습니다. </p><br>");
		out.print("<p><a href=\"javascript:history.back()\">[다시 시도하기]</a></p>");
	}else{
		out.println("<script>");
		out.println("alert(\"성적 입력 성공!\")");
		out.print("location.href='sungjukList.jsp'");
		out.println("</script>");
	}

%>
</div>
</body>
</html>