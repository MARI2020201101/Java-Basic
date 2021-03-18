package oop0318;

import oop0318.WebProgram.Language;
import oop0318.WebProgram.Smart;

class WebProgram{
	String title = "Java Program";
	
	class Language{
		String basic ="JAVA, HTML, CSS, Javascript";
		void display() {
			System.out.println("���ʼ��� : " + basic);
		}
	}
	
	class Smart {
		String basic ="Objectice - C, Java OOP, C#";
		void display() {
			System.out.println("���ʼ��� : "+ basic);
		}
	}
	
	public void print() {
		Language lan = new Language();
		Smart smart = new Smart();
		lan.display();
		smart.display();
		
	}
}

public class Test02_inner {
//Ŭ���� ���ο� ����� Ŭ����
	
	public static void main(String[] args) {
		WebProgram web = new WebProgram();
		web.print();
		//�޼ҵ� �ȿ��� ���ΰ�ü ��������
		
		//���� Ŭ������ ��� �θ��°�??
		//Language lan = new Language();�Ұ�! ���������� �ȵȴ�
		
		//��� �ܺο��� �ܰ������� �����ϱ�
		Language lang = new WebProgram().new Language();
		lang.display();
		
		Smart sm = new WebProgram().new Smart();
		sm.display();
		
		/*
		 * java ���¼ҽ� 
		 * ���̼��� x
		 * 
		 * �ȵ���̵�( ���ۻ翡�� ���� ����� ���� OS) => GO (���ۿ��� ���� ���) ..but ������Ƿ��� �ۛ�
		 * class R{
		 * 	class id{
		 * 		String button ="button";
		 * }} : R���� �����ؼ� -> idŬ������ ����
		 * �������� �ڵ��� ���� ���� ������ ����� ���� �־����!!
		 * 	���� ->  R.id
		 */
	}
}
