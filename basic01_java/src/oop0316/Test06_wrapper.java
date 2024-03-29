package oop0316;

public class Test06_wrapper {

	public static void main(String[] args) {
		//Wrapper 포장 클래스
		//기본 자료형을 참조형 화 (reference화) 해 놓은 클래스들
		//대부분  java.lang에 선언되어있음
		/*
		 * 대부분 첫글자만 대문자로 바꾸면됨
		 * boolean Boolean
		 * int Integer
		 * char Character
		 * double Double
		 * long Long 
		 * short Short
		 * byte Byte
		 * ...
		 * 
		 * JDK11이상부터는 기본형과 똑같은 버전으로 쓸수있음
		 */
	int in1 = 3;
	Integer in3 =8;
	System.out.println(in1);
	System.out.println(in3);
	
	System.out.println(in3.compareTo(in1));
	System.out.println(in3.doubleValue());
	
	System.out.println(Integer.toBinaryString(11));//2진수변환
	System.out.println(Integer.parseInt("3"));
	
	System.out.println(Integer.max(2, in1));

	//문제) 실수형 값들중에서 정수의합을 구하시오 -> 1+3+5
	long lo1= 3L;
	Double dou1 = 1.2;
	Double dou2 = 5.6;
	double dou3 = 3.4;
	int hap = 0;
	hap = dou1.intValue() + dou2.intValue()+ (int)dou3;
	System.out.println("hap :" + hap);
	
	char ch1= 'R';
	Character ch2 = 'r';
	System.out.println(ch1);
	System.out.println(ch2);
	System.out.println(Character.isWhitespace(ch1));
	System.out.println(Character.toLowerCase(ch1));
	System.out.println(Character.toUpperCase(ch2));
	
	
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	
	
	
	}
}
