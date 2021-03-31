package jdbc0330;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test07_select {

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
		sql.append(" WHERE sno = ?");
		pstmt = con.prepareStatement(sql.toString());
		
		pstmt.setInt(1, 22);
		
		rs = pstmt.executeQuery();
		if(rs.next()) {
			System.out.println(rs.getString(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getString(4));
			System.out.println(rs.getString(5));
			System.out.println(rs.getString(6));
			System.out.println(rs.getString(7));
			System.out.println(rs.getString(8));
			System.out.println(rs.getString(9));
			
		}else {
			System.out.println("데이터 없음! ");
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
