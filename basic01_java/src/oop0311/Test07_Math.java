package oop0311;

import java.util.Random;

public class Test07_Math {

	public static void main(String[] args) {
		//절댓값(absolute value)
		System.out.println(Math.abs(3));
		System.out.println(Math.abs(-3));
		System.out.println(Math.abs(-2.4));
		
		//비교
		System.out.println(Math.max(3, 5.5));
		System.out.println(Math.min(-1, 0.7));

		System.out.println(Math.E);
		System.out.println(Math.PI);
		
		System.out.println(Math.ceil(1.3));//올림
		System.out.println(Math.floor(3.3));//버림
		System.out.println(Math.round(5.2));//반올림
		
		System.out.println(Math.floor(Math.random()*100));
		//발생 범위 : 0.0 <= r < 1.0
		System.out.println((int)(Math.random()*2));//0 1
		System.out.println((int)(Math.random()*6)); // 0 1 2 3 4 5
		
		//문제1) 주사위 수의 범위: 1~6발생시키기
		System.out.println((int)Math.ceil(Math.random()*6));
		//문제2) 로또번호 범위 : 1~45
		System.out.println((int)(Math.ceil(Math.random()*45)));
		//문제3) 로또번호 1~45중에서 서로 겹치지 않게 6개 발생시키기
		//안겹치게??
		System.out.println("---------------------------------");
		int[] nums = {0,0,0,0,0,0};
		for(int i =0 ; i<nums.length;i++)
			for(int j=0 ; j<nums.length;j++) {
				nums[i]= (int)Math.ceil(Math.random()*45);
				if(nums[i]==nums[j]) {
					nums[i]= (int)Math.ceil(Math.random()*45);
				}
			}
		for(int i =0 ; i<nums.length;i++)
		System.out.println(nums[i]);
	}

}
