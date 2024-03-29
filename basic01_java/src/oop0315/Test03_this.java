package oop0315;

public class Test03_this {

static class Score{
	private String name="손흥민";
	private int kor,eng,mat;
	private int aver;
	
	//기본생성자 : 수동으로 생성할 것을 추천( 에러 때문
	public Score() {}
	public Score(String name, int kor, int eng, int mat) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.aver = (kor+eng+mat)/3;
	}

	public void disp() {
		String name = "박지성";
		System.out.println("name :" + name);
		System.out.println("name :" + this.name);
		System.out.println("kor : "+kor);
		System.out.println("mat : "+mat);
		System.out.println("eng : "+eng);
		System.out.println("aver : "+aver);
		
	}
}
	public static void main(String[] args) {
		// this
		/*
		 * -> 클래스 본인을 가리키는 대명사
		 * -> 일반 지역변수와 멤버변수를 구분하기 위함
		 * 
		 * this()
		 * -> 자신의 생성자 함수간의 호출
		 * -> 저는요~~( 영례는요~~ 라구 말 안함.. 쑥스러서..//) 
		 */
		Score one = new Score();
		one.disp();
		System.out.println(one);
		System.out.println(one.toString());
		Score two = new Score("김연아",100,90,95);
		two.disp();
		System.out.println(two);
		two=null;
		System.out.println(two);
		
		/*Score kim= new Score("봉선화", 70,85,100);
		Score lee= new Score("라일락", 90,95,90);
		Score park= new Score("진달래", 60,45,90);*/
		
		//오브젝트도 배열이 올 수 있다. 
		Score[] score = new Score[] {
				new Score("봉선화", 70,85,100),
				new Score("라일락", 90,95,90),
				new Score("진달래", 60,45,90)
		};
	}
}
