package oop0319;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test06_sungjuk {
public static void main(String[] args) {
	//문제) 성적프로그램
	//성적 입력자료 (sungjuk.txt )를 가져와서 -> read
	//성적 결과 파일 완성하기 (result. txt) -> write
	/*
    1) 입력파일 : sungjuk.txt

    2) 결과파일 : result.txt
                          성 / 적 / 결 /과
       ---------------------------------------------------
       이름     국어   영어  수학   평균  등수  결과
       ---------------------------------------------------                       
       라일락    100  100  100  100   1   합격 ********** 장학생
       진달래
       진달래     50   55   60   55   4   불합격 *****
       개나리     95   95   35   75   3   재시험 *******
       무궁화     80   85   90   85   2   합격 ********
       홍길동     60   40   30   43   5   불합격 ****
       ---------------------------------------------------
       */
	
	String filename = "C:\\java202102\\setup\\sungjuk.txt";
	String resultfile = "C:\\java202102\\setup\\result.txt";
	String[] namelist = new String[5];
	Integer[] korList = new Integer[5];
	Integer[] engList = new Integer[5];
	Integer[] matList = new Integer[5];
	Integer[] avgList = new Integer[5];
	Integer[] rank = {1,1,1,1,1};
	String[] result = new String[5];
	String[] star = new String[5];
	String[] etc = new String[5];
	try {
		
		BufferedReader br = new BufferedReader(new FileReader(filename));
		while(true) {
			String s = br.readLine();
			String[] slist = s.split(",");
			if(s==null) {break;}
			
			
			
			for(String ss : slist) {
				System.out.println(ss);
			}
			for(int i = 0; i<namelist.length ; i++) {
				namelist[i]= slist[0];
				korList[i] = Integer.parseInt(slist[1]);
				engList[i] = Integer.parseInt(slist[2]);
				matList[i] = Integer.parseInt(slist[3]);
				avgList[i] = (korList[i]+engList[i]+matList[i])/3;
				System.out.print(namelist[i]);
				System.out.print(korList[i]);
				System.out.print(engList[i]);
				System.out.print(matList[i]);
				System.out.println(avgList[i]);
			}
			
			System.out.println(s);
			br.close();
		}

		//PrintWriter out = new PrintWriter(new FileWriter(resultfile));
	} catch (Exception e) {
		System.out.println("파일 읽기 실패 : " + e.getMessage());
	}
}
}
