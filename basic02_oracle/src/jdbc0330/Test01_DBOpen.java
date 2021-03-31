package jdbc0330;

import java.sql.Connection;
import java.sql.DriverManager;

public class Test01_DBOpen {

	/*
	 * JDBC (Java Database Connection)
	 * 소프트웨어도 하드웨어랑 똑같음. 컴퓨터랑 프린터기 연결하기위해 드라이버가 필요하듯이
	 * 자바와 오라클 사이에 데이터를 왔다갔다 할 수 있도록 특정한 길을 뚫어주어야 함
	 * 그 길이 바로 드라이버!~!!!
	 * 
	 * 오라클의 경우 서버 설치하면 jdbc라는 폴더안에 드라이버도 같이 제공해주고 있다. 
	 * 혹은 해당 사이트에서도 다운로드 가능
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			/*
			 * Oracle DB서버 접근 방법
			 *  - 시스템 전용 IP접근 (url)        	-> 고정아이피 
			 *  - 자신의 시스템을 가리키는 IP 접근 		-> 127.0.0.1
			 *  - 자신의 시스템을 가리키는 이름으로 접근 	-> localhost
			 */
			//1) 오라클 DB관련정보
			String url ="jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "mari";
			String driver = "oracle.jdbc.driver.OracleDriver";
			
			//2) 드라이버 로딩
			Class.forName(driver);
			
			//3) 오라클 DB 서버 연결
			Connection con = DriverManager.getConnection(url,user,password);
			System.out.println("connection : "+ con);
			
		}catch(Exception e){
			System.out.println("오라클DB 연결실패 : "+ e);
		}
	}

}
