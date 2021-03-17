package oop0317;

class School{
	String name = "School";
	public School() {
		System.out.println("school...");
	}
	
}
class MiddleSchool extends School{
	String name ="middleschool";
	public MiddleSchool() {
		super(); // 생략가능함. 부모의 생성자 함수호출 
		System.out.println("middle school...");
	}
}

class HighSchool extends School{

	String name ="HHHigh School";
	public HighSchool() {
		super(); //부모의 생성자 함수 호출 
		System.out.println("HighSchool...");
	}
	public void disp() {
		String name = "종로 고등학교";
		System.out.println(name); //지역변수 
		System.out.println(this.name); // 내이름!
		System.out.println(super.name); // 부모것 이름!(private 아니라서 가능함) 
	}
	
}

public class Test02_super {

	public static void main(String[] args) {
	MiddleSchool ms = new MiddleSchool();	
//상속관계에서 => 부모의 생성자함수를 먼저 호출한후 본인의 생성자 함수를 호출한다
	HighSchool hs = new HighSchool();
	System.out.println("-------------");
	hs.disp();
	}

}
