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
	//�������̽� ���� ����� ���߻���� ������!!!!Ŭ������ �ȵſ�. 
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
//Ŭ�������� ����� �Ѱ���. ������ ������ �����ϴ�
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
	//������ ���� �������鰣�� �������� �ʿ��Ҷ�. �������� �����ϱ� ���ؼ� 
	// ==> super interface�� �����!
	//�������� ǥ��ȭ�� ����������!
	//super interface�� ����ϴ� �ڽ�Ŭ������ ����� ���̴�. 
}
}
