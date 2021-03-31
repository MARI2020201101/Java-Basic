package jdbc0330;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test02_insert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	try {
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		String user = "system";
		String password = "mari";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Class.forName(driver);
		
		//오라클 DB연결값을 Connection 이라는 Object에 담기
		Connection con = DriverManager.getConnection(url,user,password);
		System.out.println("connection : "+ con);
		
		//4)SQL문 작성하기 (달라지는 부분) 
		//	주의사항 -> SQL종결문자 ;를 쓰면 오류남
		StringBuilder sql = new StringBuilder();
		sql.append(" INSERT INTO sungjuk(sno, uname, kor, mat, eng, addr, wdate) ");
		sql.append(" VALUES(sungjuk_seq.nextval, '김주아', 100,100,100,'Seoul',sysdate)");
		
		//5)SQL문 형식으로 변환 (이것은 string이 아닙니다. sql 입니다. )
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		
		//6)SQL문 실행
		int result = pstmt.executeUpdate();
		System.out.println("insert result :" + result);
		
	}catch(Exception e){
		System.out.println("오라클DB 연결실패 : "+ e);
	}
	}

}
