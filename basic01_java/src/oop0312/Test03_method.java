package oop0312;

public class Test03_method {
	
	public static void test() {
		test();
	}
	public static long fact(int a) {
		if(a==0)return 1;
		else return a*fact(a-1);
	}
	
	public static void main(String[] args) {
		System.out.println(fact(3));
	}

	//����� �Լ� ȣ��... �� ��¾��~~~~!!!
}
