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
		// extends: ���. �θ��ڽİ��踦 ����� . �ڹٴ� ���߻�ӺҰ�
		
		AA aa = new AA();
		aa.one();
		aa.two();
		//private �Ӽ��� ��ӵ��� �ʴ´�
		//���ʿ� �ۿ��� ���θ��ϱ�..�翬
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
