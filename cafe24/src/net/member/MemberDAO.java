package net.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import net.notice.NoticeDTO;
import net.utility.DBClose;
import net.utility.DBOpen;

public class MemberDAO {
	private DBOpen dbopen=null;
	private Connection con=null;
	private PreparedStatement pstmt =null;
	private ResultSet rs =null;
	private StringBuilder sb = new StringBuilder();
	
	public MemberDAO() {
		dbopen=new DBOpen();
	}
	public String loginProc(MemberDTO dto) {
	String mlevel="";
		try {
			con = dbopen.getConnection();
			sb.append("SELECT mlevel");
			sb.append(" FROM member");
			sb.append(" WHERE id=? AND passwd=?");
			sb.append(" AND mlevel IN('A1', 'B1', 'C1', 'D1')");
			
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPasswd());
			rs =pstmt.executeQuery();
			
			if(rs.next()) {
				mlevel=rs.getString("mlevel");

			}else {
				System.out.println("MEMBER READ FAIL");
			}
		}catch(Exception e) {
			System.out.println("MEMBER READ ERROR: "+e);
		}finally {
			DBClose.close(rs, pstmt, con);
		}
		return mlevel;		
	}
	
	public int duplicateID(String id) {
		int cnt=0;
			try {
				con = dbopen.getConnection();
				sb.append("SELECT count(id)");
				sb.append(" FROM member");
				sb.append(" WHERE id=? ");
				
				pstmt = con.prepareStatement(sb.toString());
				pstmt.setString(1,id);
			
				rs =pstmt.executeQuery();
				
				if(rs.next()) {
					cnt=rs.getInt(1);
				}else {
					System.out.println("MEMBER COUNT FAIL");
				}
			}catch(Exception e) {
				System.out.println("MEMBER COUNT ERROR: "+e);
			}finally {
				DBClose.close(rs, pstmt, con);
			}
			return cnt;		
		}
	
	public int insert(MemberDTO dto) {
		int cnt=0;
		try {
			con=dbopen.getConnection();
			sb.append(" INSERT INTO member(id, passwd, mname, tel, email, zipcode, address1, address2, job, mlevel, mdate)");
			sb.append(" VALUES(?,?,?,?,?,?,?,?,?,'D1',sysdate)");
			
			pstmt = con.prepareStatement(sb.toString());

			pstmt.setString(1,dto.getId());
			pstmt.setString(2,dto.getPasswd());
			pstmt.setString(3,dto.getMname());
			pstmt.setString(4,dto.getTel());
			pstmt.setString(5,dto.getEmail());
			pstmt.setString(6,dto.getZipcode());
			pstmt.setString(7,dto.getAddress1());
			pstmt.setString(8,dto.getAddress2());
			pstmt.setString(9,dto.getJob());
		

			cnt = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("MEMBER INSERT ERROR : "+e);
		}finally {
			DBClose.close(pstmt, con);
		}
		return cnt;
	}
	public int duplicateEmail(String email) {
		int cnt=0;
			try {
				con = dbopen.getConnection();
				sb.append("SELECT count(email)");
				sb.append(" FROM member");
				sb.append(" WHERE email=? ");
				
				pstmt = con.prepareStatement(sb.toString());
				pstmt.setString(1,email);
			
				rs =pstmt.executeQuery();
				
				if(rs.next()) {
					cnt=rs.getInt(1);
				}else {
					System.out.println("MEMBER EMAIL COUNT FAIL");
				}
			}catch(Exception e) {
				System.out.println("MEMBER EMAIL COUNT ERROR: "+e);
			}finally {
				DBClose.close(rs, pstmt, con);
			}
			return cnt;		
		}
	public MemberDTO select(String id) {
		MemberDTO dto = new MemberDTO();
		try {
			con = dbopen.getConnection();
			sb.append("SELECT id,passwd,mname,tel,email,zipcode,address1,address2,job");
			sb.append(" FROM member");
			sb.append(" WHERE id=?");
			
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, id);
			rs =pstmt.executeQuery();
			
			if(rs.next()) {
					dto.setId(rs.getString("id"));
					dto.setPasswd(rs.getString("passwd"));
					dto.setMname(rs.getString("mname"));
					dto.setTel(rs.getString("tel"));
					dto.setEmail(rs.getString("email"));
					dto.setZipcode(rs.getString("zipcode"));
					dto.setAddress1(rs.getString("address1"));
					dto.setAddress2(rs.getString("address2"));
					dto.setJob(rs.getString("job"));

			}else {
				System.out.println("MEMBER SELECT FAIL");
			}
		}catch(Exception e) {
			System.out.println("MEMBER SELECT ERROR: "+e);
		}finally {
			DBClose.close(rs, pstmt, con);
		}
		return dto;
	}
	public int update(MemberDTO dto) {
		int cnt=0;
		try {
			con = dbopen.getConnection();
			sb.append(" UPDATE member SET passwd=?,mname=?,tel=?,email=?,zipcode=?,address1=?,address2=?,job=? ");
			sb.append(" WHERE id=? ");
			
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1,dto.getPasswd());
			pstmt.setString(2,dto.getMname());
			pstmt.setString(3,dto.getTel());
			pstmt.setString(4,dto.getEmail());
			pstmt.setString(5,dto.getZipcode());
			pstmt.setString(6,dto.getAddress1());
			pstmt.setString(7,dto.getAddress2());
			pstmt.setString(8,dto.getJob());
			pstmt.setString(9,dto.getId());
			
			cnt =pstmt.executeUpdate();

		}catch(Exception e) {
			System.out.println("MEMBER UPDATE ERROR : "+e);
		}finally {
			DBClose.close(pstmt, con);
		}
		return cnt;
	}
	public int unregister(MemberDTO dto) {
		int cnt=0;
		try {
			con = dbopen.getConnection();
			sb.append(" UPDATE member SET mlevel='F1' ");
			sb.append(" WHERE id=? AND passwd=?");
			
			pstmt = con.prepareStatement(sb.toString());
			
			pstmt.setString(1,dto.getId());
			pstmt.setString(2,dto.getPasswd());
			
			
			cnt =pstmt.executeUpdate();

		}catch(Exception e) {
			System.out.println("MEMBER UNREGISTER ERROR : "+e);
		}finally {
			DBClose.close(pstmt, con);
		}
		return cnt;
	}
	
	public String findPasswd(MemberDTO dto) {
		String tempId ="";
		try {
			con = dbopen.getConnection();
			sb.append(" SELECT id FROM member WHERE email=? and mname=?");
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1,dto.getEmail());
			pstmt.setString(2,dto.getMname());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				tempId= rs.getString("id");
			}
			
			sb.delete(0, sb.length());
			
			sb.append(" UPDATE member SET passwd=? WHERE email=? and mname=? ");
			
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1,dto.getPasswd());
			pstmt.setString(2,dto.getEmail());
			pstmt.setString(3,dto.getMname());
			
			pstmt.executeUpdate();

		}catch(Exception e) {
			System.out.println("MEMBER UPDATE PW ERROR : "+e);
		}finally {
			DBClose.close(rs, pstmt, con);
		}
		return tempId;
	}
}
