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
<style>
	.table-info{width:230px;}
	td{text-align:center; }
</style>
</head>
<br>
<div class="container">
<h1>*성적 상세보기*</h1>
<br>
<p>
	<a href="sungjukForm.jsp">[성적쓰기]</a>
	<a href="sungjukList.jsp">[성적목록]</a>
</p>
	<br>
	
<%
int sno = Integer.parseInt(request.getParameter("sno"));
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
	sql.append("	WHERE sno = ?");
	//5) 작성한 String을 sql으로 변환 

	PreparedStatement pstmt = con.prepareStatement(sql.toString());
	
	//6)sql실행
	pstmt.setInt(1, sno);
	ResultSet rs = pstmt.executeQuery();
	if(rs.next()){
%>
<table class="table table-hover">
			<tr>
				<th class="table-info">이름</th>
				<td><%=rs.getString("uname") %></td>
			</tr>
			<tr>
				<th class="table-info">국어</th>
				<td><%=rs.getString("kor") %></td>
			</tr>
			<tr>
				<th class="table-info">영어</th>
				<td><%=rs.getString("eng") %></td>
			</tr>
			<tr>
				<th class="table-info">수학</th>
				<td><%=rs.getString("mat") %></td>
			</tr>
			<tr>
				<th class="table-info">평균</th>
				<td><%=rs.getString("aver") %></td>
			</tr>
<%
			String addr= rs.getString("addr");
			if(addr.equals("Seoul")){
				addr = "서울";
			}else if(addr.equals("Jeju")){
				addr = "제주";
			}else if(addr.equals("Busan")){
				addr = "부산";
			}else{
				addr = "수원";
			}

%>
			<tr>
				<th class="table-info">주소</th>
				<td><%=addr %></td>		
			</tr>
			<tr>
				<th class="table-info">등록일</th>
				<td><%=rs.getString("wdate").substring(0,10) %></td>
			</tr>

	</table>
	<br><br>
	<a href="sungjukUpdate.jsp?sno=<%=sno%>">[수정하기]</a>
	<a href="sungjukDel.jsp?sno=<%=sno %>">[삭제하기]</a>
<%			
		
		
	}else{
		out.println("<script>");
		out.println("alert('출력목록 없음');");
		out.println("</script>");
			
	}
	
}catch(Exception e){
	out.print("오라클DB 연결실패 : "+ e);
}
%>
</div>
</body>
</html>