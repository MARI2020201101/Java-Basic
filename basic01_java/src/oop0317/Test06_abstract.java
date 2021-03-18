package oop0317;
abstract class Animal{
	String name;
	void view() {};
	abstract void disp();//미완성된 메소드
}
class Elephants extends Animal{

	@Override//미완성된 메소드를 너가 구현해조!
	void disp() {
		// TODO Auto-generated method stub
		System.out.println("점보-");
	}
	
}
class Tuna extends Animal{
	@Override
	void disp() {
		// TODO Auto-generated method stub
	System.out.println("니모-");	
	}
}
public class Test06_abstract {
public static void main(String[] args) {
	//abstract 추상클래스
	/*
	 * 객체 생성불가
	 * but인터페이스를 더 많이 쓴다.(하긴 그렇지)
	 * 추상메소드가 하나라도 있으면 추상클래스가 된다
	 * 
	 * 같은 메소드로 다형성 구현하기
	 */
	
	Animal animal = new Elephants();
	animal.disp();
	animal = new Tuna();
	animal.disp();
}
}
