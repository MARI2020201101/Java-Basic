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
<title>Sungjuk Update Page</title>
<style>
	.table-info{width:230px;}

	input{ width:200px;
			border: 1px solid lightgray;}
	input.btn{width:100px;}
</style>
</head>
<br>
<div class="container">
<h1>*성적 데이터 수정*</h1>
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
		sql.append("	SELECT sno, uname, kor, eng, mat, aver, addr, wdate ");
		sql.append("	FROM sungjuk ");
		sql.append("	WHERE sno = ?");
		//5) 작성한 String을 sql으로 변환 
	
		pstmt = con.prepareStatement(sql.toString());
		
		//6)sql실행
		pstmt.setInt(1, sno);
		rs = pstmt.executeQuery();
		
		if(rs.next()){
%>
	<form method="post" action="sungjukUpdateProc.jsp">
		<input type="hidden" name="sno" value="<%=sno %>">
		<table class="table table-hover table-bordered align-middle">
		<tr>
		  <th class="table-info">이름</th>
		  <td><input type="text" name="uname" maxlength="20" required autofocus value="<%=rs.getString("uname") %>"></td>
		</tr> 
		<tr>
		  <th class="table-info">국어</th>
		  <td><input type="number" name="kor" size="5" min="0" max="100" placeholder="숫자입력" value="<%=rs.getString("kor") %>"></td>
		</tr> 
		<tr>
		  <th class="table-info">영어</th>
		  <td><input type="number" name="eng" size="5" min="0" max="100" placeholder="숫자입력" value="<%=rs.getString("eng") %>"></td>
		</tr> 
		<tr>
		  <th class="table-info">수학</th>
		  <td><input type="number" name="mat" size="5" min="0" max="100" placeholder="숫자입력" value="<%=rs.getString("mat") %>"></td>	
		</tr> 
		<tr>
		  <th class="table-info">주소</th>
		  <td>
		  	<%String addr= rs.getString("addr"); %>
		      <select name="addr">
		            <option value="Seoul" <%if(addr.equals("Seoul")){out.println("selected");} %>>서울</option>
		            <option value="Jeju" <%if(addr.equals("Jeju")){out.println("selected");} %>>제주</option>
		            <option value="Suwon" <%if(addr.equals("Suwon")){out.println("selected");} %>>수원</option>
		            <option value="Busan" <%if(addr.equals("Busan")){out.println("selected");} %>>부산</option>
		      </select> 
		  </td>
		</tr> 
		<tr>
		  <td colspan="2" align="center">
		     <input class="btn btn-primary" type="submit" value="수정">
		     <input class="btn btn-primary" type="reset"  value="취소">
		  </td>
		</tr>
		</table>
	</form>
<% 
		}else{
			out.println("해당 글 없음");
		}
	}catch(Exception e){
		out.print("오라클DB 연결실패 : "+ e);
	}finally{
		try{if(rs!=null){rs.close();rs=null;}
		}catch(Exception e){}
		try{if(pstmt!=null){pstmt.close();pstmt=null;}
		}catch(Exception e){}
		try{if(con!=null){con.close();con=null;}
		}catch(Exception e){}
	}
%>
</div>
</body>
</html>