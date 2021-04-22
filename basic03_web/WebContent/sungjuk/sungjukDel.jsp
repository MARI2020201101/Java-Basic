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
<title>sungjuk Read page</title>
</head>
<br>
<div class="container">
<h1>*성적 데이터 삭제*</h1>
<br>
<p>
	<a href="sungjukForm.jsp">[성적쓰기]</a>
	<a href="sungjukList.jsp">[성적목록]</a>
</p>
	<br>
	
<%
	int sno = Integer.parseInt(request.getParameter("sno"));
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	try {
		//1) 오라클 DB관련정보
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		String user = "system";
		String password = "mari";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		//2) 드라이버 로딩
		Class.forName(driver);
		
		//3) 오라클 DB 서버 연결
		con = DriverManager.getConnection(url,user,password);
		//out.print("connection : "+ con +"<br>");
		//out.print("DB 연결 성공!");
		
		//4) sql 작성(일단은 String으로)
		StringBuilder sql = new StringBuilder();
		sql.append("	DELETE ");
		sql.append("	FROM sungjuk ");
		sql.append("	WHERE sno = ?");
		//5) 작성한 String을 sql으로 변환 
	
		pstmt = con.prepareStatement(sql.toString());
		
		//6)sql실행
		pstmt.setInt(1, sno);
		int cnt = pstmt.executeUpdate();
		
		if(cnt==0){
			
			out.println("<p>성적 삭제에 실패했습니다.</p>");
			out.println("<p><a href='javascript:history.back()'>[다시 시도하기]</a></p>");
			
			
		}else{
			out.println("<script>");
			out.println("alert('성적삭제 성공!');");
			out.println("location.href='sungjukList.jsp';");
			out.println("</script>");
		}
		
	}catch(Exception e){
		out.print("오라클DB 연결실패 : "+ e);
	}finally{
		try{
			if(rs!=null){
				rs.close();
				rs=null;
			}
		}catch(Exception e){
			
		}
		try{
			if(pstmt!=null){
				pstmt.close();
				pstmt=null;
			}
		}catch(Exception e){
			
		}
		try{
			if(con!=null){
				con.close();
				con=null;
			}
		}catch(Exception e){
			
		}
	}
%>
</div>
</body>
</html>