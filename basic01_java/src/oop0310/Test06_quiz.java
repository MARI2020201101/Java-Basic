package oop0310;

public class Test06_quiz {
	public static void main(String[] args) {
		//����1) 1~3���� ������ ���� ���Ͻÿ�
		int total = 0;
		for(int a =1 ;a <4; a++) {
			total+=a;
		}System.out.println("������ �� : " +total);
		//����2) 1~5�߿��� ¦���� ������ ���Ͻÿ�
		int gae =0;
		for(int num = 1; num<6;num++ ) {
			if(num%2==0)
				gae++;
		}System.out.println("¦���� ������ " + gae +"��");
		
		//����3)4���丮�� ���� ���Ͻÿ�.(4*3*2*1)
		int fac = 1;
		for(int i=1 ; i<5 ;i++) {
			fac*=i;
		}
		System.out.println("4���丮�� ���� " + fac +"�Դϴ�.");
		//����4)1~100���� �߿��� ¦���� ��/Ȧ���� ���� ���� ���Ͻÿ�
		int hol = 0;
		int chac = 0;
		for(int i = 0 ; i<=100;i++) {
			if(i%2!=0) hol+=i;
			else chac +=i;
		}System.out.println("Ȧ���� ���� : "+ hol +" ,¦���� ���� : " +chac);
		
		//+) boolean ���� Ȱ��
		boolean flag = false;
		int odd = 0;
		int even =0;
		for(int a=1;a<=100 ; a++) {
			if(flag!=true) {
				odd+=a;
				flag=true;
			}else {
				even +=a;
				flag=false;
			}
		}System.out.println("Ȧ���� ���� : "+ odd +" ,¦���� ���� : " +even);
		
		//����5)x���� 10���κ��� x�� ���������� ����� ������ �Ǹ� x�� �� Ƚ���� ���Ͻÿ�.
		int x =3;
		int su = 0;
		int num1 = 10;
		while(num1>0) {
			num1=num1-x;
			su++;
		}System.out.println("10�� �� Ƚ���� "+ su+" �Դϴ�");
	}

}