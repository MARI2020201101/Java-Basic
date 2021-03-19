package oop0319;

import java.io.File;

public class Test02_File {
	//���� Ŭ���� : ���Ͽ� ���� ������ �����ϴ� Ŭ����
	//-> ���ϸ�, ����ũ��(�뷮) , Ȯ����ext ��
	
	public static void main(String[] args) {
		
	
		try {
			//�ڹٿ����� \�� ���ɾ��̱� ������ ��η� ������. �̰��� �����Դϴ�! ��� ǥ�÷� �ι�����
			//��θ� + ���ϸ�
			String pathname="C:\\java202102\\rabbit2.png";
			//�������� �׳� �ᵵ ��!
			//String pathname="C:/java202102/rabbit2.png";
			
			//FileŬ������ ���
			//uri�� ���� ���� �ִ�. ��, ������ �ִ� ������ �������� �͵� ������
			//���⼭�� �� ��ǻ�;��������� �ҷ������� �Ѵ�. 
			//������ �ҷ����� ���ؼ��� ������ ��� & ��� ������ �̸��� �ʿ��ϴ�
			File file = new File(pathname);
			if(file.exists()) {
				System.out.println("���� �־��~~");
				long filesize = file.length();
				System.out.println("���� ũ�� : " + filesize +"byte");
				System.out.println("���� ũ�� : " + filesize/1024 +"KB");
				String fileName = file.getName();
				System.out.println("���� �̸� : " + fileName);
				System.out.println("file.isDirectory() " + file.isDirectory());
				System.out.println("file.getPath() " + file.getPath());
				System.out.println("file.getAbsolutePath() " + file.getAbsolutePath());
			}else {
				System.out.println("���� �����!!");
			}
			
			
		}catch(Exception e) {
			System.out.println("���� �б� ���� :" + e.getMessage());
		}
	}
}