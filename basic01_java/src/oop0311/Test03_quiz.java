package oop0311;

import java.util.ArrayList;

public class Test03_quiz {

	public static void main(String[] args) {
		char[] ch = {'S','o','l','D','e','s','k'};
		//문제) 대문자는 소문자로, 소문자는 대문자로+각각 개수
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
		System.out.println("대소문자변환: " + charList);
		System.out.printf("대문자 개수 : %d, 소문자 개수 : %d\n" , bigNum,smallNum);
		
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
		
		
		//문제2)모음의 갯수를 구하시오(A E I O U a e i o u)
		int gae = 0;
		char[] charList2 = {'A', 'E','I' ,'O', 'U', 'a', 'e', 'i', 'o', 'u'};
		
		//전체 알파벳 A부터 z까지
		
		for(int i='A'; i<='z' ;i++) {
			char testch =(char) i;
			for(char ch2 : charList2) {
				if(ch2==testch) {
					gae++;
				}
			}
		}System.out.println("모음의 개수는 " + gae+"개입니다.");
	}

}
