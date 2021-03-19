package oop0318;

//idle Ÿ�� (��� �ð�. ����ִ� �ð�~)
class MyThread1{
	private int num;
	private String name;
	public MyThread1() {}
	public MyThread1(int num, String name) {
		super();
		this.num = num;
		this.name = name;
	}
	public void start() {
		System.out.println("start()...");
		run();
	}
	public void run() {
		System.out.println("run()...");
		for(int a = 0; a<num; a++) {
			System.out.println(name + " : " + a);
		}
	}
}

public class Test08_Thread {
public static void main(String[] args) {
	//thread�� ���� �ϳ��� ���α׷��̳� �ϳ��� �޼ҵ尡 CPU�ڿ��� �����ϴ� ���� ���� �� �ִ�
	//������ ���� �� �ϵ�, �߰��߰��� �ٸ��ְ� �����ִ� ������ �������

	//ex) ä�� ���α׷� : ��������̴� �Ұ���!!
	//�ٸ������ ���� ġ���ִ� ���߿��� - ���� ���� �ļ� �ø����ִ�
	//��ɾ� ������(����) ġ�� ���� �ٸ���� �� ó�����ֱ�
	//1����� �� ���� ó�����ִ� ���� �ƴϴ�

	//1) �����带 ������� ���� ���
	MyThread1 t1 = new MyThread1(100,"��");
	MyThread1 t2 = new MyThread1(100,"�ڡ�");
	MyThread1 t3 = new MyThread1(100,"�ڡ١�");
	
	t1.start();
	t2.start();
	t3.start();
}
}
