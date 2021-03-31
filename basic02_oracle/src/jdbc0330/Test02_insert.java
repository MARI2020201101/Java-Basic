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
		
		//����Ŭ DB���ᰪ�� Connection �̶�� Object�� ���
		Connection con = DriverManager.getConnection(url,user,password);
		System.out.println("connection : "+ con);
		
		//4)SQL�� �ۼ��ϱ� (�޶����� �κ�) 
		//	���ǻ��� -> SQL���Ṯ�� ;�� ���� ������
		StringBuilder sql = new StringBuilder();
		sql.append(" INSERT INTO sungjuk(sno, uname, kor, mat, eng, addr, wdate) ");
		sql.append(" VALUES(sungjuk_seq.nextval, '���־�', 100,100,100,'Seoul',sysdate)");
		
		//5)SQL�� �������� ��ȯ (�̰��� string�� �ƴմϴ�. sql �Դϴ�. )
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		
		//6)SQL�� ����
		int result = pstmt.executeUpdate();
		System.out.println("insert result :" + result);
		
	}catch(Exception e){
		System.out.println("����ŬDB ������� : "+ e);
	}
	}

}
