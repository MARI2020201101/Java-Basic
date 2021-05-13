package net.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import net.bbs.BbsDTO;
import net.utility.DBClose;
import net.utility.DBOpen;

public class NoticeDAO {
	private DBOpen dbopen=null;
	private Connection con=null;
	private PreparedStatement pstmt =null;
	private ResultSet rs =null;
	private StringBuilder sb = new StringBuilder();
	
	public NoticeDAO() {
		dbopen=new DBOpen();
	}

	public int insert(NoticeDTO dto) {
		int cnt=0;
		try {
			con=dbopen.getConnection();
			sb.append(" INSERT INTO tb_notice(subject, content)");
			sb.append(" VALUES(?,?)");
			
			pstmt = con.prepareStatement(sb.toString());

			pstmt.setString(1,dto.getSubject());
			pstmt.setString(2,dto.getContent());

			cnt = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("NOTICE INSERT ERROR : "+e);
		}finally {
			DBClose.close(pstmt, con);
		}
		return cnt;
	}
	
	public NoticeDTO read(int noticeno) {
		NoticeDTO dto = new NoticeDTO();
		try {
			con = dbopen.getConnection();
			sb.append("SELECT noticeno, subject, content, regdt");
			sb.append(" FROM tb_notice");
			sb.append(" WHERE noticeno=?");
			
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, noticeno);
			rs =pstmt.executeQuery();
			
			if(rs.next()) {
					dto.setNoticeno(rs.getInt("noticeno"));
					dto.setSubject(rs.getString("subject"));
					dto.setContent(rs.getString("content"));
					dto.setRegdt(rs.getString("regdt"));
			}else {
				System.out.println("NOTICE READ FAIL");
			}
		}catch(Exception e) {
			System.out.println("NOTICE READ ERROR: "+e);
		}finally {
			DBClose.close(rs, pstmt, con);
		}
		return dto;
	}
	
	public int update(NoticeDTO dto) {
		int cnt=0;
		try {
			con = dbopen.getConnection();
			sb.append(" UPDATE tb_notice SET subject=?, content=? ");
			sb.append(" WHERE noticeno=? ");
			
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1,dto.getSubject());
			pstmt.setString(2,dto.getContent());
			pstmt.setInt(3,dto.getNoticeno());
			cnt =pstmt.executeUpdate();

		}catch(Exception e) {
			System.out.println("NOTICE UPDATE ERROR : "+e);
		}finally {
			DBClose.close(pstmt, con);
		}
		return cnt;
	}
	
	public int delete(int noticeno) {
		int cnt=0;
		try {
			con = dbopen.getConnection();
			sb.append("DELETE FROM tb_notice where noticeno=? ");
			
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, noticeno);
			
			cnt = pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("NOTICE DELETE ERROR : "+e);
		}finally {
			DBClose.close(pstmt, con);
		}
		return cnt;
	}
	
	
	
	public int count(String col,String word) {
		int total=0;
		try {
			con = dbopen.getConnection();
			sb.append("SELECT count(noticeno) FROM tb_notice");	
			if(word.length()>=1) {
				String search="";
				if(col.equals("subject")) {
					search+="	WHERE subject LIKE '%"+word+"%'";
				}else {
					search+="	WHERE content LIKE '%"+word+"%'"+" OR subject LIKE '%"+word+"%'";
				}				
				sb.append(search);
				}
					
			pstmt = con.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				total=Integer.parseInt(rs.getString(1));
			}
		}catch(Exception e) {
			System.out.println("NOTICE COUNT ERROR : "+e);
		}finally {
			DBClose.close(rs, pstmt, con);
		}
		return total;
	}

	public ArrayList<NoticeDTO> select(){
		ArrayList<NoticeDTO> list = new ArrayList<NoticeDTO>();
		try {
			con = dbopen.getConnection();
			
			StringBuilder sb = new StringBuilder();
			sb.append("	SELECT noticeno, subject, content, regdt");
			sb.append(" FROM tb_notice");
			sb.append(" ORDER BY noticeno desc");
			pstmt = con.prepareStatement(sb.toString());
			rs =pstmt.executeQuery();
			
			if(rs.next()) {
				do{
					NoticeDTO dto = new NoticeDTO();
					dto.setNoticeno(rs.getInt("noticeno"));
					dto.setSubject(rs.getString("subject"));
					dto.setContent(rs.getString("content"));
					dto.setRegdt(rs.getString("regdt"));
					list.add(dto);
				}while(rs.next());	
			}
		}catch(Exception e) {
			System.out.println("NOTICE SELECT FAIL ERROR :" +e);
		}finally {
			DBClose.close(rs, pstmt, con);
		}
		return list;
	}
	public ArrayList<NoticeDTO> select2(String word){
		ArrayList<NoticeDTO> list = new ArrayList<NoticeDTO>();
		try {
			con = dbopen.getConnection();
			
			StringBuilder sb = new StringBuilder();
			sb.append("	SELECT noticeno, subject, content, regdt");
			sb.append(" FROM tb_notice");
			if(word.length()>=1) {
				String search="";
				
				search+="	WHERE content LIKE '%"+word+"%'"+" OR subject LIKE '%"+word+"%'";
				sb.append(search);
				}
			sb.append(" ORDER BY noticeno desc");
			pstmt = con.prepareStatement(sb.toString());
			rs =pstmt.executeQuery();
			
			if(rs.next()) {
				do{
					NoticeDTO dto = new NoticeDTO();
					dto.setNoticeno(rs.getInt("noticeno"));
					dto.setSubject(rs.getString("subject"));
					dto.setContent(rs.getString("content"));
					dto.setRegdt(rs.getString("regdt"));
					list.add(dto);
				}while(rs.next());	
			}
		}catch(Exception e) {
			System.out.println("NOTICE SELECT FAIL ERROR :" +e);
		}finally {
			DBClose.close(rs, pstmt, con);
		}
		return list;
	}
	public ArrayList<NoticeDTO> select3(String col, String word){
		ArrayList<NoticeDTO> list = new ArrayList<NoticeDTO>();
		try {
			con = dbopen.getConnection();
			
			StringBuilder sb = new StringBuilder();
			sb.append("	SELECT noticeno, subject, content, regdt");
			sb.append(" FROM tb_notice");
			if(word.length()>=1) {
				String search="";
				if(col.equals("subject")) {
					search+="	WHERE subject LIKE '%"+word+"%'";
				}else {
					search+="	WHERE content LIKE '%"+word+"%'"+" OR subject LIKE '%"+word+"%'";
				}
				sb.append(search);
				}
			sb.append(" ORDER BY noticeno desc");
			pstmt = con.prepareStatement(sb.toString());
			rs =pstmt.executeQuery();
			
			if(rs.next()) {
				do{
					NoticeDTO dto = new NoticeDTO();
					dto.setNoticeno(rs.getInt("noticeno"));
					dto.setSubject(rs.getString("subject"));
					dto.setContent(rs.getString("content"));
					dto.setRegdt(rs.getString("regdt"));
					list.add(dto);
				}while(rs.next());	
			}
		}catch(Exception e) {
			System.out.println("NOTICE SELECT FAIL ERROR :" +e);
		}finally {
			DBClose.close(rs, pstmt, con);
		}
		return list;
	}
	public ArrayList<NoticeDTO> list(String col, String word, int nowPage, int recordPerPage){
	    ArrayList<NoticeDTO> list=null;
	    
	    int startRow = ((nowPage-1) * recordPerPage) + 1 ;
	    int endRow   = nowPage * recordPerPage;
	    
	    try{
	      con=dbopen.getConnection();
	      StringBuilder sb=new StringBuilder();
	      
	      word = word.trim();
	      
	      if(word.length()==0) {  
	    	  sb.append(" SELECT noticeno, subject, content, regdt, r");
	    	  sb.append(" FROM( SELECT noticeno, subject, content, regdt, @RNO := @RNO + 1 AS r");
	    	  sb.append("       FROM ( SELECT noticeno, subject, content, regdt");
	    	  sb.append("       FROM tb_notice ");
	    	  sb.append("       )A, ( SELECT @RNO := 0 ) B ORDER BY noticeno desc");
	    	  sb.append("        )C WHERE r>="+ startRow +" AND r<="+ endRow);
	    	  
	    	  
	      } else {

	    	  sb.append(" SELECT noticeno, subject, content, regdt, r");
	    	  sb.append(" FROM( SELECT noticeno, subject, content, regdt, @RNO := @RNO + 1 AS r");
	    	  sb.append("       FROM ( SELECT noticeno, subject, content, regdt");
	    	  sb.append("       FROM tb_notice ");
	    	  
	    	  String search="";
		        if(col.equals("subject")) {
					search+="	WHERE subject LIKE '%"+word+"%'";
				}else {
					search+="	WHERE content LIKE '%"+word+"%'"+" OR subject LIKE '%"+word+"%'";
				}
				
		        sb.append(search);        
	    	  
	    	  sb.append("       )A, ( SELECT @RNO := 0 ) B ORDER BY noticeno desc");
	    	  sb.append("        )C WHERE r>="+ startRow +" AND r<="+ endRow);
	    	  
	      }//if end
	      
	      pstmt=con.prepareStatement(sb.toString());
	      rs=pstmt.executeQuery();
	      if(rs.next()){
	        list=new ArrayList<>();
	        do{
	        	NoticeDTO dto = new NoticeDTO();
				dto.setNoticeno(rs.getInt("noticeno"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setRegdt(rs.getString("regdt"));
				list.add(dto);
	        }while(rs.next());
	      }//if end
	      
	    }catch(Exception e) {
	      System.out.println("NOTICE LIST ERROR"+e);
	    }finally {
	      DBClose.close(rs, pstmt, con);
	    }   
	    return list;
	  }//list3() end
}
