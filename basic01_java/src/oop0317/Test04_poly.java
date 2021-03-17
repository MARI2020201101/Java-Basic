package oop0317;

class Father{
	public String name ="�ƹ���";
	public String addr = "�ּ�";
	
	public Father() {}
	public Father(String name, String addr) {
		this.addr = addr;
		this.name = name;
	}
	public void disp() {
		System.out.println(this.name);
		System.out.println(this.addr);
	}
}

class Son extends Father{
	public Son(String name, String addr) {
		super(name,addr);
	}
	public Son() {
		super();
	}
}

class Daughter extends Father{
	public String friend = "��ģ";
	public Daughter(String name, String addr) {
		super(name,addr);
	}
	public Daughter() {
		super();
	}
	
	
}
public class Test04_poly {

	public static void main(String[] args) {
		//�������� �� 
		//Calendar cal = new GregorianCalendar();
		
		//1) �Ϲ����� ������� ��ü ����
		// ->new ��� = POJO��� �̶�� �Ѵ� .
		//Plain Old Java Object
		
		Father fa = new Father();
		fa.disp();
		
		Son son = new Son("�����", "����");
		son.disp();
		
		//2) �������� �̿��� ��ü ����
		//-> �ڽ�Ŭ������ �θ�Ŭ������ ���� �����ϴ�
		//-> �θ�Ŭ������ ����� �ڽ�Ŭ������ ������� �ڽ��� ����� ��ȯ�Ѵ�
		
		Father father = new Son("������","��ö��");
		father.disp(); //�ڽ��� �̸����� �ٲپ� ������!!
		//������ �ս��� �߻����� �ʴ´�!! �θ�� ������ �ҷ�.
		
		//�������̽����� �������� �ڿ������� �� �ߵȴ�. 
		//�ڽ�Ŭ�������� �߰��� ����� �������� ��� X. �θ� �������� ( �̰� �ð�������..)
		Son son2 = new Son();
		Father fa2 = new Father();
		Daughter dau = new Daughter();
		fa2 = new Daughter(); 
		
		
		Object obj = new Son(); 
		Son son3 =(Son) new Object(); // �ڽ�Ŭ������ �θ�Ŭ������ ����

		Father fa3 = new Son();
		
		
		
	}

}
