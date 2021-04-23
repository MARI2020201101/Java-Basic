package net.sungjuk;

public class SungjukDTO {//Data Transfer Object
							//Value Object
	private int sno;					//데이터를 한꺼번에 객체화해서 사용할 수 있다
	private String uname;
	private int kor;
	private int mat;
	private int eng;
	private int aver;
	private String addr;
	private String wdate;
	
	public SungjukDTO() {}
	
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getAver() {
		return aver;
	}
	public void setAver(int aver) {
		this.aver = aver;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	@Override
	public String toString() {
		return "SungjukDTO [sno=" + sno + ", uname=" + uname + ", kor=" + kor + ", mat=" + mat + ", eng=" + eng
				+ ", aver=" + aver + ", addr=" + addr + ", wdate=" + wdate + "]";
	}
	
}
