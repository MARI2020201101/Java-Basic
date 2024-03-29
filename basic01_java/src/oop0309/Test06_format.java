package oop0309;

public class Test06_format {

	public static void main(String[] args) {
		//출력서식
		//\n:줄바꿈
		//\t:탭
		System.out.println("사과\n\n수박참외\n");
		System.out.println("바\t나\t\t나");
		
		//%d 10진정수형decimal f 실수형float c문자형 s문자열형
		System.out.printf("a:%d b:%d c:%d\n",3,5,7);
		System.out.printf("#%5d#\n",123);//전체 5칸
		System.out.printf("#%-5d#\n",123);
		System.out.printf("#%05d#\n",123);
		
		System.out.printf("이름 : %s\n", "mari");
		
		System.out.printf("x:%f y:%f z:%f\n", 1.2,3.4,5.6);
		System.out.printf("#%6.2f#\n",7.8);//전체 6자리 중 2자리는 소수점
		System.out.printf("#%-6.2f#\n",7.8);
		System.out.printf("#%6.2f#\n",7.8);
		
		System.out.println(String.format("%.4f", 10/3.0));
		
		System.out.printf("%c %c %c\n", 'S','K','Y');
		System.out.printf("#%5c#\n",'R');
		System.out.printf("#%-5c#\n",'r');
		
		System.out.printf("%s %s %s\n","Year","Month","Date");
		System.out.printf("#%8s#\n","Happy");
		System.out.printf("#%-8s#\n","Happy");
		
		
		
	}
}
