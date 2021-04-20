package jdbc0331;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test05_selectQuiz {

	public static void main(String[] args) {
		
		//문제) 학번 g1001이 수강신청한 과목을 과목코드별로 조회하시오
		/*
		 * select su.hakno hakno, su.gcode gcode, g.gname gname 
		 * from tb_sugang su join tb_student st on
		 * su.hakno = st.hakno join tb_gwamok g on 
		 * su.gcode = g.gcode 
		 * where st.hakno =
		 * 'g1001';
		 */
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
	
		sql.append(" SELECT su.hakno, su.gcode, g.gname ");
		sql.append(" FROM tb_sugang su JOIN tb_student st ON ");
		sql.append(" su.hakno = st.hakno JOIN tb_gwamok g ON ");
		sql.append(" su.gcode = g.gcode ");
		sql.append(" WHERE su.hakno = ?");

		
		pstmt = con.prepareStatement(sql.toString());
		pstmt.setString(1, "g1001");
		
		rs = pstmt.executeQuery();
		if(rs.next()) {
			System.out.print(rs.getString("hakno") +" ");
			System.out.print(rs.getString("gcode") +" ");
			System.out.print(rs.getString("gname") +" ");
			System.out.println();
			
				}
	}catch(Exception e){
		System.out.println("오라클DB 연결실패 : "+ e);
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
