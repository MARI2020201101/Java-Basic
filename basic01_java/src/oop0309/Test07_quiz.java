package oop0309;

public class Test07_quiz {
public static void main(String[] args) {
	//연습문제
	//1년:365.2422222..
	//출력결과: 365일 5시간 48분 46초
	//1분:60초. 1시간 : 60분*60초 . 1일 : 24*60*60
	//1년 : 365*24*60*60
	
	/*
	 * double day = 365.2422222; int result = (int)(day*24*60*60);
	 * System.out.println("1년은 "+result+"초이다"); System.out.println(day%365);//1일 안되는
	 * 시간 System.out.println((int)(day%365*24));//5시간
	 * 
	 * System.out.println(day%365*24*60); result /=60; System.out.println("1년은 "
	 * +result +"분이다"); result /= 60; System.out.println("1년은 " +result +"시간이다");
	 */
	
	double year =365.2422;
	int total = (int)(year*24*60*60);//초로변환
	
	int day = total/(24*60*60);
	System.out.printf("%d일",day);
	
	total%= (24*60*60);
	int hour = total/3600;
	System.out.printf("\n %d시간",hour);
	
	int second= total%60;
	System.out.printf("\n %d초",second);
	
	
	
	
}
}
