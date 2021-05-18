package net.bbs2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import net.bbs.BbsDTO;
import net.member.MemberDTO;
import net.utility.DBClose;
import net.utility.DBOpen;

public class BoardDBBean {
	private DBOpen dbopen=null;
	private Connection con=null;
	private PreparedStatement pstmt =null;
	private ResultSet rs =null;
	StringBuilder sb = new StringBuilder();
	
	public BoardDBBean() {
		dbopen=new DBOpen();
	}
	
	public void insertArticle(BoardDataBean bean) throws Exception{
		int num = bean.getNum();
		int ref = bean.getRef();
		int re_step = bean.getRe_step();
		int re_level = bean.getRe_level();
		int number=0;
		
		try {
			con=dbopen.getConnection();
			sb.append(" SELECT MAX(num) FROM BOARD");
			pstmt = con.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				number = rs.getInt(1)+1;
			}else {
				number = 1;
			}
			
			sb.delete(0, sb.length());
			if(num!=0) {
				sb.append("UPDATE BOARD SET re_step = re_step+1 WHERE ref=? AND re_step>?");
				pstmt = con.prepareStatement(sb.toString());
				pstmt.setInt(1, ref);
				pstmt.setInt(2, re_step);
				pstmt.executeUpdate();
				re_step = re_step +1;
				re_level = re_level +1;
			}else {
				ref=number;
				re_step=0;
				re_level=0;
			}
			sb.delete(0, sb.length());
			sb.append("INSERT INTO BOARD(num, writer, email, subject, passwd, reg_date, ref, re_step, re_level, content , ip)");
			sb.append("VALUES ((select nvl(max(num),0)+1 from board), ?, ?, ?, ?, ?, ?, ?, ?, ? , ?)");
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, bean.getWriter());
			pstmt.setString(2, bean.getEmail());
			pstmt.setString(3, bean.getSubject());
			pstmt.setString(4, bean.getPasswd());
			pstmt.setTimestamp(5, bean.getReg_date());
			pstmt.setInt(6, ref);
			pstmt.setInt(7, re_step);
			pstmt.setInt(8, re_level);
			pstmt.setString(9, bean.getContent());
			pstmt.setString(10, bean.getIp());
			pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("BBS INSERT ERROR : "+e);
		}finally {
			DBClose.close(rs, pstmt, con);
		}
		
	}
	
}
