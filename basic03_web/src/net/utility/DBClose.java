package net.utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBClose {//데이터베이스 자원반납 메소드들
	
	public static void close(ResultSet rs, PreparedStatement pstmt, Connection con) {
		try{if(rs!=null){rs.close();rs=null;}
		}catch(Exception e){}
		try{if(pstmt!=null){pstmt.close();pstmt=null;}
		}catch(Exception e){}
		try{if(con!=null){con.close();con=null;}
		}catch(Exception e){}
	}
	public static void close(PreparedStatement pstmt, Connection con) {
		try{if(pstmt!=null){pstmt.close();pstmt=null;}
		}catch(Exception e){}
		try{if(con!=null){con.close();con=null;}
		}catch(Exception e){}
	}
	public static void close(Connection con) {
		try{if(con!=null){con.close();con=null;}
		}catch(Exception e){}
	}
}
