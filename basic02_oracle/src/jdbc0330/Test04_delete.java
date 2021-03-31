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
		sql.append(" WHERE uname ='���־�' ");
		
		pstmt = con.prepareStatement(sql.toString());
		
		int result = pstmt.executeUpdate();
		if(result ==0) {
			System.out.println("delete failed...");
		}
		else System.out.println("delete completed \n result :" + result);
		
	
	}catch(Exception e){
		System.out.println("����ŬDB ������� : "+ e);
	}finally {
		
		try {
			if(pstmt!= null) {
				pstmt.close();
			}
			if(con!= null) {
				con.close();
			}
			// �����ϸ� null���ǹǷ� �� ifó�����ֱ�.. �ȱ׷��� ���°� ������� �ؼ� �ͼ��ǳ�
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	}

}
