package oop0318;

class MyThread2 extends Thread{
	//Ŭ������ Ŭ������ ��ӹ޴� ��� ���� ��Ӹ� �����ϴ�. 
	private int num;
	private String name;
	public MyThread2() {}
	public MyThread2( int num, String name) {
		
		this.num = num;
		this.name = name;
	}

	public void run() {
		for(int i = 0; i<num; i++) {
			System.out.println(name + " : " + i);
		}
	}
	@Override
	public synchronized void start() {
		// TODO Auto-generated method stub
		super.start();
	}
}

public class Test09_Thread {
	//2)�����带 ����ϴ� ���
	//JVM�� ������ �����ڿ� ����ϰ�
	// -> start() �޼ҵ尡 run()�� ȣ���Ѵ�
	// -> ��) ä�����α׷�, �ǽð����� ( ���忡���� ������ �� �ְ�, ���ͳݿ����� ������)
	
	public static void main(String[] args) {
	MyThread2 m1 = new MyThread2(1000,"��");
	MyThread2 m2 = new MyThread2(1000,"�ڡ�");
	MyThread2 m3 = new MyThread2(1000,"�ڡڡ�");
	
	m1.start();
	m2.start();
	m3.start();
	
	
	}
}