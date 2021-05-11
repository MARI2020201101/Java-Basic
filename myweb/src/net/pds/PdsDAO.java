package net.pds;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import net.utility.DBClose;
import net.utility.DBOpen;
import net.utility.Utility;

public class PdsDAO {
	private DBOpen dbopen=null;
	private Connection con=null;
	private PreparedStatement pstmt =null;
	private ResultSet rs =null;
	private StringBuilder sb = new StringBuilder();
	
	public PdsDAO() {
		dbopen=new DBOpen();
	}
	public int insert(PdsDTO dto) {
		int cnt=0;
		try {
			con=dbopen.getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append(" INSERT INTO tb_pds(pdsno,wname,subject,passwd,filename,filesize,regdate)");
			sb.append(" VALUES(pds_seq.nextval,?,?,?,?,?,sysdate)");
			
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1,dto.getWname());
			pstmt.setString(2,dto.getSubject());
			pstmt.setString(3,dto.getPasswd());
			pstmt.setString(4,dto.getFilename());
			pstmt.setLong(5,dto.getFilesize());
			cnt = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("PDS INSERT ERROR : "+e);
		}finally {
			DBClose.close(pstmt, con);
		}
		return cnt;
		
	}
	
	public synchronized ArrayList<PdsDTO> select(){
		ArrayList<PdsDTO> list = new ArrayList<PdsDTO>();
		try {
			con = dbopen.getConnection();
			
			StringBuilder sb = new StringBuilder();
			sb.append("	SELECT pdsno,wname,subject,filename,regdate,readcnt");
			sb.append(" FROM tb_pds");
			sb.append(" ORDER BY regdate desc");
			pstmt = con.prepareStatement(sb.toString());
			rs =pstmt.executeQuery();
			
			if(rs.next()) {
				do{
					PdsDTO dto = new PdsDTO();
					dto.setPdsno(rs.getInt("pdsno"));
					dto.setWname(rs.getString("wname"));
					dto.setSubject(rs.getString("subject"));
					dto.setFilename(rs.getString("filename"));
					dto.setRegdate(rs.getString("regdate"));
					dto.setReadcnt(rs.getInt("readcnt"));				
					list.add(dto);
				}while(rs.next());	
			}
		}catch(Exception e) {
			System.out.println("PDS SELECT FAIL ERROR :" +e);
		}finally {
			DBClose.close(rs, pstmt, con);
		}
		return list;
	}
	public int count(String col,String word) {
		int total=0;
		try {
			con = dbopen.getConnection();
			sb.append("SELECT count(pdsno) FROM tb_pds");	
			if(word.length()>=1) {
				String search="";
				if(col.equals("subject")) {
					search+="	WHERE subject LIKE '%"+word+"%'";
				}else {
					search+="	WHERE filename LIKE '%"+word+"%'"+" OR subject LIKE '%"+word+"%'";
				}				
				sb.append(search);
				}
					
			pstmt = con.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				total=Integer.parseInt(rs.getString(1));
			}
		}catch(Exception e) {
			System.out.println("PDS COUNT ERROR : "+e);
		}finally {
			DBClose.close(rs, pstmt, con);
		}
		return total;
	}
	public ArrayList<PdsDTO> list(String col, String word, int nowPage, int recordPerPage){
	    ArrayList<PdsDTO> list=null;
	    
	    int startRow = ((nowPage-1) * recordPerPage) + 1 ;
	    int endRow   = nowPage * recordPerPage;
	    
	    try{
	      con=dbopen.getConnection();
	      StringBuilder sb=new StringBuilder();
	      
	      word = word.trim();
	      
	      if(word.length()==0) { 
	    	  sb.append(" SELECT pdsno,wname,subject,filename,regdate,readcnt, r");
	    	  sb.append(" FROM( SELECT pdsno,wname,subject,filename,regdate,readcnt, rownum as r");
	    	  sb.append("       FROM ( SELECT pdsno,wname,subject,filename,regdate,readcnt");
	    	  sb.append("              FROM tb_pds");
	    	  sb.append("              ORDER BY regdate desc");
	    	  sb.append("           )");
	    	  sb.append("     )");
	    	  sb.append(" WHERE r>=" + startRow + " AND r<=" + endRow) ;
	        
	      } else {

	    	  sb.append(" SELECT pdsno,wname,subject,filename,regdate,readcnt, r");
	    	  sb.append(" FROM( SELECT pdsno,wname,subject,filename,regdate,readcnt,rownum as r");
	    	  sb.append("       FROM ( SELECT pdsno,wname,subject,filename,regdate,readcnt");
	    	  sb.append("              FROM tb_pds");
	        String search="";
	        if(col.equals("subject")) {
				search+="	WHERE subject LIKE '%"+word+"%'";
			}else {
				search+="	WHERE filename LIKE '%"+word+"%'"+" OR subject LIKE '%"+word+"%'";
			}//제목명, 이미지사진명+ 제목명
			
	        sb.append(search);        
	        
	        sb.append("              ORDER BY regdate desc");
	        sb.append("           )");
	        sb.append("     )");
	        sb.append(" WHERE r>=" + startRow + " AND r<=" + endRow) ;
	      }//if end
	      
	      pstmt=con.prepareStatement(sb.toString());
	      rs=pstmt.executeQuery();
	      if(rs.next()){
	        list=new ArrayList<>();
	        do{
	        	PdsDTO dto = new PdsDTO();
				dto.setPdsno(rs.getInt("pdsno"));
				dto.setWname(rs.getString("wname"));
				dto.setSubject(rs.getString("subject"));
				dto.setFilename(rs.getString("filename"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setReadcnt(rs.getInt("readcnt"));				
				list.add(dto);
	        }while(rs.next());
	      }//if end
	      
	    }catch(Exception e) {
	      System.out.println("PDS LIST ERROR"+e);
	    }finally {
	      DBClose.close(rs, pstmt, con);
	    }   
	    return list;
	  }//list() end
	
	public PdsDTO read(int pdsno) {
		PdsDTO dto = new PdsDTO();
		try {
			con = dbopen.getConnection();
			sb.append("SELECT pdsno,wname,subject,filename,filesize,regdate,readcnt");
			sb.append(" FROM tb_pds");
			sb.append(" WHERE pdsno=?");
			
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, pdsno);
			rs =pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setPdsno(rs.getInt("pdsno"));
				dto.setWname(rs.getString("wname"));
				dto.setSubject(rs.getString("subject"));
				dto.setFilename(rs.getString("filename"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setReadcnt(rs.getInt("readcnt"));	
				dto.setFilesize(rs.getLong("filesize"));
			}else {
				System.out.println("PDS READ FAIL");
			}
		}catch(Exception e) {
			System.out.println("PDS READ ERROR: "+e);
		}finally {
			DBClose.close(rs, pstmt, con);
		}
		return dto;
	}
	
	public void incrementCnt(int pdsno) {
		try {
			con = dbopen.getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append("update tb_pds set readcnt=(readcnt+1) ");
			sb.append(" WHERE pdsno=?");
			
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, pdsno);
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("PDS UPDATE COUNT ERROR : "+e);
		}finally {
			DBClose.close(pstmt, con);
		}
	}
	public int delete(PdsDTO dto) {
		int cnt=0;
		try {
			con = dbopen.getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append("delete from tb_pds where pdsno=? and passwd=? ");
			
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, dto.getPdsno());
			pstmt.setString(2, dto.getPasswd());
			
			cnt = pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("PDS DELETE ERROR : "+e);
		}finally {
			DBClose.close(pstmt, con);
		}
		return cnt;
	}
	
	
	public int delete2(PdsDTO dto,String saveDir) {
		int cnt=0;
		try {
			String filename ="";
			PdsDTO oldDto=read(dto.getPdsno());
			
			if(oldDto!=null) {
				filename=oldDto.getFilename();
			}
			
			con = dbopen.getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append("delete from tb_pds where pdsno=? and passwd=? ");
			
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, dto.getPdsno());
			pstmt.setString(2, dto.getPasswd());
			
			cnt = pstmt.executeUpdate();
			if(cnt==1) {
				Utility.deleteFile(saveDir, filename);
			}
		}catch(Exception e) {
			System.out.println("PDS DELETE ERROR : "+e);
		}finally {
			DBClose.close(pstmt, con);
		}
		return cnt;
	}
}
