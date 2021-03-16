package oop0316;

class Sungjuk{
	private String name;
	private int kor, eng, mat;
	private int aver;
	
	public Sungjuk() {
		this.name = "손흥민";
	}
	
	public Sungjuk(String name) {
		this.name = name;
	}
	
//일반 메소드에서는 생성자 함수 호출 불가능 -> why? 생성되지도 않았으니까
}
public class Test04_this {

	public static void main(String[] args) {
		//this()
		//자신의 생성자함수가 자신의 생성자 함수를 호출할 때
	}

}
