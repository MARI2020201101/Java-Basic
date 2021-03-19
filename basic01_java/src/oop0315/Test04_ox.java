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
		         ** ������ **
		====================================
		��ȣ �̸�    1  2  3  4  5  ����  ���      
		------------------------------------    
		1   ȫ�浿  O  X  O  O  O   80   2    
		2   ����ȭ  O  O  O  O  O  100   1
		3   ���϶�  X  X  X  X  O   20   5
		4   ���޷�  X  O  X  O  O   60   3
		5   ����ȭ  O  O  X  X  X   40   4
		------------------------------------    
		
		- �������� O , Ʋ������ Xǥ��
		- ����: O�� 20����
		- ���: ������ �������� ��������� 1��
		*/
		
		Jumsu student = new Jumsu(1,"ȫ�浿",3,4,3,3,3);
		student.compute();
		calcRank(student);
		student.disp();
		System.out.println("------------------------");
		Jumsu[] students = {
				new Jumsu(1,"ȫ�浿",3,4,3,3,3),
				new Jumsu(2,"����ȭ",3,3,3,3,3),
				new Jumsu(3,"���϶�",3,2,4,4,1),
				new Jumsu(4,"����ȭ",1,2,3,3,3),
				new Jumsu(5,"����ȭ",1,4,3,2,3)
			};
		
		for(int i =0; i <students.length ; i++) {
			students[i].compute();
		}
		calcRank(students);
		for(int i =0; i <students.length ; i++)
			students[i].disp();
		
		
		
	}

}