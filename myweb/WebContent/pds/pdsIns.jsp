<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.io.*" %>
<%@page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%@ include file="../bbs/ssi.jsp" %>

<!-- 본문 시작 -->
<div class ="container-2">
<h3>* 사진 업로드 결과 *</h3>
<br>
<%
try{
	String saveDirec = application.getRealPath("/storage");
	int maxPostSize=1024*1024*10;
	MultipartRequest mpr = new MultipartRequest(request
												,saveDirec
												,maxPostSize
												,"UTF-8"
												,new DefaultFileRenamePolicy());

	String wname = mpr.getParameter("wname");
	String subject = mpr.getParameter("subject");
	String passwd = mpr.getParameter("passwd");
	String filename="";
	long filesize=0;
	File file=null;
	Enumeration<?> fen = mpr.getFileNames();
	
	while(fen.hasMoreElements()){	
		String item = (String)fen.nextElement();
		filename =mpr.getFilesystemName(item);
		if(filename!=null){
			file= mpr.getFile(item);
		}if(file.exists()){
			filesize=file.length();
		}	
}
	if(filesize>(long)maxPostSize){
		out.print("<p>10MB이하의 사진만 업로드 가능합니다.</p>");
		out.print("<p><a href='javascript:history.back()'>[다시 시도하기]</a></p>");
		return;
	}
	
	pdsDto.setWname(wname);
	pdsDto.setSubject(subject);
	pdsDto.setPasswd(passwd);
	pdsDto.setFilename(filename);
	pdsDto.setFilesize(filesize);
	int cnt = pdsDao.insert(pdsDto);
	if(cnt==0){
		out.print("<p>사진 업로드 실패</p>");
		out.print("<p><a href='javascript:history.back()'>[다시 시도하기]</a></p>");
	}else{
		out.println("<script>");
		out.println("alert('사진 업로드 성공!')");
		out.print("location.href='pdsList.jsp'");
		out.println("</script>");
	}
	
	
}catch(Exception e){
	out.print("<p>사진 업로드 실패</p>");
	out.print("<p><a href='javascript:history.back()'>[다시 시도하기]</a></p>");
	
}
%>
</div>
<!-- 본문 끝 -->

<%@ include file="../footer.jsp" %>