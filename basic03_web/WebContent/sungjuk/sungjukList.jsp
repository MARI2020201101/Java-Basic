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
<title>sungjuk List Page</title>
</head>
<body>
<div class="container">
<br>
	<h1>*성적 목록*</h1>
	<br>
		<p><a href="sungjukForm.jsp">[성적쓰기]</a></p>
	<br>
	<table class="table table-hover">
		<thead class="table table-info"> 
			<tr>
				<th>이름</th>
				<th>국어</th>
				<th>영어</th>
				<th>수학</th>
				<th>평균</th>
				<th>등록일</th>
			</tr>
		</thead>
<tbody>
<%
try {
	//1) 오라클 DB관련정보
	String url ="jdbc:oracle:thin:@localhost:1521:xe";
	String user = "system";
	String password = "mari";
	String driver = "oracle.jdbc.driver.OracleDriver";
	
	//2) 드라이버 로딩
	Class.forName(driver);
	
	//3) 오라클 DB 서버 연결
	Connection con = DriverManager.getConnection(url,user,password);
	//out.print("connection : "+ con +"<br>");
	//out.print("DB 연결 성공!");
	
	//4) sql 작성(일단은 String으로)
	StringBuilder sql = new StringBuilder();
	sql.append("	SELECT sno, uname, kor, eng, mat, aver, addr, wdate ");
	sql.append("	FROM sungjuk ");
	sql.append("	ORDER BY wdate DESC");
	//5) 작성한 String을 sql으로 변환 
	PreparedStatement pstmt = con.prepareStatement(sql.toString());
	
	//6)sql실행
	ResultSet rs = pstmt.executeQuery();
	
	if(rs.next()){
		do{
%>
		<tr>
			<td><a href="sungjukRead.jsp?sno=<%=rs.getInt("sno") %>"><%=rs.getString("uname") %></a></td>
			<td><%=rs.getString("kor") %></td>
			<td><%=rs.getString("eng") %></td>
			<td><%=rs.getString("mat") %></td>
			<td><%=rs.getString("aver") %></td>
			<td><%=rs.getString("wdate").substring(0,10) %></td>
		</tr>
<%			
		}while(rs.next());
	}else{
		out.println("<script>");
		out.println("alert('출력목록 없음');");
		out.println("</script>");
	}
	
	
}catch(Exception e){
	out.print("오라클DB 연결실패 : "+ e);
}
%>
</tbody>
	</table>
</div>
</body>
</html>