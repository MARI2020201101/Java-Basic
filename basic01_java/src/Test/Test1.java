package Test;

public class Test1 {
	static int x=5;
	static int y=0;
	static int z=0;
	
	public static void main(String[] args) {
		
		y=x++;
		System.out.println("x : "+x);
		System.out.println("y : "+y);
		
		z=--x;
		System.out.println("x : "+x);
		System.out.println("z : "+z);
	}
}
