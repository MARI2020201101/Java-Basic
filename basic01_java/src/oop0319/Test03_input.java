package oop0319;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Test03_input {
	//������ �о���̱� !
	//�޸��� ���� ���� �б�
	public static void main(String[] args) {
		//inputStream - outputStream
		//Reader - Writer
		//�а� ������ ¦�� ���ߴ°��� ����(������ �ս��� ����)
		
		/*
		 * ������ 1�� = 1byte 
		 * �ѱ� = �ּ� 2byte
		 * input, outputstream => 1byte ����
		 * Reader, Writer => 2byte����
		 * �׷��Ƿ� � I/O�� �������� ���빰�� ���� �����ϱ�!!
		 * 
		 * Character Ŭ���� -> �⺻ 2byte. �����ڵ� Character Ŭ������ ������ 2����Ʈ! 
		 */
		FileReader fr = null;
		BufferedReader br = null;
		BufferedReader br2 = null;
		try {
			String filename = "C:\\java202102\\workspace\\basic01_java\\src\\oop0319\\Test01_Buyer.java";
			String memoName = "C:\\java202102\\setup\\test.txt";
			
			//1) ������ ��������
			fr= new FileReader(filename);
			
			//2) ���� ������ �б�
			//BufferedReader : ������ ���پ� �о���̴� Ŀ��. iterator���� �༮
			br = new BufferedReader(fr);
			br2 = new BufferedReader(new  FileReader(memoName));
			int num = 0;
			while(true) {
				//3) ����(\n)�� �������� ���پ� ��������
				
				String line = br.readLine();
				if(line ==null) {
					break;
			}
				
				System.out.printf("%3d %s\n",++num,line);
			}
			
			System.out.println("---------------------------");
			while(true) {
				String memo = br.readLine();
				System.out.println(memo);
				if(memo ==null) {
					break;
				}
			}
			
			}catch(Exception e) {
			System.out.println("���� �б� ���� : " + e.getMessage());
		}finally {
			//�ڿ� �ݳ��ϱ�
			
			try {
				if(br!=null)
						br.close();
				if(br2 != null)
					br2.close();
				if(fr!= null)
					fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}