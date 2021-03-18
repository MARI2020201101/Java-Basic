package oop0317;

class Unit{
	int currentHP;
	int x,y;
}
interface Movable{
	void move(int x, int y);
}
interface Attackable{
	void attack(Unit u);
}
interface Fightable extends Movable,Attackable{
	//인터페이스 간의 상속은 다중상속이 가능함!!!!클래스는 안돼욧. 
}
class Fight extends Unit implements Fightable{
	@Override
	public void attack(Unit u) {
		// TODO Auto-generated method stub
		
	}@Override
	public void move(int x, int y) {
		// TODO Auto-generated method stub
		
	}public Fight() {
		// TODO Auto-generated constructor stub
	}
}
//클래스간의 상속은 한개만. 구현은 여러개 가능하다
class Tetris extends Unit implements Movable, Attackable{
	@Override
	public void attack(Unit u) {
		// TODO Auto-generated method stub
		
	}@Override
	public void move(int x, int y) {
		// TODO Auto-generated method stub
		
	}public Tetris() {
		// TODO Auto-generated constructor stub
	}
}
public class Test09_interface {
public static void main(String[] args) {
	//무수히 많은 페이지들간의 공통점이 필요할때. 페이지를 관리하기 위해서 
	// ==> super interface를 만든다!
	//페이지의 표준화가 가능해진다!
	//super interface를 상속하는 자식클래스를 만드는 것이다. 
}
}
