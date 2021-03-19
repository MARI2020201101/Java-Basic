package oop0316;

public class Test06_wrapper {

	public static void main(String[] args) {
		//Wrapper ���� Ŭ����
		//�⺻ �ڷ����� ������ ȭ (referenceȭ) �� ���� Ŭ������
		//��κ�  java.lang�� ����Ǿ�����
		/*
		 * ��κ� ù���ڸ� �빮�ڷ� �ٲٸ��
		 * boolean Boolean
		 * int Integer
		 * char Character
		 * double Double
		 * long Long 
		 * short Short
		 * byte Byte
		 * ...
		 * 
		 * JDK11�̻���ʹ� �⺻���� �Ȱ��� �������� ��������
		 */
	int in1 = 3;
	Integer in3 =8;
	System.out.println(in1);
	System.out.println(in3);
	
	System.out.println(in3.compareTo(in1));
	System.out.println(in3.doubleValue());
	
	System.out.println(Integer.toBinaryString(11));//2������ȯ
	System.out.println(Integer.parseInt("3"));
	
	System.out.println(Integer.max(2, in1));

	//����) �Ǽ��� �����߿��� ���������� ���Ͻÿ� -> 1+3+5
	long lo1= 3L;
	Double dou1 = 1.2;
	Double dou2 = 5.6;
	double dou3 = 3.4;
	int hap = 0;
	hap = dou1.intValue() + dou2.intValue()+ (int)dou3;
	System.out.println("hap :" + hap);
	
	char ch1= 'R';
	Character ch2 = 'r';
	System.out.println(ch1);
	System.out.println(ch2);
	System.out.println(Character.isWhitespace(ch1));
	System.out.println(Character.toLowerCase(ch1));
	System.out.println(Character.toUpperCase(ch2));
	
	
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	
	
	
	}
}