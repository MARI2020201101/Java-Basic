package jdbc0330;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test05_insert {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
	try {
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		String user = "system";
		String password = "mari";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Class.forName(driver);
		
		con = DriverManager.getConnection(url,user,password);
		System.out.println("connection : "+ con);
		
		StringBuilder sql = new StringBuilder();
		sql.append(" INSERT INTO sungjuk(sno, uname, kor, mat, eng, addr, wdate) ");
		sql.append(" VALUES(sungjuk_seq.nextval, ?,?,?,?,?,sysdate)");
		pstmt = con.prepareStatement(sql.toString());
		
		pstmt.setString(1, "김미나");
		pstmt.setInt(2, 90);
		pstmt.setInt(3, 80);
		pstmt.setInt(4, 70);
		pstmt.setString(5, "Seoul");
		
		int result = pstmt.executeUpdate();
		if(result ==0) {
			System.out.println("insert 실패!");
		}else
		System.out.println("insert result :" + result);
		
	}catch(Exception e){
		System.out.println("오라클DB 연결실패 : "+ e);
	}finally {
		try {
			if(pstmt != null)
			pstmt.close();
			if(con != null)
			con.close();
		}catch(Exception e ) {
			System.out.println(e);
		}
	}
	}

}
