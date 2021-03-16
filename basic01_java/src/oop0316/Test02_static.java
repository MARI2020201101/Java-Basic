package oop0316;

import java.util.Calendar;

class Sawon{
	//field
	String sabun;
	String name;
	int pay;

	//constructor
	public Sawon(String sabun, String name, int pay) {
		this.sabun = sabun;
		this.name = name;
		this.pay = pay;
	}

	public Sawon() {
	}
	
	static String COMPANY = "SOLDESK";
	static int SUDANG = 10;
	static double TAX = 0.03;
	
	//method
	static void line() {
		System.out.println("-------------------");
	}
	
}

public class Test02_static {

public static void main(String[] args) {
	//RAM 의 공간 : static.heap(new ).stack(지역변수)
	//static특징
	//1번밖에 메모리 할당 안됨. 자기만의 static공간이 있기때문에 new없이 사용가능
	//별도의 객체생성 없이 사용 가능
	
	System.out.println(Math.E); //static 변수
	System.out.println(Math.abs(-3)); //static 함수
	System.out.println(String.format("%.2f", 12.345));
	//클래스 이름으로 바로 접근한다 (편함)
	
	//클래스 명으로 직접 접근한다
	System.out.println(Sawon.COMPANY);
	Sawon.line();
	
	//static 사용 안했을 때
	Sawon one = new Sawon("1001", "봉선화" , 100);
	double myTax = one.pay*one.TAX;
	int total = (int)(one.pay - myTax+ one.SUDANG);
	System.out.println("총 지급액 :" + total);
	
	//static 사용했을 때 
	Sawon two = new Sawon("1002" , "금낭화", 200);
	myTax = two.pay*Sawon.TAX; //클래스명으로 직접 접근하기!  
	total = (int)(two.pay - myTax+ Sawon.SUDANG);
	System.out.println("총 지급액 :" + total);
	
	System.out.println(Calendar.DATE);
	System.out.println(Calendar.HOUR);
	
	System.out.println(String.valueOf(3));
	System.out.println(String.valueOf(false)); //toString이랑 비슷한데 null익셉션에 강함
	
	Sawon kim = new Sawon("1003" , "무궁화", 300);
	Sawon lee = new Sawon("1004" , "백합", 400);
	System.out.println("-----------------------");
	System.out.println(kim.SUDANG);
	System.out.println(lee.SUDANG);
	
	//같은 주소를 공유하기 때문에 연산이 이어진다..!!!!!(놀라움)
	kim.SUDANG++;
	System.out.println("-----------------------");
	System.out.println(Sawon.SUDANG);
	Sawon.SUDANG = Sawon.SUDANG +1;
	

	System.out.println(Sawon.SUDANG);
	//여러페이지들중에서 단 하나의 값을 공유할때 - 스태틱을 쓰자
	//특정한 url이라든지!!
	
}
}
