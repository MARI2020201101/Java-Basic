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
	//����) str���ڿ��߿��� ������ ������ ���Ͻÿ�
	//		����: A,E,I,O,U,a,e,i,o,u
	String str ="Apple,Orange,Melon";
	MoCounter moCounter = new MoCounter();
	int result = moCounter.moCount(str);
	System.out.println(str + "�߿��� ������ ���� : " + result);
}
}
