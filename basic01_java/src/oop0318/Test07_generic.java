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
	//Generic제네릭
	//E element를 수집하는 경우 자료형을 제한할 수 있다
	//E element K key V value <T> <?>
	//<참조자료형reference type>
	
	//int형만 들어갈수있는 배열
	int[] intList = new int[3];
	
	//String만 들어갈 수있는 arraylist. List<E> -> E를 String 으로 제한
	List<String> list = new ArrayList<>(); 
	
	list.add("개나리");
	//list.add(3); err-
	
	Mountain m1 = new Mountain("한라산",1950);
	Mountain m2 = new Mountain("관악산",1050);
	Mountain m3 = new Mountain("북한산",1500);
	
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
