package oop0317;

class School{
	String name = "School";
	public School() {
		System.out.println("school...");
	}
	
}
class MiddleSchool extends School{
	String name ="middleschool";
	public MiddleSchool() {
		super(); // ����������. �θ��� ������ �Լ�ȣ�� 
		System.out.println("middle school...");
	}
}

class HighSchool extends School{

	String name ="HHHigh School";
	public HighSchool() {
		super(); //�θ��� ������ �Լ� ȣ�� 
		System.out.println("HighSchool...");
	}
	public void disp() {
		String name = "���� ����б�";
		System.out.println(name); //�������� 
		System.out.println(this.name); // ���̸�!
		System.out.println(super.name); // �θ�� �̸�!(private �ƴ϶� ������) 
	}
	
}

public class Test02_super {

	public static void main(String[] args) {
	MiddleSchool ms = new MiddleSchool();	
//��Ӱ��迡�� => �θ��� �������Լ��� ���� ȣ������ ������ ������ �Լ��� ȣ���Ѵ�
	HighSchool hs = new HighSchool();
	System.out.println("-------------");
	hs.disp();
	}

}
