package oop0309;

public class Test02_quiz {
	public static void main(String[] args) {
		//문1) 임의의 정수가 짝수인지 확인하시오
		int num = 1;
		if(num%2!=0) {
			System.out.println(num +" 은 홀수입니다");
		}else System.out.println(num +" 은 짝수입니다");
			
		
		//문2) 임의의 정수가 3의 배수인지 확인하시오
		if(num%3==0) {
			System.out.println(num +" 은 3의 배수입니다");
		}else System.out.println(num +" 은 3의 배수가 아닙니다");
		
		
		//문3) 해당 년도가 윤년인지 확인하시오
		int year = 2021;
		if(year%4==0){
			System.out.println(year + "년은 윤년입니다");
		}else System.out.println(year + "년은 윤년이 아닙니다");
		
		//문4) 지폐의 갯수를 구하시오
		int money=54320;
		/*
		   만원 5 장
		   천원 4 장
		   백원 3 장
		   십원 2 장		
		*/
		int result = 0;
		result += money/10000;
		//money= money%10000;
		result += (money-result*10000)/1000;
		System.out.println(money + "원 지폐의 개수 : " + result);
				

		//문5) 임의의 정수가 2의 배수이면서 5의 배수인지 확인하시오
		if(num%2==0 && num%5==0) System.out.println("2의 배수이면서 5의 배수입니다");
		else System.out.println(num +" 은 2와 5의 배수가 아닙니다");
		
		//문6) 국어점수가 80~89사이인지 확인하시오
		if(num>=80 && num<90) System.out.println("국어 점수가 80~89 사이입니다");
		else System.out.println("국어 점수가 80~89 사이가 아닙니다");
		
		//문7) 임의의 정수가 3 또는 4인지 확인하시오
		if(num==3 || num==4)System.out.println("3또는 4입니다");
		else System.out.println("3또는 4가 아닙니다");
		
		//문8) 임의의 문자가 'Y' 또는 'y'인지 확인하시오
		char ch = 'a';
		if(ch =='Y' || ch=='y')System.out.println("Y 또는 y입니다.");
		else System.out.println("Y 또는 y가 아닙니다");
	}
	}

