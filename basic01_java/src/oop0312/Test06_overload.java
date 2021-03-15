package oop0312;

public class Test06_overload {

	public static void hap(int a) {
		System.out.println(a);
	}
	public static void hap(int a, int b) {
		System.out.println(a+b);
	}
	public static void hap(double a) {
		System.out.println(a);
	}
	public static void hap(double a, double b) {
		System.out.println(a+b);
	}

	
	public static void main(String[] args) {
		//메소드 오버로드 조건: args갯수 혹은 자료형이 달라야함
		//return 형은 달라도 같은함수로 인식!!->err
	}

}
