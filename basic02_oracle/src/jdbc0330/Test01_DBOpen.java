package jdbc0330;

import java.sql.Connection;
import java.sql.DriverManager;

public class Test01_DBOpen {

	/*
	 * JDBC (Java Database Connection)
	 * ����Ʈ��� �ϵ����� �Ȱ���. ��ǻ�Ͷ� �����ͱ� �����ϱ����� ����̹��� �ʿ��ϵ���
	 * �ڹٿ� ����Ŭ ���̿� �����͸� �Դٰ��� �� �� �ֵ��� Ư���� ���� �վ��־�� ��
	 * �� ���� �ٷ� ����̹�!~!!!
	 * 
	 * ����Ŭ�� ��� ���� ��ġ�ϸ� jdbc��� �����ȿ� ����̹��� ���� �������ְ� �ִ�. 
	 * Ȥ�� �ش� ����Ʈ������ �ٿ�ε� ����
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			/*
			 * Oracle DB���� ���� ���
			 *  - �ý��� ���� IP���� (url)        	-> ���������� 
			 *  - �ڽ��� �ý����� ����Ű�� IP ���� 		-> 127.0.0.1
			 *  - �ڽ��� �ý����� ����Ű�� �̸����� ���� 	-> localhost
			 */
			//1) ����Ŭ DB��������
			String url ="jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "mari";
			String driver = "oracle.jdbc.driver.OracleDriver";
			
			//2) ����̹� �ε�
			Class.forName(driver);
			
			//3) ����Ŭ DB ���� ����
			Connection con = DriverManager.getConnection(url,user,password);
			System.out.println("connection : "+ con);
			
		}catch(Exception e){
			System.out.println("����ŬDB ������� : "+ e);
		}
	}

}
