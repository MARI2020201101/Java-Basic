package jdbc0331;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test03_selectAvg {

	public static void main(String[] args) {
		
		//����) �ּҰ� ������ ����� ������ ��հ��� ���Ͻÿ�
		// ��, �Ҽ����� �ݿø��ؼ� ��°�ڸ�������
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
		sql.append(" SELECT ROUND(AVG(KOR),2),ROUND(AVG(ENG),2),ROUND(AVG(MAT),2) FROM sungjuk WHERE ADDR = ?");
		pstmt = con.prepareStatement(sql.toString());
		pstmt.setString(1,"Seoul" );
		rs = pstmt.executeQuery();
		if(rs.next()) {
			System.out.printf("��/��/�� ��� ��: %.2f/ %.2f/ %.2f �Դϴ�\n",rs.getDouble(1),rs.getDouble(2),rs.getDouble(3));
				}
	}catch(Exception e){
		System.out.println("����ŬDB ������� : "+ e);
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
