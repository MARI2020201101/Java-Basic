package oop0310;

public class Test03_for {

	public static void main(String[] args) {
		for(int a=0;a<10;a++) {
			System.out.println(a+" java");
		}
		//��ȿ���� scope 
		//global variable (�浹��<) local variable
		//���������� �켱������ �������
		
		//4�� ����ϱ�
		for(int i =1; i<10 ;i++) {
			System.out.printf("4*%d=%d\n",i,4*i);
		}

	}

}
