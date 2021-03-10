package oop0310;

public class Test03_for {

	public static void main(String[] args) {
		for(int a=0;a<10;a++) {
			System.out.println(a+" java");
		}
		//유효범위 scope 
		//global variable (충돌시<) local variable
		//지역변수의 우선순위가 가장높다
		
		//4단 출력하기
		for(int i =1; i<10 ;i++) {
			System.out.printf("4*%d=%d\n",i,4*i);
		}

	}

}
