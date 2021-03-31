package jdbc0331;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test04_selectLike {

	public static void main(String[] args) {
		
		//����) �̸��� '��'���ڰ� �ִ� ���� ��ȸ�Ͻÿ�
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
		
		String col = "uname";
		String word = "��";
		StringBuilder sql = new StringBuilder();
		
		sql.append(" SELECT sno FROM sungjuk ");
		if(word.length()>0) {
			String where="";
			where += " WHERE ";
			where += col;
			where += " LIKE ";
			where += " '%";
			where += word;
			where += " %'";
			
			System.out.println(where);
		}
		pstmt = con.prepareStatement(sql.toString());
		pstmt.setString(1, uname);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getString("KOR"));
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
