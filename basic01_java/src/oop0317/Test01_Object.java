package oop0317;

class Jeju{

	@Override
	public String toString() {
		return "제주도";
	}
	}
class Suwon{
	private String id = "SOLDESK";
	private String pw = "1234";
	
	@Override
	public String toString() {
		return "수원 [id = "+ id +" , password = "+pw + "]";
	}
	//toString : 에러 잡는 용도로 많이 사용. 내가 전달한 값이 잘 들어가는지
}
class Inchon{
	private String name = "인천광역시";
	private String phone = "5678";
	@Override
	public String toString() {
		return "Inchon [name=" + name + ", phone=" + phone + "]";
	}
	
}

public class Test01_Object {

	public static void main(String[] args) {
//자바의 모든 클래스는 무조건 object 클래스를 상속받는다
		Suwon sw = new Suwon();
		Jeju j = new Jeju();
		System.out.println(sw);
		System.out.println(j);
	}

}
