<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Insert sungjuk page</title>
</head>
<body>
<div class="container">
	<h1>*성적 결과 페이지*</h1>
<% 
	//한글 인코딩
	request.setCharacterEncoding("UTF-8");

	//입력정보 가져와서 변수에 저장
	String uname = request.getParameter("uname").trim();
	int kor = Integer.parseInt(request.getParameter("kor"));
	int mat = Integer.parseInt(request.getParameter("mat"));
	int eng = Integer.parseInt(request.getParameter("eng"));
	String addr =request.getParameter("addr");
	
	//평균구하기
	int aver=(kor+mat+eng)/3;
	
	//request한 사용자의 ip주소 출력
	out.print("요청 IP :"+request.getRemoteAddr()+"<br>");
	
	try {
		/*
		 * Oracle DB서버 접근 방법
		 *  - 시스템 전용 IP접근 (url)        	-> 고정아이피 
		 *  - 자신의 시스템을 가리키는 IP 접근 		-> 127.0.0.1
		 *  - 자신의 시스템을 가리키는 이름으로 접근 	-> localhost
		 */
		//1) 오라클 DB관련정보
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		String user = "system";
		String password = "mari";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		//2) 드라이버 로딩
		Class.forName(driver);
		
		//3) 오라클 DB 서버 연결
		Connection con = DriverManager.getConnection(url,user,password);
		out.print("connection : "+ con +"<br>");
		out.print("DB 연결 성공!");
		
		//4) sql 작성(일단은 String으로)
		StringBuilder sql = new StringBuilder();
		sql.append(" INSERT INTO sungjuk(sno, uname, kor, mat, eng, aver, addr, wdate) ");
		sql.append(" VALUES(sungjuk_seq.nextval,?,?,?,?,?,?,sysdate)");
		
		//5) 작성한 String을 sql으로 변환 
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		pstmt.setString(1, uname);
		pstmt.setInt(2, kor);
		pstmt.setInt(3, mat);
		pstmt.setInt(4, eng);
		pstmt.setInt(5, aver);
		pstmt.setString(6, addr);
		
		//6)sql실행
		int cnt = pstmt.executeUpdate();
		
		if(cnt==0){
			out.print("<p>성적 입력을 실패하였습니다. </p><br>");
			out.print("<p><a href=\"javascript:history.back()\">[다시 시도하기]</a></p>");
		}else{
			out.println("<script>");
			out.println("alert(\"성적 입력 성공!\")");
			out.print("location.href='sungjukList.jsp'");
			out.println("</script>");
		}
		
	}catch(Exception e){
		out.print("오라클DB 연결실패 : "+ e);
	}
%>
</div>
</body>
</html>