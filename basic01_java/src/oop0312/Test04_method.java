package oop0312;

import java.util.Arrays;
//java라고 하는 패키지 안에 util이라는 패키지 안에 Arrays라는 java클래스

public class Test04_method {
	
	public static void test1(int a, int b) {
		System.out.println("두 수의 합 " + (a+b));
	}
	
	public static void test2(int[] a) {
		for(int i=0 ; i<a.length; i++) {
			System.out.println(a[i]);
		}
	}
	public static void test3(String a, String b) {
		System.out.println(a);
		System.out.println(b);
		
	}
	public static void test4(String[] a) {
		for(String s : a)
		System.out.println("test4"+s);
	}
	public static void test5(int a, int b) {
		System.out.println("test5 " + (a+b));
	}
	public static void test6(int[][] a) {
		for(int i=0;i<a.length;i++) {
			for(int j=0; j<a[i].length;j++){
				System.out.print(a[i][j]+" ");
			}	
		}
	}
	
	
	

	public static void main(String[] args) {
		/*
		 * 함수 호출 방식
		 * 1) call by value(값으로 호출)
		 * 2) call by reference(주소로 호출) 
		 */
		int[] num = {10,20,30};
		test1(num[0],num[2]); //call by value
		test2(num); //배열을 통째로 넘긴다== 배열이 저장되어있는 주소값을 넘긴다
		
		String[] name = {"무궁화","진달래","개나리"};
		test3(name[0],name[2]);
		test4(name);
		
		int[][] su = {
				{1,3,5},
				{2,4,6}
		};
		test5(su[0][0],su[1][2]);
		test6(su);
		
		//과제) 소스 분석 하기
		//로또번호 1~45중에서 서로 겹치지 않게 6개 발생
		int[] lotto= new int[6];
		
		for(int a=0; a<6; a++) {
			lotto[a]=(int)(Math.random()*45)+1;
			for(int b = 0; b<a; b++) {
				if(lotto[a]==lotto[b]) {
					a--;
					break;
				}
			}
		}
		//정렬하기 sorting~~
		/*
		 * 정렬의 유형
		 * 1)ascending ASC 		1->10, A->z, ㄱ->ㅎ
		 * 2)descending DESC  	
		 * 
		 * 정렬의 방법
		 * 1) 삽입정렬 (insertion sort)
		 * 2) 선택정렬 (selection sort)
		 * 3) 버블정렬 (bubble sort)
		 * 
		 * 자바에는 정렬해주는 클래스가 내장되어있다
		 */
		int[] nums = {2,9,6,3,5};
		Arrays.sort(nums);
		Arrays.sort(lotto);
		System.out.print("\n--------\n");
		for(int i=0; i<nums.length; i++) {
			System.out.print(nums[i]);
		}
		System.out.println("\n--------\n");
		for(int i=0; i<lotto.length; i++) {	
			System.out.println(lotto[i]);
		}
		
		/*
		 * 선택정렬(selection sort)
		 * 9 7 5 3 -> 3 5 7 9
		 * 4! 만큼
		 * 
		 * 버블정렬(bubble sort)
		 * 옆에 애랑 비교해서 자리바꾸기
		 * sort 안되면 처음부터 다시 비교
		 */
		int[] s = {9,7,5,3};
		int tmp=0;
		for(int i =0 ; i<s.length; i++) {
			for(int j=0; j<s.length ; j++) {
				if(s[i]>s[j])
				tmp = s[i];
				s[i]= s[j];
				s[j]= tmp;
			}
		}System.out.println(s[0]);
		
		for(int ss : s)
		System.out.println(ss);
		
		
		
	}

}
