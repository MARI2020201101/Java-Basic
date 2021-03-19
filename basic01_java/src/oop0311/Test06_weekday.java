package oop0311;

public class Test06_weekday {

	public static void main(String[] args) {
		//���� ���ϴ� ���α׷�
		
		int cYear=2021,cMonth=3,cDate=11;
		String[] yoyil = {"��","��", "ȭ", "��", "��", "��", "��"};
		//1���� 365���̶�� ����
		//���� 1��1��1��~2021��3��11��(��)
		// 365*2021 + (31+28+31) + 11
	
		//�� ���� % 7 => 0�� 1�� 2ȭ 3�� 4�� 5�� 6��
		/*
		 * 1�ܰ� -> ���� 1��~ ���� 2020��
		 * ���� +=366
		 * ��� +=365
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
		System.out.println(yoyil[y]+"����");
	}

}