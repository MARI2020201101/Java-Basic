package oop0317;
abstract class Animal{
	String name;
	void view() {};
	abstract void disp();//�̿ϼ��� �޼ҵ�
}
class Elephants extends Animal{

	@Override//�̿ϼ��� �޼ҵ带 �ʰ� ��������!
	void disp() {
		// TODO Auto-generated method stub
		System.out.println("����-");
	}
	
}
class Tuna extends Animal{
	@Override
	void disp() {
		// TODO Auto-generated method stub
	System.out.println("�ϸ�-");	
	}
}
public class Test06_abstract {
public static void main(String[] args) {
	//abstract �߻�Ŭ����
	/*
	 * ��ü �����Ұ�
	 * but�������̽��� �� ���� ����.(�ϱ� �׷���)
	 * �߻�޼ҵ尡 �ϳ��� ������ �߻�Ŭ������ �ȴ�
	 * 
	 * ���� �޼ҵ�� ������ �����ϱ�
	 */
	
	Animal animal = new Elephants();
	animal.disp();
	animal = new Tuna();
	animal.disp();
}
}
