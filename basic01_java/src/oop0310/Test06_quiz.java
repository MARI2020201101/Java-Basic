package oop0310;

public class Test06_quiz {
	public static void main(String[] args) {
		//문제1) 1~3까지 누적의 합을 구하시오
		int total = 0;
		for(int a =1 ;a <4; a++) {
			total+=a;
		}System.out.println("누적의 합 : " +total);
		//문제2) 1~5중에서 짝수의 갯수를 구하시오
		int gae =0;
		for(int num = 1; num<6;num++ ) {
			if(num%2==0)
				gae++;
		}System.out.println("짝수의 갯수는 " + gae +"개");
		
		//문제3)4팩토리얼 값을 구하시오.(4*3*2*1)
		int fac = 1;
		for(int i=1 ; i<5 ;i++) {
			fac*=i;
		}
		System.out.println("4팩토리얼 값은 " + fac +"입니다.");
		//문제4)1~100사이 중에서 짝수의 합/홀수의 합을 각각 구하시오
		int hol = 0;
		int chac = 0;
		for(int i = 0 ; i<=100;i++) {
			if(i%2!=0) hol+=i;
			else chac +=i;
		}System.out.println("홀수의 합은 : "+ hol +" ,짝수의 합은 : " +chac);
		
		//+) boolean 값의 활용
		boolean flag = false;
		int odd = 0;
		int even =0;
		for(int a=1;a<=100 ; a++) {
			if(flag!=true) {
				odd+=a;
				flag=true;
			}else {
				even +=a;
				flag=false;
			}
		}System.out.println("홀수의 합은 : "+ odd +" ,짝수의 합은 : " +even);
		
		//문제5)x값이 10으로부터 x를 여러번뺀후 결과가 음수가 되면 x를 뺀 횟수를 구하시오.
		int x =3;
		int su = 0;
		int num1 = 10;
		while(num1>0) {
			num1=num1-x;
			su++;
		}System.out.println("10을 뺀 횟수는 "+ su+" 입니다");
	}

}
