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
			 sb.append(" INSERT INTO tb_bbs(wname,subject,content,grpno,passwd,ip,regdt)");
		     sb.append(" VALUES(?, ?, ?, (SELECT ifnull(max(bbsno),0)+1 FROM tb_bbs as TB),?,?,now())");
			
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
			System.out.println("BBS List ERROR :" +e);
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
				System.out.println("READ ERROR");
			}
		}catch(Exception e) {
			System.out.println("BBS Read ERROR : "+e);
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
			System.out.println("BBS UPDATE COUNT ERROR : "+e);
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
			System.out.println("BBS UPDATE COUNT ERROR : "+e);
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
			System.out.println("BBS DELETE ERROR : "+e);
		}finally {
			DBClose.close(pstmt, con);
		}
		return cnt;
	}
	
	public int reply(BbsDTO dto) {
		int cnt=0;
		try {
			con=dbopen.getConnection();

			StringBuilder sb = new StringBuilder();
			int grpno=0;
			int indent=0;
			int ansnum=0;
			sb.append(" INSERT INTO tb_bbs(wname, subject, content, passwd, ip, grpno, indent, ansnum, regdt)");
		    sb.append(" VALUES(?,?,?,?,?,?,?,?,now())");
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, dto.getBbsno());
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
			
				grpno=rs.getInt("grpno");
				
				
				indent=rs.getInt("indent")+1;
				
				
				ansnum=rs.getInt("ansnum")+1;
			}else {
				System.out.println("ERROR");
			}
			//스트링빌더 리셋
			sb.delete(0, sb.length());
			
			sb.append("	UPDATE tb_bbs SET ansnum=ansnum+1");
			sb.append("	WHERE ansnum>=? AND grpno=?");
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1,ansnum );
			pstmt.setInt(2,grpno);
			rs=pstmt.executeQuery();
			
			//reply 
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
			System.out.println("BBS COUNT ERROR: "+e);
		}finally {
			DBClose.close(rs, pstmt, con);
		}
		return total;
	}
	
	public ArrayList<BbsDTO> list2(String col, String word){
		ArrayList<BbsDTO> list = new ArrayList<BbsDTO>();
		try {
			con = dbopen.getConnection();
			
			StringBuilder sb = new StringBuilder();
			sb.append("	SELECT bbsno, wname, subject, readcnt, regdt, indent");
			sb.append(" FROM tb_bbs");
			
			if(word.length()>=1) {
				String search="";
				if(col.equals("wname")) {
					search+="	WHERE wname LIKE '%"+word+"%'";
				}else if(col.equals("subject")) {
					search+="	WHERE subject LIKE '%"+word+"%'";
				}else if(col.equals("content")) {
					search+="	WHERE content LIKE '%"+word+"%'";
				}else {
					search+="	WHERE content LIKE '%"+word+"%'"+" OR subject LIKE '%"+word+"%'";
				}
			sb.append(search);
			}//if end
			
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
			System.out.println("BBS List ERROR :" +e);
		}finally {
			DBClose.close(rs, pstmt, con);
		}
		return list;
	}
	public int count2(String col, String word) {
		int total=0;
		try {
			con = dbopen.getConnection();
			StringBuilder sb = new StringBuilder();
			
			sb.append("SELECT count(bbsno) FROM tb_bbs");	
		
			if(word.length()>=1) {
				String search="";
				if(col.equals("wname")) {
					search+="	WHERE wname LIKE '%"+word+"%'";
				}else if(col.equals("subject")) {
					search+="	WHERE subject LIKE '%"+word+"%'";
				}else if(col.equals("content")) {
					search+="	WHERE content LIKE '%"+word+"%'";
				}else {
					search+="	WHERE content LIKE '%"+word+"%'"+" OR subject LIKE '%"+word+"%'";
				}
			sb.append(search);
			}//if end
					
			pstmt = con.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				total=Integer.parseInt(rs.getString(1));
			}
		}catch(Exception e) {
			System.out.println("BBS COUNT ERROR : "+e);
		}finally {
			DBClose.close(rs, pstmt, con);
		}
		return total;
	}
	
	public ArrayList<BbsDTO> list3(String col, String word, int nowPage, int recordPerPage){
	    ArrayList<BbsDTO> list=null;
	    
	    // 1 page : WHERE r>=1 AND r<=10
	    // 2 page : WHERE r>=11 AND r<=20
	    // 3 page : WHERE r>=21 AND r<=30
	    int startRow = ((nowPage-1) * recordPerPage) + 1 ;
	    int endRow   = nowPage * recordPerPage;
	    
	    try{
	      con=dbopen.getConnection();
	      StringBuilder sb=new StringBuilder();
	      
	      word = word.trim(); 
	      
	      if(word.length()==0) { 
	    	  sb.append(" SELECT bbsno,subject,wname,readcnt,indent,regdt, r");
	    	  sb.append(" FROM( SELECT bbsno,subject,wname,readcnt,indent,regdt, rownum as r");
	    	  sb.append("       FROM ( SELECT bbsno,subject,wname,readcnt,indent,regdt");
	    	  sb.append("              FROM tb_bbs");
	    	  sb.append("              ORDER BY grpno DESC, ansnum ASC");
	    	  sb.append("           )");
	    	  sb.append("     )");
	    	  sb.append(" WHERE r>=" + startRow + " AND r<=" + endRow) ;
	        
	      } else {
	        
	    	  sb.append(" SELECT bbsno,subject,wname,readcnt,indent,regdt, r");
	    	  sb.append(" FROM( SELECT bbsno,subject,wname,readcnt,indent,regdt, rownum as r");
	    	  sb.append("       FROM ( SELECT bbsno,subject,wname,readcnt,indent,regdt");
	    	  sb.append("              FROM tb_bbs");
	        
	        String search="";
	        if(col.equals("wname")) {
	          search += " WHERE wname LIKE '%" + word + "%'";
	        } else if(col.equals("subject")) {
	          search += " WHERE subject LIKE '%" + word + "%'";
	        } else if(col.equals("content")) {
	          search += " WHERE content LIKE '%" + word + "%'";
	        } else if(col.equals("subject_content")) {
	          search += " WHERE subject LIKE '%" + word + "%'";
	          search += " OR content LIKE '%" + word + "%'";
	        }
	        
	        sb.append(search);        
	        
	        sb.append("              ORDER BY grpno DESC, ansnum ASC");
	        sb.append("           )");
	        sb.append("     )");
	        sb.append(" WHERE r>=" + startRow + " AND r<=" + endRow) ;
	      }//if end
	      
	      pstmt=con.prepareStatement(sb.toString());
	      rs=pstmt.executeQuery();
	      if(rs.next()){
	        list=new ArrayList<>();
	        do{
	          BbsDTO dto=new BbsDTO();
	          dto.setBbsno(rs.getInt("bbsno"));
	          dto.setSubject(rs.getString("subject"));
	          dto.setWname(rs.getString("wname"));
	          dto.setReadcnt(rs.getInt("readcnt"));
	          dto.setRegdt(rs.getString("regdt"));
	          dto.setIndent(rs.getInt("indent"));
	          list.add(dto);
	        }while(rs.next());
	      }//if end
	      
	    }catch(Exception e) {
	      System.out.println("ERROR"+e);
	    }finally {
	      DBClose.close(rs, pstmt, con);
	    }   
	    return list;
	  }//list3() end
}//class end
