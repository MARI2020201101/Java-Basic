package net.sungjuk;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import net.utility.DBClose;
import net.utility.DBOpen;

public class SungjukDAO { //Data Access Object
							//데이터베이스 관련 비지니스 로직 구현
	private DBOpen dbopen = null;
	private Connection con=null;
	private PreparedStatement pstmt =null;
	private ResultSet rs =null;
	
	public SungjukDAO() {
		dbopen= new DBOpen();
	}
	
	public int insert(String uname, int kor, int mat, int eng, int aver, String addr) {
		int cnt=0;
		try {
			con = dbopen.getConnection();
			
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO sungjuk(sno, uname, kor, mat, eng, aver, addr, wdate)");
			sb.append(" VALUES(sungjuk_seq.nextval,?,?,?,?,?,?,sysdate)");
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, uname);
			pstmt.setInt(2, kor);
			pstmt.setInt(3, mat);
			pstmt.setInt(4, eng);
			pstmt.setInt(5, aver);
			pstmt.setString(6, addr);
			cnt =pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("성적테이블 INSERT 실패");
		}finally {
			DBClose.close(pstmt, con);
		}
		
		return cnt;
	}
	
	public int create(SungjukDTO dto) {
		int cnt=0;
		try {
			con = dbopen.getConnection();
			
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO sungjuk(sno, uname, kor, mat, eng, aver, addr, wdate)");
			sb.append(" VALUES(sungjuk_seq.nextval,?,?,?,?,?,?,sysdate)");
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, dto.getUname());
			pstmt.setInt(2, dto.getKor());
			pstmt.setInt(3, dto.getMat());
			pstmt.setInt(4, dto.getEng());
			pstmt.setInt(5, dto.getAver());
			pstmt.setString(6, dto.getAddr());
			cnt =pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("성적테이블 INSERT 실패");
		}finally {
			DBClose.close(pstmt, con);
		}
		
		return cnt;
	}
	
	public ArrayList<SungjukDTO> list(){
		ArrayList<SungjukDTO> list = new ArrayList<SungjukDTO>();
		try {
			con = dbopen.getConnection();
			
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT sno, uname, kor, mat, eng, aver, addr, wdate");
			sb.append(" FROM sungjuk");
			sb.append(" ORDER BY wdate DESC");
			pstmt = con.prepareStatement(sb.toString());
			rs =pstmt.executeQuery();
			
			if(rs.next()) {
				do{
					SungjukDTO dto = new SungjukDTO();
					dto.setSno(rs.getInt("sno"));
					dto.setUname(rs.getString("uname"));
					dto.setKor(rs.getInt("kor"));
					dto.setMat(rs.getInt("mat"));
					dto.setEng(rs.getInt("eng"));
					dto.setAver(rs.getInt("aver"));
					dto.setAddr(rs.getString("addr"));
					dto.setWdate(rs.getString("wdate"));
					list.add(dto);
				}while(rs.next());
				
			}else {
				list=null;
			}
		}catch(Exception e) {
			System.out.println("성적테이블 List 실패");
		}finally {
			DBClose.close(rs, pstmt, con);
		}
		return list;
	}
	
	public SungjukDTO read(int sno) {
		SungjukDTO dto = new SungjukDTO();
		try {
			con = dbopen.getConnection();
			
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT sno, uname, kor, mat, eng, aver, addr, wdate");
			sb.append(" FROM sungjuk");
			sb.append(" WHERE sno=?");
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, sno);
			rs =pstmt.executeQuery();
			
			if(rs.next()) {
				do{	
					dto.setSno(rs.getInt("sno"));
					dto.setUname(rs.getString("uname"));
					dto.setKor(rs.getInt("kor"));
					dto.setMat(rs.getInt("mat"));
					dto.setEng(rs.getInt("eng"));
					dto.setAver(rs.getInt("aver"));
					dto.setAddr(rs.getString("addr"));
					dto.setWdate(rs.getString("wdate"));
					
				}while(rs.next());
				
			}else {
					dto=null;
			}
		}catch(Exception e) {
			System.out.println("성적테이블 Read 실패");
		}finally {
			DBClose.close(rs, pstmt, con);
		}
		return dto;
	}
	
	public int delete(int sno) {
		int cnt=0;
		try {
			con = dbopen.getConnection();
			
			StringBuilder sb = new StringBuilder();
			sb.append("	DELETE");
			sb.append(" FROM sungjuk");
			sb.append(" WHERE sno=?");
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, sno);
			cnt =pstmt.executeUpdate();
			
			if(cnt==0) {
				System.out.println("sno : " + sno + " , 삭제실패");
			}
		}catch(Exception e) {
			System.out.println("성적테이블 Read 실패");
		}finally {
			DBClose.close(rs, pstmt, con);
		}
		return cnt;
	}
	
	public int update(SungjukDTO dto) {
		int cnt=0;
		try {
			con = dbopen.getConnection();
			
			StringBuilder sb = new StringBuilder();
			sb.append("	UPDATE sungjuk SET");
			sb.append(" uname=?, kor=?, mat=?, eng=?, aver=?, addr=?, wdate=sysdate");
			sb.append(" WHERE sno=?");
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, dto.getUname());
			pstmt.setInt(2, dto.getKor());
			pstmt.setInt(3, dto.getMat());
			pstmt.setInt(4, dto.getEng());
			pstmt.setInt(5, dto.getAver());
			pstmt.setString(6, dto.getAddr());
			pstmt.setInt(7, dto.getSno());
			cnt =pstmt.executeUpdate();
			
			if(cnt==0) {
				System.out.println("성적테이블 Update 실패");
			}
		}catch(Exception e) {
			System.out.println("성적테이블 update 실패");
		}finally {
			DBClose.close(rs, pstmt, con);
		}
		return cnt;
	}
}
