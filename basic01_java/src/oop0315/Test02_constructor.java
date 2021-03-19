package oop0315;

import java.util.GregorianCalendar;

class School{
	private String name;
	private int kor,eng,mat;
	private int aver;
	public School() {
	//�⺻ ������ �Լ� = default constructor
		//�Ѱ��� ������ ������ �ڵ����� �����˴ϴ�. 
		System.out.println("School()....");
	}
	//stack : {}����Ĺ �ȿ����� ��� �����鼭 ��������
	public School(String n) {
		//n: args ��������. �Ű�����. stack�� �Ҵ��Ѵ�
		name = n;
	}
	public School(int k, int e, int m) {
		kor = k;
		mat= m;
		eng = e;
	}
	public School(String n , int k, int e, int m) {
		name = n;
		kor = k;
		mat= m;
		eng = e;
	}
		
	public void calc() {
		this.aver= (kor+eng+mat)/3;
		System.out.println("aver : "+aver);
	}
	public void disp() {
		System.out.println("name :" + name);
		System.out.println("kor : "+kor);
		System.out.println("mat : "+mat);
		System.out.println("eng : "+eng);
		this.aver= (kor+eng+mat)/3;
		System.out.println("aver : "+aver);
	}
}

public class Test02_constructor {

	public static void main(String[] args) {
		//������ �Լ� constructor
		/*
		 * - Ŭ�������� ������ �Լ�
		 * - new�����ڿ� �Բ� �޸𸮸� �Ҵ��� �� ���
		 * - �����ε��� �����ϴ�(�Լ��ϱ�)
		 */
		//�Ҹ��� �Լ� destructor -> �ڹٴ� ����. ������ �ݷ��Ͱ� ������ܤ�����
		
		GregorianCalendar today = new GregorianCalendar();
		if(today.isLeapYear(2021)) {
			System.out.println("�����Դϴ�");
		}else System.out.println("����Դϴ�");
		
		int count1 = 0;
		for(int y= 1 ; y<2021;y++) {
			if(today.isLeapYear(y))count1++;
		}System.out.println("���� count :"+ count1);
		
		
		School s1 = new School();
		s1.calc();
		s1.disp();
		String a ="";		// �� ���ڿ�
		String b = null;	//�޸��Ҵ��� �����ʰ� b��� �������� ���� �� ����
		System.out.println( "\"\" : "+ a);
		System.out.println(a.hashCode());
		System.out.println("null : " +b);
		//0 vs null
		//null �� �ƿ� ������ü��X. �޸� �Ҵ� ���߱� ������ �ؽ��ڵ尪�� ����
		
		School s2 = new School();
		School s3 = new School("������");
		s3.disp();
		School s4 = new School(100,100,100);
		s4.disp();
		School s5 = new School("���޷�",100,90,95);
		s5.disp();
		
		String str1= "HAPPY"; //�ʹ� ���� �Ἥ �⺻�ڷ���ó�� ���� 
		String str2 = new String("HAPPY"); //������ �̰� �⺻��
		System.out.println(str1);
		System.out.println(str2);
		
	}

}