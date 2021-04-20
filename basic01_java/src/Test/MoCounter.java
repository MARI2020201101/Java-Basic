package Test;

public class MoCounter {

	public int moCount(String str) {
		String[] str2 = str.split("");
		String[] moum = {"A","E","I","O","U","a","e","i","o","u"};
		int result=0;
		for(String s : str2) {
			for(String m : moum) {
				if(s.equals(m)) {
					result++;
				}
			}
		}return result;
	}
	
public static void main(String[] args) {
	//문제) str문자열중에서 모음의 갯수를 구하시오
	//		모음: A,E,I,O,U,a,e,i,o,u
	String str ="Apple,Orange,Melon";
	MoCounter moCounter = new MoCounter();
	int result = moCounter.moCount(str);
	System.out.println(str + "중에서 모음의 갯수 : " + result);
}
}
