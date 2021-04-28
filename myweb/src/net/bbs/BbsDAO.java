package net.bbs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
		int cnt=0;
		try {
			con=dbopen.getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append(" INSERT INTO tb_bbs(bbsno, wname, subject, content, passwd, ip, grpno)");
			sb.append(" VALUES(bbs_seq.nextval,?,?,?,?,?");
			sb.append("		,(SELECT NVL(MAX(bbsno),0)+1 FROM tb_bbs))");
			
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1,dto.getWname());
			pstmt.setString(2,dto.getSubject());
			pstmt.setString(3,dto.getContent());
			pstmt.setString(4,dto.getPasswd());
			pstmt.setString(5,dto.getIp());
			cnt = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("BBS INSERT ERROR : "+e);
		}finally {
			DBClose.close(pstmt, con);
		}
		return cnt;
		
	}
	
	public ArrayList<BbsDTO> list(){
		ArrayList<BbsDTO> list = new ArrayList<BbsDTO>();
		try {
			con = dbopen.getConnection();
			
			StringBuilder sb = new StringBuilder();
			sb.append("	SELECT bbsno, wname, subject, readcnt, regdt, indent");
			sb.append(" FROM tb_bbs");
			sb.append(" ORDER BY grpno desc, ansnum asc");
			pstmt = con.prepareStatement(sb.toString());
			rs =pstmt.executeQuery();
			
			if(rs.next()) {
				do{
					BbsDTO dto = new BbsDTO();
					dto.setBbsno(rs.getInt("bbsno"));
					dto.setWname(rs.getString("wname"));
					dto.setSubject(rs.getString("subject"));
					dto.setReadcnt(rs.getInt("readcnt"));
					dto.setRegdt(rs.getString("regdt"));
					dto.setIndent(Integer.parseInt(rs.getString("indent")));
					list.add(dto);
				}while(rs.next());	
			}
		}catch(Exception e) {
			System.out.println("BBS List ���� :" +e);
		}finally {
			DBClose.close(rs, pstmt, con);
		}
		return list;
	}
	
	public BbsDTO read(int bbsno) {
		BbsDTO dto = new BbsDTO();
		try {
			con = dbopen.getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT bbsno, wname, subject, content, readcnt, regdt, grpno, indent, ansnum, ip");
			sb.append(" FROM tb_bbs");
			sb.append(" WHERE bbsno=?");
			
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, bbsno);
			rs =pstmt.executeQuery();
			
			if(rs.next()) {
					dto.setBbsno(rs.getInt("bbsno"));
					dto.setWname(rs.getString("wname"));
					dto.setSubject(rs.getString("subject"));
					dto.setContent(rs.getString("content"));
					dto.setReadcnt(rs.getInt("readcnt"));
					dto.setRegdt(rs.getString("regdt"));
					dto.setGrpno(rs.getInt("grpno"));
					dto.setIndent(rs.getInt("indent"));
					dto.setAnsnum(rs.getInt("ansnum"));
					dto.setIp(rs.getString("ip"));				
			}else {
				System.out.println("READ ������ ����");
			}
		}catch(Exception e) {
			System.out.println("BBS Read ���� : "+e);
		}finally {
			DBClose.close(rs, pstmt, con);
		}
		return dto;
	}
	
	public void incrementCnt(int bbsno) {
		try {
			con = dbopen.getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append("update tb_bbs set readcnt=(readcnt+1) ");
			sb.append(" WHERE bbsno=?");
			
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, bbsno);
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("BBS UPDATE COUNT ���� : "+e);
		}finally {
			DBClose.close(pstmt, con);
		}
	}
	
	public int update(BbsDTO dto) {
		int cnt=0;
		try {
			con = dbopen.getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append("update tb_bbs set wname=? , subject=?, content=? ");
			sb.append(" WHERE bbsno=? and passwd=?");
			
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1,dto.getWname());
			pstmt.setString(2,dto.getSubject());
			pstmt.setString(3,dto.getContent());
			pstmt.setInt(4,dto.getBbsno());
			pstmt.setString(5,dto.getPasswd());
			cnt=pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("BBS UPDATE COUNT ���� : "+e);
		}finally {
			DBClose.close(pstmt, con);
		}
		return cnt;
	}
	public int delete(BbsDTO dto) {
		int cnt=0;
		try {
			con = dbopen.getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append("delete from tb_bbs where bbsno=? and passwd=? ");
			
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, dto.getBbsno());
			pstmt.setString(2, dto.getPasswd());
			
			cnt = pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("BBS DELETE ���� : "+e);
		}finally {
			DBClose.close(pstmt, con);
		}
		return cnt;
	}
	
	public int reply(BbsDTO dto) {
		int cnt=0;
		try {
			con=dbopen.getConnection();
			
			//1) �θ�� ���� ��������(select)
			StringBuilder sb = new StringBuilder();
			int grpno=0;
			int indent=0;
			int ansnum=0;
			sb.append("SELECT grpno,indent,ansnum FROM tb_bbs WHERE bbsno=?");
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, dto.getBbsno());
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				//�׷�ѹ� : ���� ������ ���� �׷쳢�� ���� �׷�ѹ� ����
				grpno=rs.getInt("grpno");
				
				//�鿩���� : ���������� indent +1, ���� �׷� ���� ���� ����
				indent=rs.getInt("indent")+1;
				
				//�ۼ��� : ���� ������ ansnum +1, �׷� ���� �������� & ������
				ansnum=rs.getInt("ansnum")+1;
			}else {
				System.out.println("�θ�� �ҷ����� ����");
			}
			
			//������ �� string����. ���ο� sql�ۼ�����
			sb.delete(0, sb.length());
			
			//�ۼ��� ������
			sb.append("	UPDATE tb_bbs SET ansnum=ansnum+1");
			sb.append("	WHERE ansnum>=? AND grpno=?");
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1,ansnum );
			pstmt.setInt(2,grpno);
			rs=pstmt.executeQuery();
			
			//reply �ֱ�
			sb.delete(0, sb.length());
			sb.append(" INSERT INTO tb_bbs(bbsno, wname, subject, content, passwd, ip, grpno, ansnum, indent)");
			sb.append(" VALUES(bbs_seq.nextval,?,?,?,?,?,?,?,?)");
			
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1,dto.getWname());
			pstmt.setString(2,dto.getSubject());
			pstmt.setString(3,dto.getContent());
			pstmt.setString(4,dto.getPasswd());
			pstmt.setString(5,dto.getIp());
			pstmt.setInt(6,grpno);
			pstmt.setInt(7,ansnum);
			pstmt.setInt(8,indent);
			cnt=pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("BBS REPLY INSERT ERROR : "+e);
		}finally {
			DBClose.close(rs, pstmt, con);
		}
		return cnt;
	}
	
	public int countAll() {
		int total=0;
		try {
			con = dbopen.getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append("select count(bbsno) from tb_bbs");			
			pstmt = con.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				total=Integer.parseInt(rs.getString(1));
			}
		}catch(Exception e) {
			System.out.println("BBS COUNT ���� : "+e);
		}finally {
			DBClose.close(rs, pstmt, con);
		}
		return total;
	}
}//class end
