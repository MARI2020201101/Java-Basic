package oop0318;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test06_SetMap {
	public static void main(String[] args) {
		Set set = new HashSet();
		set.add(3);
		set.add(2.4);
		set.add("BUSAN");
		set.add('R');
		Iterator li = set.iterator();
		 while(li.hasNext()) {
			 System.out.println(li.next());
		 }//���� ������� ���´�
		 //iterator -> Ŀ��( C������ �����Ͷ���� ��) �� �̿��ؼ� �����ϴ� ��� 
		 
		 HashMap<Integer, String> map = new HashMap();
		 map.put(1, "one");
		 map.put(2, "two");
		 map.put(3, "three");
		 map.put(4, "four");
		 
		 System.out.println(map.get(1));
		 System.out.println(map.get(2));
		 System.out.println(map.get(3));
		 System.out.println(map.get(4));
		 System.out.println(map.size());
		 map.remove(4);
		 System.out.println(map.size());
		 //JSON�� �����Ҷ� ���� ��!!!
		 //NoSQL DB�� �̷������� ���
		 //python ���� -> �ڹ��� map �� ��ųʸ���
		 
		 //����)
		 /* = �������� ���� �и��ؼ�
		  * = ���� ���ڿ��� key
		  * = ���� ���ڿ��� value �� ����
		  * 
		  * key ���� �߿��� read.do ȣ���ϸ�
		  * value ���� ��������
		  */
		
		 System.out.println("------------------");
		 HashSet command=new HashSet();
		    command.add("list.do=net.bbs.List");
		    command.add("read.do=net.bbs.Read");
		    command.add("write.do=net.bbs.Write");
		    
		 Iterator li2 = command.iterator();//���. �и�. for�� ���� �ϰ�
		 // ���� �迭�� �����ؼ�
		 // ���� map�� ����
		 List<String> list = new ArrayList(); 
		 while(li2.hasNext()) {
			 list.add((String) li2.next());
		 }
		 Map<String,String> map2 = new HashMap<>();
		 for(String s : list) {
			String[] slist = s.split("=");
			map2.put(slist[0],slist[1]);
		 }
		 System.out.println(map2.get("read.do"));
		 
		 
	}
	
}