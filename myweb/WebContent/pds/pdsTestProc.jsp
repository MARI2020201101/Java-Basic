<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.io.*" %>
<%@page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<!-- 본문 시작 -->
<div class="container-2">
<h3>* 파일첨부 테스트 결과*</h3>
<br>
<%
/* 	request.setCharacterEncoding("UTF-8");
	String unmae = request.getParameter("uname");
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	String filenm = request.getParameter("filenm");
	
	out.print(unmae);
	out.print("<br>");
	out.print(subject);
	out.print("<br>");
	out.print(content);
	out.print("<br>");
	out.print(filenm);
	out.print("<br>"); 
	
	request.getParameter 는 무조건 String으로 받기 때문에
	온전히 filedata를 받아올수없음. 
	enctype=multipart / formdata로 하니까
	null반환 하더라!
	
	유저가 파일을 서버로 보낸다 
	
	고려사항) 파일 이름- 중복되면 안됨. 덮어쓰기되므로(FileRenamePolicy 이용)
	-> 파일을 서버 스토리지에 저장한다 (나는 일단 storage폴더, cos.jar이용)
	-> storage폴더에 저장되어 있는 파일에 대한 정보 확인하기
	
	*/
try{
	String saveDirec = application.getRealPath("/storage");
	int maxPostSize=1024*1024*10;
	MultipartRequest mpr = new MultipartRequest(request
												,saveDirec
												,maxPostSize
												,"UTF-8"
												,new DefaultFileRenamePolicy());
	
	Enumeration<?> en = mpr.getParameterNames();
	Enumeration<?> fen = mpr.getFileNames();
	
	while(en.hasMoreElements()){
		String name = (String)en.nextElement();
		out.print(name +" : "+ mpr.getParameter(name));
		out.print("<hr>");
	}

	while(fen.hasMoreElements()){	
			String name = (String)fen.nextElement();
			File file = mpr.getFile(name);	
			out.print("FileName : "+ mpr.getFilesystemName(name));
			out.print("<br>");
			out.print("OriginalFileName : "+mpr.getOriginalFileName(name));
			out.print("<br>");
			out.print("ContentType : " + mpr.getContentType(name));
			out.print("<br>");
			out.print("파일 용량 : " + (file.length()/1000.0) + "(KB)");
			out.print("<br>");
			out.print("<hr>");
	}
	out.print("<p>첨부된 파일 저장 성공!!</p>");
	
}catch(Exception e){
	out.print("<p>파일 업로드 실패</p>");
	out.print("<p><a href='javascript:history.back()'>[다시 시도하기]</a></p>");
	
}
%>
</div>
<!-- 본문 끝 -->

<%@ include file="../footer.jsp" %>