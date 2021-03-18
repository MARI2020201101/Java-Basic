package oop0318;

class Test{
	//1) try ~catch 직접이용한 예외처리
	public void view() {
		try {
			int a = Integer.parseInt("korea");
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	//2) throw 를 이용한 예외처리
	public void disp() throws Exception{
		System.out.println(1/0);
	}
	
	public void doSomething() throws NullPointerException, NumberFormatException{
		int a = Integer.parseInt("korea");
		System.out.println(a);
	}
	//OS가 개입해서 문제가 발생하지 않도록 조정하는 기법 
	//에에 그게 가능해??? 세상에.......
	//공유가 많이 일어나는 함수 ( user에게 많이 사용되는 함수 - 서버가 못버텨서 에러발생)
	//동시호출 막는다. 쓰고있으면 lock 해버림
	public synchronized void login() {
		
	}
	
}

public class Test04_throws {

	public static void main(String[] args) {
		// 예외를 던진다
		//-> 메소드 호출 시 예외처리를 한꺼번에 모아서 처리한다
		Test t = new Test();
		
		try{t.disp();
		t.doSomething();}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	

}
