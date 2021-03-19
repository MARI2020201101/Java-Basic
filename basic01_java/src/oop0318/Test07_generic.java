package oop0318;

import java.util.ArrayList;
import java.util.List;

class Mountain{
	String name;
	int height;
	Mountain(){}
	public Mountain(String name, int height) {
		super();
		this.name = name;
		this.height = height;
	}
	
}

public class Test07_generic {
public static void main(String[] args) {
	//Generic���׸�
	//E element�� �����ϴ� ��� �ڷ����� ������ �� �ִ�
	//E element K key V value <T> <?>
	//<�����ڷ���reference type>
	
	//int���� �����ִ� �迭
	int[] intList = new int[3];
	
	//String�� �� ���ִ� arraylist. List<E> -> E�� String ���� ����
	List<String> list = new ArrayList<>(); 
	
	list.add("������");
	//list.add(3); err-
	
	Mountain m1 = new Mountain("�Ѷ��",1950);
	Mountain m2 = new Mountain("���ǻ�",1050);
	Mountain m3 = new Mountain("���ѻ�",1500);
	
	ArrayList<Mountain> mountainList = new ArrayList<>();
	mountainList.add(m1);
	mountainList.add(m2);
	mountainList.add(m3);
	
	for(int i=0;i<mountainList.size();i++) {
		Mountain m = mountainList.get(i);
		System.out.println(m.name);
		System.out.println(m.height);
	}
	
}
}