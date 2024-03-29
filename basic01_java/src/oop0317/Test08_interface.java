package oop0317;

interface Animal2 {
	void kind();
	void breathe();
}
class Tiger implements Animal2{
	@Override
	public void breathe() {
		// TODO Auto-generated method stub
	System.out.println("어흥");	
	}@Override
	public void kind() {
		// TODO Auto-generated method stub
		System.out.println("포유류");
	}
}

class Salmon implements Animal2{
	@Override
	public void breathe() {
		// TODO Auto-generated method stub
	System.out.println("뻐끔");	
	}@Override
	public void kind() {
		// TODO Auto-generated method stub
		System.out.println("어류");
	}
}
public class Test08_interface {
public static void main(String[] args) {
	//인터페이스 : 추상클래스로만 구성되어있다 ( 일반 클래스 없음) 
	//= 즉 new불가능
	
	/*
	 * extends 확장 implements 구현
	 * 인터페이스는 자기자신으로 직접 객체 생성 불가능. 비어있기 때문에.
	 * 
	 * Animal2 animal = new Animal2(); err-
	 */
	Animal2 tiger = new Tiger();
	tiger.breathe();
	tiger.kind();
	Animal2 salmon = new Salmon();
	salmon.breathe();
	salmon.kind();
}
}
