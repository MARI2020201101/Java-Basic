package oop0315;

public class Test04_ox {
	
	public static void calcRank( Jumsu... student) {
		int ranks[] = {1,1,1,1,1};
		for(int i= 0; i<student.length ; i++) {
			for(int j=0 ; j<student.length ; j++) {
				if(student[i].getScore() > student[j].getScore()) {
					ranks[i]++;
				}
			}student[i].setRank(ranks[i]);
		}
		
	}

	public static void main(String[] args) {
				/*        
		         ** 시험결과 **
		====================================
		번호 이름    1  2  3  4  5  점수  등수      
		------------------------------------    
		1   홍길동  O  X  O  O  O   80   2    
		2   무궁화  O  O  O  O  O  100   1
		3   라일락  X  X  X  X  O   20   5
		4   진달래  X  O  X  O  O   60   3
		5   봉선화  O  O  X  X  X   40   4
		------------------------------------    
		
		- 맞힌문제 O , 틀린문제 X표시
		- 점수: O당 20점씩
		- 등수: 점수를 기준으로 높은사람이 1등
		*/
		
		Jumsu student = new Jumsu(1,"홍길동",3,4,3,3,3);
		student.compute();
		calcRank(student);
		student.disp();
		System.out.println("------------------------");
		Jumsu[] students = {
				new Jumsu(1,"홍길동",3,4,3,3,3),
				new Jumsu(2,"무궁화",3,3,3,3,3),
				new Jumsu(3,"라일락",3,2,4,4,1),
				new Jumsu(4,"수선화",1,2,3,3,3),
				new Jumsu(5,"봉선화",1,4,3,2,3)
			};
		
		for(int i =0; i <students.length ; i++) {
			students[i].compute();
		}
		calcRank(students);
		for(int i =0; i <students.length ; i++)
			students[i].disp();
		
		
		
	}

}
