package oop0315;

import java.util.GregorianCalendar;

class School{
	private String name;
	private int kor,eng,mat;
	private int aver;
	public School() {
	//기본 생성자 함수 = default constructor
		//한개도 만들지 않으면 자동으로 생성됩니다. 
		System.out.println("School()....");
	}
	//stack : {}블랑캣 안에서만 살고 나가면서 없어진다
	public School(String n) {
		//n: args 지역변수. 매개변수. stack에 할당한다
		name = n;
	}
	public School(int k, int e, int m) {
		kor = k;
		mat= m;
		eng = e;
	}
	public School(String n , int k, int e, int m) {
		name = n;
		kor = k;
		mat= m;
		eng = e;
	}
		
	public void calc() {
		this.aver= (kor+eng+mat)/3;
		System.out.println("aver : "+aver);
	}
	public void disp() {
		System.out.println("name :" + name);
		System.out.println("kor : "+kor);
		System.out.println("mat : "+mat);
		System.out.println("eng : "+eng);
		this.aver= (kor+eng+mat)/3;
		System.out.println("aver : "+aver);
	}
}

public class Test02_constructor {

	public static void main(String[] args) {
		//생성자 함수 constructor
		/*
		 * - 클래스명과 동일한 함수
		 * - new연산자와 함께 메모리를 할당할 때 사용
		 * - 오버로딩이 가능하다(함수니까)
		 */
		//소멸자 함수 destructor -> 자바는 없음. 가비지 콜렉터가 얌얌해줌ㅎㅂㅎ
		
		GregorianCalendar today = new GregorianCalendar();
		if(today.isLeapYear(2021)) {
			System.out.println("윤년입니다");
		}else System.out.println("평년입니다");
		
		int count1 = 0;
		for(int y= 1 ; y<2021;y++) {
			if(today.isLeapYear(y))count1++;
		}System.out.println("윤년 count :"+ count1);
		
		
		School s1 = new School();
		s1.calc();
		s1.disp();
		String a ="";		// 빈 문자열
		String b = null;	//메모리할당은 하지않고 b라는 참조변수 선언만 해 놓음
		System.out.println( "\"\" : "+ a);
		System.out.println(a.hashCode());
		System.out.println("null : " +b);
		//0 vs null
		//null 은 아예 존재자체가X. 메모리 할당 안했기 때문에 해쉬코드값도 없다
		
		School s2 = new School();
		School s3 = new School("개나리");
		s3.disp();
		School s4 = new School(100,100,100);
		s4.disp();
		School s5 = new School("진달래",100,90,95);
		s5.disp();
		
		String str1= "HAPPY"; //너무 많이 써서 기본자료형처럼 제공 
		String str2 = new String("HAPPY"); //원래는 이게 기본형
		System.out.println(str1);
		System.out.println(str2);
		
	}

}
