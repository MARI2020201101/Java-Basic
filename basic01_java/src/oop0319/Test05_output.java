package oop0319;

import java.io.FileWriter;
import java.io.PrintWriter;

public class Test05_output {
	public static void main(String[] args) {
		String filename ="C:\\java202102\\setup\\sungjuk.txt";
		//파일 읽어들일때는 파일이 null이면 -> exception 그러나 출력은 좀 다르다!!
		
		//출력파일 (sungjuk.txt) 가 
		//없는 경우 -> new ! 
		//있는 경우 -> 덮어쓰기 OR 추가
		
		try {
			//append => true
			FileWriter fw = new FileWriter(filename, false);
			
			//autoFlush => true
			//buffer : 데이터들이 왔다갔다 하는 통로. 
			//다른 데이터들이 왔다갔다할때 길 막지맛. flush해서 길 청소하고 가기
			PrintWriter out = new PrintWriter(fw, true);
			out.println("무궁화,95,90,100");
			out.println("홍길동,100,100,100");
			out.println("라일락,90,95,100");
			out.println("개나리,85,70,75");
			out.println("진달래,35,40,60");
			
			System.out.println("sungjuk.txt 완성!");
			out.close();
			fw.close();
		}catch(Exception e) {
			System.out.println("실패 : " + e.getMessage());
		}
 	}

}
