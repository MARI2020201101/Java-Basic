package oop0316;
class AA{
	private void zero() {}
	public void one() {
		System.out.println("AA.one....");
	}
	public void two() {
		System.out.println("AA.two....");
	}
}
class BB extends AA{
	public void three() {
		System.out.println("BB.three....");
	}
}
class CC extends BB{
	public void four() {
		System.out.println("CC.four...");
	}
}



public class Test09_sangsok {

	public static void main(String[] args) {
		// extends: 상속. 부모자식관계를 만든다 . 자바는 다중상속불가
		
		AA aa = new AA();
		aa.one();
		aa.two();
		//private 속성은 상속되지 않는다
		//애초에 밖에서 못부르니까..당연
		BB bb = new BB();
		bb.three();
		bb.one();
		bb.two();
		CC cc = new CC();
		cc.four();
		cc.one();
		cc.two();
		cc.three();
	}

}
