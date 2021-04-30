package net.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBOpen {

	public Connection getConnection() {
		
		Connection con=null;

		try {
			String url ="jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "mari";
			String driver = "oracle.jdbc.driver.OracleDriver";
			
			Class.forName(driver);

			con = DriverManager.getConnection(url,user,password);
		}catch(Exception e){
			System.out.println("����ŬDB ������� : "+ e);
		}
		
		return con;
	}//getConnection() end
}//class end
