package oop0316;

import java.util.Calendar;

//1) fianl Ŭ����(���� Ŭ����)
/*final class Animal{}
class Elephant extends Animal{}

*final Ŭ������ ��ӹ��� �� ����. �����̱� �����̴�! ����-
*/

//2) final�޼ҵ� 
class Fruit{
	void view(){}
	final void display() {}
}
class Apple extends Fruit{
//�ڽ�Ŭ���� extends �θ�Ŭ����
	@Override
	void view() {
		// TODO Auto-generated method stub
		super.view();
	}
//display �� �������̵�Ұ�
	
}
public class Test03_final {

	public static void main(String[] args) {
		// final ������
		//���� : ������ ���ȭ 
		//�Լ� : ���̻� ���ľ�����! �������̵�(������)�Ұ�
		//Ŭ���� : ����Ŭ����. �θ�Ŭ������ �� �� ����
		
		int a=3;
		a=5; //ok
		
		final int b= 2;//�����Һ� ���ȭ!!
		//b=4; err �ٸ� ������ ���� �Ұ���
		/*
		 * class Calendar{
		 * 		static final int YEAR = 1;
		 * 		static final int MONTH = 5;...
		 * }
		 */
		System.out.println(Calendar.MONTH);
		//Calendar.MONTH = 3; err
	}

}
