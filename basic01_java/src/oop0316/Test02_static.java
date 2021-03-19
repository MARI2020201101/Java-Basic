package oop0316;

import java.util.Calendar;

class Sawon{
	//field
	String sabun;
	String name;
	int pay;

	//constructor
	public Sawon(String sabun, String name, int pay) {
		this.sabun = sabun;
		this.name = name;
		this.pay = pay;
	}

	public Sawon() {
	}
	
	static String COMPANY = "SOLDESK";
	static int SUDANG = 10;
	static double TAX = 0.03;
	
	//method
	static void line() {
		System.out.println("-------------------");
	}
	
}

public class Test02_static {

public static void main(String[] args) {
	//RAM �� ���� : static.heap(new ).stack(��������)
	//staticƯ¡
	//1���ۿ� �޸� �Ҵ� �ȵ�. �ڱ⸸�� static������ �ֱ⶧���� new���� ��밡��
	//������ ��ü���� ���� ��� ����
	
	System.out.println(Math.E); //static ����
	System.out.println(Math.abs(-3)); //static �Լ�
	System.out.println(String.format("%.2f", 12.345));
	//Ŭ���� �̸����� �ٷ� �����Ѵ� (����)
	
	//Ŭ���� ������ ���� �����Ѵ�
	System.out.println(Sawon.COMPANY);
	Sawon.line();
	
	//static ��� ������ ��
	Sawon one = new Sawon("1001", "����ȭ" , 100);
	double myTax = one.pay*one.TAX;
	int total = (int)(one.pay - myTax+ one.SUDANG);
	System.out.println("�� ���޾� :" + total);
	
	//static ������� �� 
	Sawon two = new Sawon("1002" , "�ݳ�ȭ", 200);
	myTax = two.pay*Sawon.TAX; //Ŭ���������� ���� �����ϱ�!  
	total = (int)(two.pay - myTax+ Sawon.SUDANG);
	System.out.println("�� ���޾� :" + total);
	
	System.out.println(Calendar.DATE);
	System.out.println(Calendar.HOUR);
	
	System.out.println(String.valueOf(3));
	System.out.println(String.valueOf(false)); //toString�̶� ����ѵ� null�ͼ��ǿ� ����
	
	Sawon kim = new Sawon("1003" , "����ȭ", 300);
	Sawon lee = new Sawon("1004" , "����", 400);
	System.out.println("-----------------------");
	System.out.println(kim.SUDANG);
	System.out.println(lee.SUDANG);
	
	//���� �ּҸ� �����ϱ� ������ ������ �̾�����..!!!!!(����)
	kim.SUDANG++;
	System.out.println("-----------------------");
	System.out.println(Sawon.SUDANG);
	Sawon.SUDANG = Sawon.SUDANG +1;
	

	System.out.println(Sawon.SUDANG);
	//�������������߿��� �� �ϳ��� ���� �����Ҷ� - ����ƽ�� ����
	//Ư���� url�̶����!!
	
}
}