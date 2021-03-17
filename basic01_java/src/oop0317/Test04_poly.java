package oop0317;

class Father{
	public String name ="아버지";
	public String addr = "주소";
	
	public Father() {}
	public Father(String name, String addr) {
		this.addr = addr;
		this.name = name;
	}
	public void disp() {
		System.out.println(this.name);
		System.out.println(this.addr);
	}
}

class Son extends Father{
	public Son(String name, String addr) {
		super(name,addr);
	}
	public Son() {
		super();
	}
}

class Daughter extends Father{
	public String friend = "절친";
	public Daughter(String name, String addr) {
		super(name,addr);
	}
	public Daughter() {
		super();
	}
	
	
}
public class Test04_poly {

	public static void main(String[] args) {
		//다형성의 예 
		//Calendar cal = new GregorianCalendar();
		
		//1) 일반적인 방식으로 객체 생성
		// ->new 방식 = POJO방식 이라고 한다 .
		//Plain Old Java Object
		
		Father fa = new Father();
		fa.disp();
		
		Son son = new Son("손흥민", "영국");
		son.disp();
		
		//2) 다형성을 이용한 객체 생성
		//-> 자식클래스가 부모클래스에 대입 가능하다
		//-> 부모클래스는 저장된 자식클래스의 모양으로 자신의 모양을 변환한다
		
		Father father = new Son("개나리","관철동");
		father.disp(); //자식의 이름으로 바꾸어 버리기!!
		//데이터 손실이 발생되지 않는다!! 부모님 생성자 불럿.
		
		//인터페이스에서 다형성이 자연스럽게 더 잘된다. 
		//자식클래스에서 추가된 멤버는 다형성의 대상 X. 부모가 쓸수없다 ( 이건 시간여행임..)
		Son son2 = new Son();
		Father fa2 = new Father();
		Daughter dau = new Daughter();
		fa2 = new Daughter(); 
		
		
		Object obj = new Son(); 
		Son son3 =(Son) new Object(); // 자식클래스가 부모클래스에 들어간다

		Father fa3 = new Son();
		
		
		
	}

}
