package oop0311;

import java.util.ArrayList;

public class Test03_quiz {

	public static void main(String[] args) {
		char[] ch = {'S','o','l','D','e','s','k'};
		//����) �빮�ڴ� �ҹ��ڷ�, �ҹ��ڴ� �빮�ڷ�+���� ����
		System.out.println((int) 'A'); //65,97
		System.out.println((int)'a');
		int bigNum = 0;
		int smallNum = 0;
		ArrayList<Character> charList = new ArrayList<>();
		for(char cha : ch ) {
			if(cha < 'a' ) {
				bigNum++;
				cha+=32;
			}else if(cha>='a'){
				smallNum++;
				cha-=32;
			}charList.add(cha);
		}
		System.out.println("��ҹ��ں�ȯ: " + charList);
		System.out.printf("�빮�� ���� : %d, �ҹ��� ���� : %d\n" , bigNum,smallNum);
		
		int upper = 0;
		int lower = 0;
		for(int i = 0 ; i<ch.length;i++ ) {
			if(ch[i]>='A'&& ch[i]<'a') {
				upper++;
				ch[i]+=('a'-'A');
			}else { lower++;
					ch[i]-=('a'-'A');}
			System.out.println(ch);
			
		}
		System.out.println(upper);
		System.out.println(lower);
		
		
		//����2)������ ������ ���Ͻÿ�(A E I O U a e i o u)
		int gae = 0;
		char[] charList2 = {'A', 'E','I' ,'O', 'U', 'a', 'e', 'i', 'o', 'u'};
		
		//��ü ���ĺ� A���� z����
		
		for(int i='A'; i<='z' ;i++) {
			char testch =(char) i;
			for(char ch2 : charList2) {
				if(ch2==testch) {
					gae++;
				}
			}
		}System.out.println("������ ������ " + gae+"���Դϴ�.");
	}

}