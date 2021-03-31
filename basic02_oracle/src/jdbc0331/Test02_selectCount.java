package jdbc0331;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test02_selectCount {

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
		sql.append(" SELECT COUNT(*) FROM sungjuk");
		pstmt = con.prepareStatement(sql.toString());
		
		rs = pstmt.executeQuery();
		if(rs.next()) {
			System.out.printf("전체 행의 개수 : %d 개 입니다\n",rs.getInt(1));
		
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
