package oop0319;

import java.io.FileWriter;
import java.io.PrintWriter;

public class Test05_output {
	public static void main(String[] args) {
		String filename ="C:\\java202102\\setup\\sungjuk.txt";
		//���� �о���϶��� ������ null�̸� -> exception �׷��� ����� �� �ٸ���!!
		
		//������� (sungjuk.txt) �� 
		//���� ��� -> new ! 
		//�ִ� ��� -> ����� OR �߰�
		
		try {
			//append => true
			FileWriter fw = new FileWriter(filename, false);
			
			//autoFlush => true
			//buffer : �����͵��� �Դٰ��� �ϴ� ���. 
			//�ٸ� �����͵��� �Դٰ����Ҷ� �� ������. flush�ؼ� �� û���ϰ� ����
			PrintWriter out = new PrintWriter(fw, true);
			out.println("����ȭ,95,90,100");
			out.println("ȫ�浿,100,100,100");
			out.println("���϶�,90,95,100");
			out.println("������,85,70,75");
			out.println("���޷�,35,40,60");
			
			System.out.println("sungjuk.txt �ϼ�!");
			out.close();
			fw.close();
		}catch(Exception e) {
			System.out.println("���� : " + e.getMessage());
		}
 	}

}
