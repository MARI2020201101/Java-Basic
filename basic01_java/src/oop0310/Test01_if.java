package oop0310;

public class Test01_if {
	public static void main(String[] args) {
		
		String name ="maru";
		int kor =100, eng=100, mat=60;
		
		int aver = (kor+eng+mat)/3;
		System.out.printf("�̸� : %s\n" , name);
		System.out.printf("���� : %d\n" , kor);
		System.out.printf("���� : %d\n" , eng);
		System.out.printf("���� : %d\n" , mat);
		System.out.printf("��� : %d\n" , aver);
		
		//����1) ����� 95�̻� - ���л�
		if(aver>=95)System.out.printf("%s\t���� ���л��Դϴ�.\n",name);
		else System.out.printf("%s\t���� ���л��� �ƴմϴ�.\n",name);
		//����2) ��� 70�̻� - �հ� 
		if(kor>=70)System.out.printf("%s ������ �հ��Դϴ�.\n","����");
		else System.out.printf("%s ������ ���հ��Դϴ�.\n","����");
		//����3) ������ 90�̻� -A, 80�̻� - B,70�̻� - C, 60�̻� - D,������ F
		if(mat>=90)System.out.printf("%s ������ %c�Դϴ�. \n","����",'A');
		else if(mat>=80)System.out.printf("%s ������ %c�Դϴ�. \n","����",'B');
		else if(mat>=70)System.out.printf("%s ������ %c�Դϴ�. \n","����",'C');
		else if(mat>=60)System.out.printf("%s ������ %c�Դϴ�. \n","����",'D');
		else System.out.printf("%s ������ %c�Դϴ�. \n","����",'F');
		
		//����4)���� ���70�̻� : �հ�,
		//�� ������ �������� �Ѱ����̶� 40�̸��̸� �����
		//��� 70�̸� : ���հ�
		if(kor<40||mat<40||eng<40)System.out.println("������Դϴ�.");
		else if(aver>=70)System.out.println("�հ��Դϴ�.");
		else System.out.println("���հ��Դϴ�.");
	}
	

}