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
		 * is�Լ��� : ��κ�boolean
		 * to�Լ��� : to���� ������ ��ȯ 
		 * get�Լ��� : ��κ� ���� o
		 * set�Լ��� : ���ϴ� ������ ���� . ��κ� void
		 */
		
		/*
		 * getter setter �Լ��� �ۼ� ��Ģ
		 * -> get or set+ ù���ڴ빮��  ������
		 */
		//java�� �̹� �m�m ����ȭ �Ǿ��ֱ� ������ �ű⿡ ���缭 ��������.^��^
		

	}

}
