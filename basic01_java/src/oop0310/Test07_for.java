package oop0310;

public class Test07_for {

	public static void main(String[] args) {
		//��1) �� �� ������ ���� ���Ͻÿ�
		// 2+3+4+5
		// 5+4+3+2
		int start = 5;
		int end =2;
		int total = 0;
		for(int i = 2; i<=5 ; i++) {
			total+=i;	
		}System.out.println("total: "+ total);
		
		
		//��2) ���� ���� ����� ���Ͻÿ�
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
		
		//��3) ��� �����̴� ������ 3cm�ö󰡰�, �㿡�� 2.5cm �����´ٰ� �Ҷ�
		//    �����̰� 13cm�� ���� ����⿡ �ö󰡷��� ��ĥ�� �ɸ����� ���Ͻÿ�
		int day =0;
		double cm = 0.5;
		double namu = 13.0;
		for(int i=1 ; namu-cm>0; i++) {
			day++;
			namu = namu-cm;
		}System.out.println("day : "+ day+ "�� �ɸ��ϴ�.");
		
		
		
        //��4)2g, 3g, 5g¥�� �߰� ���� 5���� ������
        //   �������� ���� �������� ���԰� 40~45������ ��
        //   �� ���� ������ ���Ը� ����ϴ� ���α׷�
        /*
              ��°��
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
						System.out.printf("%dg�� �� : 2g %d��, 3g %d��, 5g %d��\n",totalg,num2g,num3g,num5g);
				}
				
			}
			
		}
	}

}
