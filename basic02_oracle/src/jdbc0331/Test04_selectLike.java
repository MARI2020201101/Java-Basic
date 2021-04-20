package jdbc0331;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test04_selectLike {

	public static void main(String[] args) {
		
		//문제) 이름에 '나'문자가 있는 행을 조회하시오
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	try {
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		String user = "system";
		String password = "mari";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Class.forName(driver);
		
		con = DriverManager.getConnection(url,user,password);
		System.out.println("connection : "+ con);
		
		String col = "uname";//조건
		String word = "나"; //키워드
		StringBuilder sql = new StringBuilder();
		String where="";
		sql.append(" SELECT sno,uname,kor,mat,eng,tot,aver,addr,wdate FROM sungjuk ");
		if(word.length()>0) {
			
			where += " WHERE ";
			where += col;
			where += " LIKE ";
			where += " '%";
			where += word;
			where += "%'";
			
			System.out.println(where);
		}
		pstmt = con.prepareStatement(sql.toString()+where);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			System.out.print(rs.getInt("sno") +" ");
			System.out.print(rs.getString("uname") +" ");
			System.out.print(rs.getInt("kor") +" ");
			System.out.print(rs.getInt("mat") +" ");
			System.out.print(rs.getInt("eng") +" ");
			System.out.print(rs.getInt("tot") +" ");
			System.out.print(rs.getInt("aver") +" ");
			System.out.print(rs.getString("addr") +" ");
			System.out.print(rs.getString("wdate") +" ");
			System.out.println();
			
				}
	}catch(Exception e){
		System.out.println("오라클DB 연결실패 : "+ e);
	}finally {
		try {
			if(pstmt != null)
			pstmt.close();
			if(con != null)
			con.close();
			if(rs != null)
				rs.close();
		}catch(Exception e ) {
			System.out.println(e);
		}
	}

	}

}
