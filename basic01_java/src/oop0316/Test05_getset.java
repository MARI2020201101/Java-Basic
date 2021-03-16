package oop0316;

class Bbs{
	private int bbsno;
	private String writer;
	private String subject;
	
	public Bbs() {}
	public int getBbono() {return this.bbsno;}
    public void setBbono(int bbsno) {this.bbsno =  bbsno;}
    public String getWriter() {return this.writer;}
    public void setWriter(String writer) {this.writer =  writer;}
    public String getSubject() {return this.subject;}
    public void setSubject(String subject) {this.subject =  subject;}
	
}

class Member{
	private int memberno;
	private String id;
	private String passwd;
	private String email;
	
	public Member() {}

	public int getMemberno() {
		return memberno;
	}

	public void setMemberno(int memberno) {
		this.memberno = memberno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
public class Test05_getset {

	public static void main(String[] args) {
		/*
		 * is함수명 : 대부분boolean
		 * to함수명 : to뒤의 값으로 반환 
		 * get함수명 : 대부분 리턴 o
		 * set함수명 : 원하는 값으로 세팅 . 대부분 void
		 */
		
		/*
		 * getter setter 함수명 작성 규칙
		 * -> get or set+ 첫글자대문자  변수명
		 */
		//java는 이미 챡챡 구조화 되어있기 때문에 거기에 맞춰서 따라가주자.^ㅡ^
		

	}

}
