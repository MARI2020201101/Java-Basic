<%@page import="java.util.stream.Collectors"%>
<%@page import="java.util.Date"%>
<%@page import="javax.mail.internet.MimeMessage"%>
<%@page import="javax.mail.internet.InternetAddress"%>
<%@page import="javax.mail.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%@ include file="../bbs/ssi.jsp" %>

<!-- 본문 시작 -->
<div class="container-2">
<h3>* 임시 비밀번호 발급 결과 *</h3>
<br>
<%
String mname = request.getParameter("mname");
String email = request.getParameter("email");

//임시비밀번호 알고리즘 필요. 

List<String> ranPw = Arrays.asList("0", "1","2","3","4","5","6","7","8","9",
		"A","B","C","D","E","F", "G","H", "I", "J","K", "L", "M","N", "O", "P",
		"Q", "R", "S", "T","U", "V", "W", "X", "Y", "Z","a", "b" , "c", "d", "e",
		"f", "g", "h", "i", "j", "k","l","m", "n", "o", "p", "q", "r", "s", "t",
		"u", "v", "w", "x", "y", "z", "!", "@", "#", "$", "%", "^", "&", "*");
Collections.shuffle(ranPw);
String tempPw =ranPw.stream().limit(5).collect(Collectors.joining());
memberDto.setMname(mname);
memberDto.setEmail(email);
memberDto.setPasswd(tempPw);

String tempId = memberDao.findPasswd(memberDto);
if(tempId==null||tempId==""){
	out.print("<p>일치하는 아이디와 이메일이 없습니다.</p>");
	out.println("<p><a href='javascript:history.back()'>[다시 시도하기]</a></p>");
}else{ 
	try{
		//1) 메일서버(POP3/SMTP)가져오기- resource의 위치 uri로
		String mailServer="mw-002.cafe24.com";
		Properties props = new Properties();
		props.put("mail.smtp.host",mailServer);
		props.put("mail.smtp.auth", "true");
		
		//2) 메일서버에서 인증받은 계정+비번. 으로 로그인
		Authenticator myAuth=new MyAuthenticator();
		
		//3) 1)과 2)가 유효한지 검증
		Session sess=Session.getInstance(props, myAuth);
		
		//4) 메일 전송하기		
		String to = email;
		String from = "tempPw@myweb.com";
		String subject ="임시 비밀번호 발급 메일";
		String content = "";
		content +="<strong>아이디 : </strong>"+tempId;
		content += "<br>";
		content +="<strong>임시 비밀번호 : </strong>"+tempPw;
		content +="<p>임시 비밀번호로 재 로그인 후 회원정보를 수정해주십시요.</p>";
		//받는사람 이메일 주소
		InternetAddress[] address={new InternetAddress(to)};
		
		//메일 관련 정보 작성
		Message msg =new MimeMessage(sess);
		
		//받는 사람
		msg.setRecipients(Message.RecipientType.TO, address);
		
		//보내는 사람
		msg.setFrom(new InternetAddress(from));
		
		//메일 제목
		msg.setSubject(subject);
		
		//메일 내용
		msg.setContent(content,"text/html; charset=UTF-8");
		
		//보낸 날짜
		msg.setSentDate(new Date());
		
		//메일 전송
		Transport.send(msg);
		
	}catch(Exception e){
	}
 
	out.print("<p><strong>"+ mname + "</strong> 님에게 임시 비밀번호를 이메일로 발송하였습니다.</p>");
	out.println("<p><a href='loginForm.jsp'>[로그인 화면으로 가기]</a></p>");
} 

%>
</div>
<!-- 본문 끝 -->

<%@ include file="../footer.jsp" %>