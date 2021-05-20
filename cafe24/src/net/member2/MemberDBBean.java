package net.member2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import net.member.MemberDTO;
import net.utility.DBClose;
import net.utility.DBOpen;

public class MemberDBBean {
	private DBOpen dbopen=null;
	private Connection con=null;
	private PreparedStatement pstmt =null;
	private ResultSet rs =null;
	private StringBuilder sb = new StringBuilder();
	
	public MemberDBBean() {
		dbopen=new DBOpen();
	}
	public int login(String id, String passwd) {
		int cnt=0;
			try {
				con = dbopen.getConnection();
				sb.append("SELECT count(id) as cnt");
				sb.append(" FROM member");
				sb.append(" WHERE id=? AND passwd=?");
				
				
				pstmt = con.prepareStatement(sb.toString());
				pstmt.setString(1, id);
				pstmt.setString(2, passwd);
				rs =pstmt.executeQuery();
				
				if(rs.next()) {
					cnt=rs.getInt("cnt");

				}else {
					System.out.println("MEMBER READ FAIL");
				}
			}catch(Exception e) {
				System.out.println("MEMBER READ ERROR: "+e);
			}finally {
				DBClose.close(rs, pstmt, con);
			}
			return cnt;		
		}
}
