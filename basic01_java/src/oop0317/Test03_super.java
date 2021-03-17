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
		//super.one = a; //private 아니라서 에러가 안나는데. 이런 경우가 거의 없을듯..
		//super.two = b; //부모 것 상속 해서 -> 내것으로 바꾸버림
		super(a, b); // 상속받은 멤버면수(one,two)에 초기값전달하기
		this.three =c;
		System.out.println("child...");
		
		//보통은 private으로 멤버변수 막아두니까.. 생성자로 접근해서 값 전달하기
		
	}
}

public class Test03_super {

	public static void main(String[] args) {

		Child child = new Child(10,20,30);
		System.out.println(child.one);//private아니라서 접근가능
		System.out.println(child.two);
		System.out.println(child.three);
	}

}
