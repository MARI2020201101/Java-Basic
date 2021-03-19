package oop0318;

//idle 타임 (비는 시간. 놀고있는 시간~)
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
	//thread를 통해 하나의 프로그램이나 하나의 메소드가 CPU자원을 독점하는 것을 막을 수 있다
	//순차적 실행 을 하되, 중간중간에 다른애가 들어갈수있는 공간을 만들어조

	//ex) 채팅 프로그램 : 쓰레드없이는 불가능!!
	//다른사람이 글을 치고있는 도중에도 - 내가 글을 쳐서 올릴수있다
	//명령어 마무리(엔터) 치기 전에 다른사람 글 처리해주기
	//1번사람 것 먼저 처리해주는 것이 아니당

	//1) 쓰레드를 사용하지 않은 경우
	MyThread1 t1 = new MyThread1(100,"★");
	MyThread1 t2 = new MyThread1(100,"★☆");
	MyThread1 t3 = new MyThread1(100,"★☆★");
	
	t1.start();
	t2.start();
	t3.start();
}
}
