package oop0318;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Test05_List {
//Java Collections Framework
	
	/*배열 [] : 자료를 모아놓을 수 있다
	 * 
	 * 1 ) List : 배열과 유사. 인덱스는 0부터 시작 
	 * 	List<E> E: element 의 약자
	 * 	List, Vector, ArrayList ~~...
	 * 
	 * 2 ) Set : 순서가 없다
	 * 	HashSet, EnumSet...
	 * 
	 * 3 ) Map : 순서가 없다. 키와 밸류로 구성
	 * 	Map<K,V> key 와 value
	 * 	HashMap, HashTable, Map, Properties... 
	 */
	// E, K, V..이런 약자들은 전부 제네릭을 뜻함
	
	/*
	 * class ArrayList implements List{}
	 * class HashSet implements Set{}
	 * class HashMap implements Map{}
	 * class HashTable implements Map{}
	 * class Properties implements Map{}
	 */
	public static void main(String[] args) {
		List vector = new Vector();
		String a = "a";
		String b = "b";
		int c = 3;
		vector.add(a);
		vector.add(b);
		vector.add(c);
		System.out.println(vector.get(2));
		System.out.println("-----------");
		for(int i =0 ;i<vector.size(); i++ )System.out.println(vector.get(i));
		System.out.println("-----------");
		
		List list = new ArrayList<>();
		//문제) removed()이용해서 list전부 삭제
		list.add(5);
		list.add(6.7);
		list.add('r');
		
		System.out.println(list.size());
		for(int i=0 ; i<list.size(); i++) {
			list.remove(i);
		}
		
		//위에서부터지우면 인덱스가 틀어지게되기 때문에 아래서부터 지워야 함!
		if(list.isEmpty())System.out.println("제거되었습니다");
		else System.out.println("삭제 실패 : " + list.size());
		list.add(5);
		list.add(6.7);
		list.add('r');
	
		System.out.println(list.size());
		list.clear();
		
		System.out.println(list.size()); //0
		list.add(5);
		list.add(6.7);
		list.add('r');
		for(int i =list.size()-1; i>=0 ; i--) list.remove(i);
		if(list.isEmpty())System.out.println("제거되었습니다");
		else System.out.println("삭제 실패 : " + list.size());
	}
	
}
