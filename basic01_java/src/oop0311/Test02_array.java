package oop0311;

public class Test02_array {

	public static void main(String[] args) {
		int[][] kor = new int[2][3];
		kor[0][0] =10;
		kor[0][1] =20;
		kor[0][2] =30;
		kor[1][0] =40;
		kor[1][1] =50;
		kor[1][2] =70;
		
		System.out.println(kor.length); //행 갯수
		System.out.println(kor[0].length); //0번째 행의 열갯수
		System.out.println(kor[1].length);
		
		for(int row =0; row<2 ; row++) {
			for(int col = 0 ; col<3 ;col++) {
				System.out.println(kor[row][col]);
			}
		}
		
		int[][] kor2 = { 
				{10,20,30}
				,
				{40,50,60}
		};

		int row = kor2.length;
		for(int i=0; i<row; i++) {
			int col = kor[i].length;
			for(int j = 0 ; j<col; j++) {
				System.out.println(kor2[i][j]);
			}
		}
	}

}
