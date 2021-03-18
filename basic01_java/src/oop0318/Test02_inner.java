package oop0318;

import oop0318.WebProgram.Language;
import oop0318.WebProgram.Smart;

class WebProgram{
	String title = "Java Program";
	
	class Language{
		String basic ="JAVA, HTML, CSS, Javascript";
		void display() {
			System.out.println("기초수업 : " + basic);
		}
	}
	
	class Smart {
		String basic ="Objectice - C, Java OOP, C#";
		void display() {
			System.out.println("기초수업 : "+ basic);
		}
	}
	
	public void print() {
		Language lan = new Language();
		Smart smart = new Smart();
		lan.display();
		smart.display();
		
	}
}

public class Test02_inner {
//클래스 내부에 선언된 클래스
	
	public static void main(String[] args) {
		WebProgram web = new WebProgram();
		web.print();
		//메소드 안에서 내부객체 생성했음
		
		//내부 클래스를 어떻게 부르는가??
		//Language lan = new Language();불가! 직접접근이 안된당
		
		//대신 외부에서 단계적으로 접근하기
		Language lang = new WebProgram().new Language();
		lang.display();
		
		Smart sm = new WebProgram().new Smart();
		sm.display();
		
		/*
		 * java 오픈소스 
		 * 라이센스 x
		 * 
		 * 안드로이드( 구글사에서 만든 모바일 전용 OS) => GO (구글에서 만든 언어) ..but 시장장악력은 글쎼
		 * class R{
		 * 	class id{
		 * 		String button ="button";
		 * }} : R먼저 접근해서 -> id클래스에 접근
		 * 내가직접 코딩할 일은 별로 없지만 사용할 수는 있어야함!!
		 * 	접근 ->  R.id
		 */
	}
}
