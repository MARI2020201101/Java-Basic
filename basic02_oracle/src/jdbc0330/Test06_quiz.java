package jdbc0330;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test06_quiz {

	public static void main(String[] args) {
		
		int sno =22;
		String uname = "박지성";
		int kor = 90, eng = 80, mat = 100;
		int tot = (kor+ eng + mat);
		int aver = tot/3;
		String addr = "Suwon";
		
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
		sql.append(" UPDATE sungjuk SET UNAME = ?, KOR = ?, MAT = ?, ENG = ? , TOT= ?, AVER=? ,ADDR = ?");
		sql.append(" WHERE SNO = ?");
		pstmt = con.prepareStatement(sql.toString());
		
		pstmt.setString(1, uname);
		pstmt.setInt(2, kor);
		pstmt.setInt(3, mat);
		pstmt.setInt(4, eng);
		pstmt.setInt(5, tot);
		pstmt.setInt(6, aver);
		pstmt.setString(7, addr);
		pstmt.setInt(8, sno);
		
		int result = pstmt.executeUpdate();
		if(result ==0) {
			System.out.println("UPDATE 실패!");
		}else
		System.out.println("UPDATE result :" + result);
		
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
