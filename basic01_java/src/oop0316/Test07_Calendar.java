package oop0316;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class Test07_Calendar {

	public static void main(String[] args) {
		GregorianCalendar now = new GregorianCalendar();
		System.out.println(now.getFirstDayOfWeek());
		System.out.println(now.get(Calendar.YEAR));
		System.out.println(now.get(Calendar.MONTH));//0부터 세고있음
		System.out.println(now.get(Calendar.DAY_OF_WEEK));
		//1일 2 월~
		System.out.println(now.get(Calendar.DATE));
		//날짜 데이터의 연산이 가능
		//now.add(Calendar.YEAR, 3);
		System.out.println(now.get(Calendar.YEAR));
		//now.add(Calendar.MONTH, -5);
	
	//문제) 살아온 날 수 구하기
		
		GregorianCalendar birth = new GregorianCalendar(1997,1,29);
		GregorianCalendar today = new GregorianCalendar(2021,03,16);
		Long time = today.getTimeInMillis() -birth.getTimeInMillis() ;
		System.out.println("살아온 millisecond " + time);
		time/=1000; //초로 변환
		//하루 = 24 * 1 * 60 분 
		//1분 = 60 초
		//하루 = 24* 60 * 60
		time /= 24* 60 * 60;
		System.out.println("살아온 날 수 : "+ time);
	}

}
