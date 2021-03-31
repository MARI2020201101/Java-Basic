package jdbc0330;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test04_delete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection con = null;
		PreparedStatement pstmt = null;
	try {
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		String user = "system";
		String password = "mari";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Class.forName(driver);
		
		con = DriverManager.getConnection(url,user,password);
		
		StringBuilder sql = new StringBuilder();
		sql.append(" DELETE sungjuk");
		sql.append(" WHERE uname ='김주아' ");
		
		pstmt = con.prepareStatement(sql.toString());
		
		int result = pstmt.executeUpdate();
		if(result ==0) {
			System.out.println("delete failed...");
		}
		else System.out.println("delete completed \n result :" + result);
		
	
	}catch(Exception e){
		System.out.println("오라클DB 연결실패 : "+ e);
	}finally {
		
		try {
			if(pstmt!= null) {
				pstmt.close();
			}
			if(con!= null) {
				con.close();
			}
			// 실패하면 null값되므로 꼭 if처리해주기.. 안그러면 없는걸 닫을라고 해서 익셉션남
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	}

}
