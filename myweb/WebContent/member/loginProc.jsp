<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../bbs/ssi.jsp" %>
<%@ include file="../header.jsp" %>
<%@ include file="auth.jsp" %>
<%

String id =request.getParameter("id");
String passwd= request.getParameter("passwd");
memberDto.setId(id);
memberDto.setPasswd(passwd);
String mlevel=memberDao.loginProc(memberDto);

if(mlevel.equals("")||mlevel==null){
	out.print("<script>");
	out.print("alert('비밀번호와 패스워드가 일치하지 않습니다.');");
	out.print("history.back();");
	out.print("</script>");
}
else{
	session.setAttribute("s_id", id);
	session.setAttribute("s_passwd", passwd);
	session.setAttribute("s_mlevel", mlevel);
	String c_id=Utility.checkNull(request.getParameter("c_id"));
	Cookie cookie=null;
	if(c_id.equals("SAVE")){
		cookie=new Cookie("c_id",id);
		cookie.setMaxAge(60*60*24*30);
		
	}else{
		cookie=new Cookie("c_id","");
		cookie.setMaxAge(0);
	}
	response.addCookie(cookie);
	String root=Utility.getRoot();
	response.sendRedirect(root+"/index.jsp");
}

%>

