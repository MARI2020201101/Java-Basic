package oop0318;

class MyThread3 implements Runnable{

	private int num;
	private String name;

	public MyThread3() {
	}

	public MyThread3(int num, String name) {

		this.num = num;
		this.name = name;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < num; i++) {
			System.out.println(name + " : " + i);

		}
	}

}

public class Test10_Thread {
	
	
	public static void main(String[] args) {
		//3) Runnable �������̽��� �̿��� ���
		/*
		 * interface Runnable -> Thread�� �����
		 * ���߻�ӾȵǴϱ� �׷����� Runnable�� implements�ؼ� ����ϱ�!
		 */
		
		
		MyThread3 m1 = new MyThread3(1000,"��");
		MyThread3 m2 = new MyThread3(1000,"�ڡ�");
		MyThread3 m3 = new MyThread3(1000,"�ڡڡ�");
		
		//�׳� run() �θ��� x .. synchronized�� �ƴ� �̤�
		Thread t1 = new Thread(m1);
		t1.start();
		Thread t2 = new Thread(m2);
		t2.start();
		Thread t3 = new Thread(m3);
		t3.start();
		
		Thread t4 = new Thread(new MyThread3(1000,"��"));
		t4.start();
		
		//������ -> �߰��߰��� ���ܵ����ְ� ���ش�!!
		

		
	}
}