package net.bbs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import net.utility.DBClose;
import net.utility.DBOpen;

public class BbsDAO {
	private DBOpen dbopen=null;
	private Connection con=null;
	private PreparedStatement pstmt =null;
	private ResultSet rs =null;
	
	public BbsDAO() {
		dbopen=new DBOpen();
	}
	
	public int insert(BbsDTO dto) {
		
		try {
			StringBuilder sb = new StringBuilder();
			sb.append(" INSERT INTO TB_BBS(bbsno, wname, subject, content, passwd,ip, grpno)");
			sb.append(" VALUES(sequence bbs_seq.nextval,");
			sb.append("?,?,?,?,?,(select nvl(max(bbsno),0)+1 from tb_bbs))");
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1,dto.getWname());
			pstmt.setString(2,dto.getSubject());
			pstmt.setString(3,dto.getContent());
			pstmt.setString(4,dto.getPasswd());
			pstmt.setString(5,dto.getIp());
			pstmt.setInt(6,dto.getGrpno());
			int cnt = pstmt.executeUpdate(sb.toString());
		}catch(Exception e) {
			System.out.println("BBS INSERT ERROR");
		}finally {
			DBClose.close(pstmt, con);
		}
		return cnt;
		
	}
}//class end
