package net.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBOpen {

	public Connection getConnection() {
		
		Connection con=null;

		try {
			
			String url      = "jdbc:mysql://localhost/mari20201101";
		    String user     = "mari20201101";
		    String password = "GOO@mari2020";
		    String driver   = "org.gjt.mm.mysql.Driver";   
			Class.forName(driver);

			con = DriverManager.getConnection(url,user,password);
		}catch(Exception e){
			System.out.println("DB CONNECTION ERROR : "+ e);
		}
		
		return con;
	}//getConnection() end
}//class end
