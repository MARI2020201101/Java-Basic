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
		//�޼ҵ� �����ε� ����: args���� Ȥ�� �ڷ����� �޶����
		//return ���� �޶� �����Լ��� �ν�!!->err
	}

}
