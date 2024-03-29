package oop0319;

import java.io.File;

public class Test02_File {
	//파일 클래스 : 파일에 대한 정보를 저장하는 클래스
	//-> 파일명, 파일크기(용량) , 확장자ext 등
	//파일 자체를 다룰 수도 있고, 파일의 내용을 다룰 수도 있다 ( 내용을 읽어들인다!!)
	//파일의 확장자에 따라 어떤 input 을 하는지가 달라진다 - scanner(이미지 파일)..등등
	
	public static void main(String[] args) {
		
	
		try {
			//자바에서는 \가 명령어이기 때문에 경로로 쓸때는. 이것은 문자입니다! 라는 표시로 두번쓴다
			//경로명 + 파일명
			String pathname="C:\\java202102\\rabbit2.png";
			//슬래쉬로 그냥 써도 됨!
			//String pathname="C:/java202102/rabbit2.png";
			
			//File클래스에 담기
			//uri로 담을 수도 있다. 즉, 서버에 있는 파일을 가져오는 것도 가능함
			//여기서는 내 컴퓨터안의파일을 불러오도록 한다. 
			//파일을 불러오기 위해서는 파일의 경로 & 대상 파일의 이름이 필요하다
			File file = new File(pathname);
			if(file.exists()) {
				System.out.println("파일 있어요~~");
				long filesize = file.length();
				System.out.println("파일 크기 : " + filesize +"byte");
				System.out.println("파일 크기 : " + filesize/1024 +"KB");
				String fileName = file.getName();
				System.out.println("파일 이름 : " + fileName);
				System.out.println("file.isDirectory() " + file.isDirectory());
				System.out.println("file.getPath() " + file.getPath());
				System.out.println("file.getAbsolutePath() " + file.getAbsolutePath());
				
				int lastname = file.getName().lastIndexOf(".");
				String name = file.getName().substring(0,lastname);
				System.out.println("파일 이름 with substring : " + name);
				String ext = file.getName().substring(lastname+1);
				System.out.println("파일 확장자 : " + ext);
				//파일 삭제
				file.delete();
			}else {
				System.out.println("파일 없어요!!");
			}
			
			
		}catch(Exception e) {
			System.out.println("파일 읽기 실패 :" + e.getMessage());
		}
	}
}
