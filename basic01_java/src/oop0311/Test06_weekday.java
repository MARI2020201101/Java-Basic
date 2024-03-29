package oop0311;

public class Test06_weekday {

	public static void main(String[] args) {
		//요일 구하는 프로그램
		
		int cYear=2021,cMonth=3,cDate=11;
		String[] yoyil = {"일","월", "화", "수", "목", "금", "토"};
		//1년은 365일이라고 가정
		//서기 1년1월1일~2021년3월11일(목)
		// 365*2021 + (31+28+31) + 11
	
		//총 날수 % 7 => 0일 1월 2화 3수 4목 5금 6토
		/*
		 * 1단계 -> 서기 1년~ 서기 2020년
		 * 윤년 +=366
		 * 평년 +=365
		 * year/4==0 then 366
		 * 
		 */
		int hap = 0;
		for(int i=1; i<cYear ; i++) {
			if(i%4==0 && i%100!=0|| i%400==0) {
				hap+=366;
			}else hap +=365;
		}
		
/*		for(int m = 1 ; m<cMonth ; m++) {
			if(m%2!=0 || m==8) hap+=31;
			else if(m==2 && cYear%4!=0) hap+=28;
			else if(m==2 && cYear==0) hap +=29;
			else hap+=30;
		}System.out.println(hap);*/
		
		
		int[] mon= {0, 31,28,31,30,31,30,31,31,30,31,30,31};
		if(cYear%4==0 && cYear%100!=0|| cYear%400==0) {
			mon[1]++;
		}
		for(int i = 0; i<cMonth;i++) {
			hap+=mon[i];
		}
		
		hap+=cDate;
		System.out.println(hap);
		
		int y = hap%7;
		System.out.println(yoyil[y]+"요일");
	}

}
