package oop0316;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class Test07_Calendar {

	public static void main(String[] args) {
		GregorianCalendar now = new GregorianCalendar();
		System.out.println(now.getFirstDayOfWeek());
		System.out.println(now.get(Calendar.YEAR));
		System.out.println(now.get(Calendar.MONTH));//0���� ��������
		System.out.println(now.get(Calendar.DAY_OF_WEEK));
		//1�� 2 ��~
		System.out.println(now.get(Calendar.DATE));
		//��¥ �������� ������ ����
		//now.add(Calendar.YEAR, 3);
		System.out.println(now.get(Calendar.YEAR));
		//now.add(Calendar.MONTH, -5);
	
	//����) ��ƿ� �� �� ���ϱ�
		
		GregorianCalendar birth = new GregorianCalendar(1997,1,29);
		GregorianCalendar today = new GregorianCalendar(2021,03,16);
		Long time = today.getTimeInMillis() -birth.getTimeInMillis() ;
		System.out.println("��ƿ� millisecond " + time);
		time/=1000; //�ʷ� ��ȯ
		//�Ϸ� = 24 * 1 * 60 �� 
		//1�� = 60 ��
		//�Ϸ� = 24* 60 * 60
		time /= 24* 60 * 60;
		System.out.println("��ƿ� �� �� : "+ time);
	}

}
