
package oop0310;


public class Test02_swith {
public static void main(String[] args) {
	
	switch("a") {
	case "a": System.out.println("SEOUL");break;
	case "b": System.out.println("BUSAN");break;
	case "c": System.out.println("JEJU");break;
	default : System.out.println("��Ÿ"); break;
	}
	
	//����1) ��տ� ���� abcdf�������
	int kor=10, eng=100,mat=100;
	int aver =(kor+eng+mat )/3;
	String result = "";
	if (aver>90) result = "A";
	else if(aver>80)result ="B";
	else if(aver>70)result = "C";
	else if(aver>70)result = "D";
	else result = "E";
	System.out.println("������ "+ result +"�Դϴ�");
	
	switch(aver/10) {
	case 10:result = "A+";break;
	case 9:result = "A";break;
	case 8:result = "B";break;
	case 7:result = "C";break;
	case 6:result = "D";break;
	default : result = "F";break;
	}System.out.println("������ "+ result +"�Դϴ�");
	
	//���� 2) �����ȣ(op)�� ���� ����� ���
	int i=5, j=7;
	char op ='+';
	/*
	 * ��°�� 5+3=8 5-3=2 5*3=15 5/3=0.7 5%3=2
	 */
	double res2=0.0;
	int res1 =0;
	switch(op){
		case'+' : res1=i+j; break; 
		case'-' : res1=i-j; break; 
		case'*' : res1=i*j; break; 
		case'/' : res2=i/j; break; 
		case'%' : res1=i%j; break; 
	}
	//��3) �ֹι�ȣ�� �̿��ؼ� ���̿� ���� ���
	//980101 
	//00������� ���ڸ� 3-4
	
	int firstNum = 2;
	int myYear= 98;
	int year = 21;
	int age = 0;
	String sex = "";
	if(firstNum<3){
		age = year + (100-myYear);
	}else {
		age = year - myYear;
	}System.out.println("age : "+age);
	if(firstNum%2!=0)sex = "��";
	else sex = "��";
	System.out.println("���� : "+ sex);
	
	switch(1) {
	case 1: 
	case 2: myYear = 1900+myYear;break;
	case 3: 
	case 4: myYear = 2000+myYear;break;
	}
	
}
}