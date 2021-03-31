package jdbc0330;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test03_update {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	try {
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		String user = "system";
		String password = "mari";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Class.forName(driver);
		
		Connection con = DriverManager.getConnection(url,user,password);
		
		StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE sungjuk");
		sql.append(" SET tot = (mat+kor+eng) , aver = (mat+kor+eng)/3 ");
		
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		
		int result = pstmt.executeUpdate();
		if(result ==0) {
			System.out.println("update failed...");
		}
		else System.out.println("update completed \n result :" + result);
		
		//자원반납하기
		pstmt.close();
		con.close();
	}catch(Exception e){
		System.out.println("오라클DB 연결실패 : "+ e);
	}
	}

}
