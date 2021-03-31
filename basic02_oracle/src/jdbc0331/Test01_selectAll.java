package jdbc0331;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test01_selectAll {
public static void main(String[] args) {
		
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
		
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT sno, uname, kor, eng, mat, tot, aver, addr, wdate FROM sungjuk");
		pstmt = con.prepareStatement(sql.toString());
		
		rs = pstmt.executeQuery();
		while(rs.next()) {
			System.out.printf("%d %s %d %d %d %d %d %s %s \n",
					rs.getInt(1),
					rs.getString(2),
					rs.getInt(3),
					rs.getInt(4),
					rs.getInt(5),
					rs.getInt(6),
					rs.getInt(7),
					rs.getString(8),
					rs.getString(9));
		
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
