package oop0317;

class Parent {
	int one,two;
	public Parent() {}
	public Parent(int one, int two) {
		System.out.println("parent...");
		this.one = one;
		this.two = two;
	}
}

class Child extends Parent{
	int three;
	public Child() {
		super();
	}
	public Child(int a, int b, int c) {
		//super.one = a; //private �ƴ϶� ������ �ȳ��µ�. �̷� ��찡 ���� ������..
		//super.two = b; //�θ� �� ��� �ؼ� -> �������� �ٲٹ���
		super(a, b); // ��ӹ��� ������(one,two)�� �ʱⰪ�����ϱ�
		this.three =c;
		System.out.println("child...");
		
		//������ private���� ������� ���Ƶδϱ�.. �����ڷ� �����ؼ� �� �����ϱ�
		
	}
}

public class Test03_super {

	public static void main(String[] args) {

		Child child = new Child(10,20,30);
		System.out.println(child.one);//private�ƴ϶� ���ٰ���
		System.out.println(child.two);
		System.out.println(child.three);
	}

}
