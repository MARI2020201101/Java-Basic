package oop0317;

interface Animal2 {
	void kind();
	void breathe();
}
class Tiger implements Animal2{
	@Override
	public void breathe() {
		// TODO Auto-generated method stub
	System.out.println("����");	
	}@Override
	public void kind() {
		// TODO Auto-generated method stub
		System.out.println("������");
	}
}

class Salmon implements Animal2{
	@Override
	public void breathe() {
		// TODO Auto-generated method stub
	System.out.println("����");	
	}@Override
	public void kind() {
		// TODO Auto-generated method stub
		System.out.println("���");
	}
}
public class Test08_interface {
public static void main(String[] args) {
	//�������̽� : �߻�Ŭ�����θ� �����Ǿ��ִ� ( �Ϲ� Ŭ���� ����) 
	//= �� new�Ұ���
	
	/*
	 * extends Ȯ�� implements ����
	 * �������̽��� �ڱ��ڽ����� ���� ��ü ���� �Ұ���. ����ֱ� ������.
	 * 
	 * Animal2 animal = new Animal2(); err-
	 */
	Animal2 tiger = new Tiger();
	tiger.breathe();
	tiger.kind();
	Animal2 salmon = new Salmon();
	salmon.breathe();
	salmon.kind();
}
}
