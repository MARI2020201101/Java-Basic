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
		//3) Runnable 인터페이스를 이용한 경우
		/*
		 * interface Runnable -> Thread가 상속함
		 * 다중상속안되니까 그럴때는 Runnable을 implements해서 사용하기!
		 */
		
		
		MyThread3 m1 = new MyThread3(1000,"★");
		MyThread3 m2 = new MyThread3(1000,"★★");
		MyThread3 m3 = new MyThread3(1000,"★★★");
		
		//그냥 run() 부르면 x .. synchronized가 아님 ㅜㅜ
		Thread t1 = new Thread(m1);
		t1.start();
		Thread t2 = new Thread(m2);
		t2.start();
		Thread t3 = new Thread(m3);
		t3.start();
		
		Thread t4 = new Thread(new MyThread3(1000,"☆"));
		t4.start();
		
		//쓰레드 -> 중간중간에 낑겨들어갈수있게 해준다!!
		

		
	}
}
