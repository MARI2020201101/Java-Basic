<%@page import="javax.mail.Transport"%>
<%@page import="java.util.Date"%>
<%@page import="javax.mail.internet.MimeMessage"%>
<%@page import="javax.mail.Message"%>
<%@page import="javax.mail.internet.InternetAddress"%>
<%@page import="javax.mail.Session"%>
<%@page import="javax.mail.Authenticator"%>
<%@page import="java.util.Properties"%>
<%@page import="net.utility.MyAuthenticator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<!-- 본문 시작 -->
<div class="container-2">
<h3>* 메일 보내기 결과 *</h3>
<br>
<%
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
		//out.print("메일서버 인증 성공!");
		
		//4) 메일 전송하기
		request.setCharacterEncoding("UTF-8");
		String to = request.getParameter("to").trim();
		String from = request.getParameter("from").trim();
		String subject = request.getParameter("subject").trim();
		String content = request.getParameter("content").trim();

		//5) 엔터 및 특수문자 변경
		content=Utility.convertChar(content);
		
		content += "<hr>";
		content += "<table border='1'>";
		content += "<tr>";
		content += "<th>상품명</th>";
		content += "<th>상품가격</th>";
		content += "</tr>";
		content += "<tr>";
		content += "<td>운동화</td>";
		content += "<td><span style='color:red;font-weight:bold;'>15,000원</span>";
		content += "</tr>";
		content += "</table>";
		//이미지 보여주기?
		content += "<img src='http://localhost:8081/myweb/images/devil.png'>";
		
		//받는사람 이메일 주소
		InternetAddress[] address={new InternetAddress(to)};
		/*
			수신인이 여러명일때
			InternetAddress[] address={new InternetAddress(to1),
										new InternetAddress(to2),
										new InternetAddress(to3)};
		*/
		
		//메일 관련 정보 작성
		Message msg =new MimeMessage(sess);
		
		//받는 사람
		msg.setRecipients(Message.RecipientType.TO, address);
		//참조 Message.RecipientType.CC
		//숨은참조 Message.RecipientType.BCC
		
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
		out.print(to +" 님에게 메일이 전송되었습니다.");
		
	}catch(Exception e){
	out.print("<p>메일 전송에 실패하였습니다.</p>");
	out.println("<p><a href='javascript:history.back()'>[다시 시도하기]</a></p>");

}
%>
</div>
<!-- 본문 끝 -->

<%@ include file="../footer.jsp" %>