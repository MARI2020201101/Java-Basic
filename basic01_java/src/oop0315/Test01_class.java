package oop0315; //현재 클래스의 저장위치

public class Test01_class {
	


	public static void main(String[] args) {
		//access Modifier 접근제어
		/*
		 * private 비공개.클래스 내부에서만 접근. 은폐할 수 있다
		 * package 아무것도 안씀. 현재 패키지(oop0315) 내에서만 접근가능
		 * protected 상속관계에 있는 클래스가 다른 팩키지에 있는 경우에도 접근가능
		 * public 
		 * 
		 */
		
		/*
		 * <RAM메모리 공간: static, heap, stack>
		 * 램은 주소값으로 데이터에 접근한다
		 * 
		 *--------------------------------------
		 * 1) new 연산자 . 참조변수 
		 * 클래스를 사용하려면 메모리를 할당하고 사용한다
		 * RAM(Random Access Memory) 의 heap 영역에 메모리가 할당되고 
		 * 주소값이 생긴다. 주소(reference)값이 있다 = Object , 객체이다
		 * 
		 * 2) stack 공간의 int -> 값만있음 call by value
		 * 	  stack 공간의 sungjuk -> 주소값이 있음. 주소값으로 heap을 찾아간다
		 * 							 call by reference
		 */
		class Sungjuk{
			//package 생략되어있음
			//package class : Sungjuk
			//클래스명의 첫글자는 대문자로. 
			
			//멤버변수 field
			public String name;
			int kor,eng,mat;
			private int aver;
			
			private void view() {}
			int calc() {
				int result = (kor+eng+mat)/3;
				
				this.aver = result;
				return result;
				
			}
			public void disp() {}
		
		}	
		Sungjuk sj = new Sungjuk(); 
		sj.name="손흥민";
		sj.kor = 100;
		sj.eng = 90;
		sj.mat = 100;
		int result = sj.calc();
		System.out.println("aver result :" + result);
		
		//객체지향 문법의 특징
		//캡슐화 한다. 캡슐을 뾱 열면 이름도 나오구 성적두 나오구~~ 작은 알갱이들이 숑숑숑
		//정보를 은닉할 수도 있고 캡슐화할수도 있다.
		//데이타에 접근하기 위해서는 - 그 주소값만 알면 되는 것이다!!
		Sungjuk sj2 = new Sungjuk(); // heap에 메모리 할당. 주소값 발생
		sj2.name = "박지성";
		sj2.kor =70;
		sj2.eng = 100;
		sj2.mat = 90;
		int result2 = sj.calc();
		System.out.printf("\n%s 님의 평균 성적 : %d\n", sj2.name, result2 );
		System.out.println(sj.hashCode());
		System.out.println(sj2.hashCode());
		
		Sungjuk tmp = sj2;
		System.out.println(sj2);
		System.out.println(tmp);
		System.out.println(tmp.hashCode());
	}
}