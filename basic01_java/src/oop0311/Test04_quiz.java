package oop0311;

public class Test04_quiz {

	public static void main(String[] args) {
		int [] num = {7,8,-9,5,6};
		int size = num.length; //5
		
		//1) �迭����� ��ü ��
		int result = 0;
		for(int i =0;i<size; i++) {
			result +=num[i];	
		}System.out.println("��ü �� : "+result);
		
		//2) ������ ����
		int gae = 0;
		for(int n : num) {
			if(n<0) gae++;
		}System.out.println("������ ���� : "+ gae);
		
		//3) �ִ밪, �ּҰ�
		int large = 0;
		int small = 0;
		for(int i = 0; i<size; i++) {
			if(large<num[i]) {large = num[i];}
			if(small>num[i]) {small = num[i];}
		}System.out.printf("�ִ� : %d , �ּڰ� :  %d \n", large,small );
		
		int max = num[0];
		int min = num[0];
		//�迭��Ұ� ���� �����ϰ��, large���� 0�̵Ǵ� ���� �߻� ->�ʱⰪ��������!!
		
		//4)num[4]����� ����� ���Ͻÿ�
		int dun[] = new int[5];
		dun[0] = num[0];
		int temp = 0;
		//��� ���� : ū ������� desc
		//property�� �ΰ�. ù��°
		for(int i =0; i<size-1 ; i++) {
			for(int j=0;j<size;j++) {
				if(dun[i]<num[j]) {
					temp = dun[i];
					dun[i] = num[j];
					dun[i+1] =temp;
					}
			}
			
		}System.out.println(dun[0]);
		System.out.println(dun[1]);
		System.out.println(dun[2]);
		System.out.println(dun[3]);
		System.out.println(dun[4]);
		
		int r =1; // ���. ���� �з���
		for(int i=0; i<size; i++) {
			if(num[4]<num[i]) {
				r++;
			}
		
		}System.out.println(r+"���Դϴ�.");
		
		//5) ������ ��� ���ϱ�
		int[] rank = {1,1,1,1,1};
		for(int i =0 ; i<size; i++) {
			for(int j=0; j<size ; j++) {
				if(num[i]<num[j]) {
					rank[i]=rank[i]+1;
				}
			}
	
		}
		for(int i=0;i<size;i++) {
			System.out.println(num[i]+"����� : "+rank[i]);
		
		}
	}
}

