package oop0318;

interface IMessage{
	public void msgPrint();//미완성 메소드 
	//new 할수없다. 텅비어있기 때문
}
class Message implements IMessage{
	@Override
	public void msgPrint() {
		System.out.println("Message class...");
	}
}

//추상메소드로만 구성된 것 = 인터페이스 implements.
//추상메소드 + 일반메소드 섞인것 = 추상클래스
public class Test01_anonymous {
public static void main(String[] args) {
	
	//1) 구현클래스
	Message m1 = new Message();
	m1.msgPrint();
	
	//2) 다형성
	IMessage m = new Message();
	m.msgPrint();
	
	//3) 익명객체
	//이벤트가 발생했을 때 - 일시적으로 실행
	//미완성 메소드 => 구현해서 해결해주기
	//키보드 누르는 순간. 키보드 꽉 눌렀을 때. 키보드 뗐을 때..
	//자바스크립트 & jQuery에서 필수
	//$("button").click(){}
	IMessage mess = new IMessage() {
		@Override
		public void msgPrint() {
			System.out.println("익명객체프린팅");
		}
	};
	mess.msgPrint();
	
	
}
}
