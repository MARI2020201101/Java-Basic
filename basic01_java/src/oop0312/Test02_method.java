package oop0312;

public class Test02_method {

	public static void main(String[] args) {
		System.out.println(test1(4,5));
		System.out.println(test2(9));
		System.out.println(fact(4));
	}
	
	public static int test1(int a, int b) {
		return a+b;
	}
	public static String test2(int a) {
		if(a%2!=0) return "¦��";
		else return "Ȧ��";
	}
	
	//����1) ���� Ȯ�� �Լ�

	public static String leap(int i) {
		if(i%4==0 && i%100!=0|| i%400==0) return"����";
		else return "���";
	}
	
	public static boolean leap2(int i) {
		if(i%4==0 && i%100!=0|| i%400==0) return true;
		else return  false;
	}
	
	//����2) ���丮�󰪱��ϴ� �Լ�
	public static int fact(int i) {
		int result= 1;
		for(int n =1 ; n<=i; n++) {
			result=result*n;
		}return result;
	}
	

}
