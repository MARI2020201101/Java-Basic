package oop0316;

import java.util.Calendar;

//1) fianl 클래스(종단 클래스)
/*final class Animal{}
class Elephant extends Animal{}

*final 클래스는 상속받을 수 없다. 종단이기 때문이다! 에러-
*/

//2) final메소드 
class Fruit{
	void view(){}
	final void display() {}
}
class Apple extends Fruit{
//자식클래스 extends 부모클래스
	@Override
	void view() {
		// TODO Auto-generated method stub
		super.view();
	}
//display 는 오버라이드불가
	
}
public class Test03_final {

	public static void main(String[] args) {
		// final 마지막
		//변수 : 변수를 상수화 
		//함수 : 더이상 고쳐쓰지마! 오버라이드(재정의)불가
		//클래스 : 종단클래스. 부모클래스가 될 수 없다
		
		int a=3;
		a=5; //ok
		
		final int b= 2;//고정불변 상수화!!
		//b=4; err 다른 값으로 대입 불가능
		/*
		 * class Calendar{
		 * 		static final int YEAR = 1;
		 * 		static final int MONTH = 5;...
		 * }
		 */
		System.out.println(Calendar.MONTH);
		//Calendar.MONTH = 3; err
	}

}
