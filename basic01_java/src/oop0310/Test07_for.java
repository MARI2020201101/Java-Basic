package oop0310;

public class Test07_for {

	public static void main(String[] args) {
		//문1) 두 수 사이의 합을 구하시오
		// 2+3+4+5
		// 5+4+3+2
		int start = 5;
		int end =2;
		int total = 0;
		for(int i = 2; i<=5 ; i++) {
			total+=i;	
		}System.out.println("total: "+ total);
		
		
		//문2) 다음 식의 결과를 구하시오
		//1-2+3-4+5...100
		boolean flag = false;
		int result = 1;
		int num = 1;
		for(int i =1 ; i<=100; i++) {
			
		if(flag!=true) {
			result = result - (i +1);
			flag = true;
			
		}else {
			result =result + (i +1);
			flag= false;
			
		}}System.out.println("result = "+ result);
		
		//문3) 어느 달팽이는 낮에는 3cm올라가고, 밤에는 2.5cm 내려온다고 할때
		//    달팽이가 13cm의 나무 꼭대기에 올라가려면 며칠이 걸리는지 구하시오
		int day =0;
		double cm = 0.5;
		double namu = 13.0;
		for(int i=1 ; namu-cm>0; i++) {
			day++;
			namu = namu-cm;
		}System.out.println("day : "+ day+ "일 걸립니다.");
		
		
		
        //문4)2g, 3g, 5g짜리 추가 각각 5개씩 있을때
        //   세가지의 추의 조합으로 무게가 40~45사이일 때
        //   각 추의 갯수와 무게를 출력하는 프로그램
        /*
              출력결과
              2g  3g  5g   total
              ------------------
              1   5   5    42    (2+15+25)
              2   4   5    41    (4+12+25)
              2   5   5    44    (4+15+25)
        */
		int num2g = 1;
		int num3g = 1;
		int num5g = 1;
		int totalg = 0;
		//totalg = (2*num2g) + (3*num3g) + (5*num5g)
		for(num2g =1 ; num2g <=5 ;num2g++) {
			for(num3g =1 ; num3g <=5 ;num3g++) {
				for(num5g =1 ; num5g <=5 ;num5g++) {
					totalg = (2*num2g) + (3*num3g) + (5*num5g);
					if(totalg>=40&&totalg<=45)
						System.out.printf("%dg일 때 : 2g %d개, 3g %d개, 5g %d개\n",totalg,num2g,num3g,num5g);
				}
				
			}
			
		}
	}

}
