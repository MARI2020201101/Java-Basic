package oop0316;

public class Test08_quiz {
public static void main(String[] args) {
	
	//�̸��� �ּҿ� @���� ������
    //     @���� �������� ���ڿ��� �и��ؼ� ����ϰ�
    //     ->��°�� : webmaster
    //               soldesk.com
    //     @���� ���ٸ� "�̸����ּ� Ʋ��" �޼����� ����Ͻÿ�
    //String email="webmaster@soldesk.com";
	
	String email = "test@email.com";
	
	if(email.contains("@")) {
		String[] emailResult = email.split("@");
	for(String s : emailResult) {
		System.out.println(s);	}
	}else System.out.println("�̸��� �ּ� Ʋ��");
	
	System.out.println("-----------------");
	int pos = email.indexOf("@");
	if(pos==-1) {
		System.out.println("�̸����ּ� Ʋ��");
	}else {
		System.out.println("�̸��� �ּ� ����");
	}
	
	
    //��2)�ֹι�ȣ �� ������ ��ü ���� ���Ͻÿ�
    //    1+5+1+2+3+0+4+1+2+3+4+5+6=37
    String jumin="1512304123456";
    Integer result = 0;
    String[] jumin2 = jumin.split("");
    for(String j : jumin2) {
    	result += Integer.parseInt(j);
    	}
    System.out.println("------------------");
    System.out.println("�ֹι�ȣ�� �� :" + result);
    
    System.out.println("--------------------------"); 
    Integer hap = 0;
    for(int i = 0; i<jumin.length() ;i++) {
    	hap += Integer.parseInt(jumin.substring(i,i+1));
    }System.out.println("�ֹι�ȣ�� �� with substring :" + hap);
    
    //��3)���ϸ�, Ȯ����� �и��ؼ� ����Ͻÿ�
    //   ��°��
    //   ->���ϸ� : 2020.03.10.sky
    //   ->Ȯ��� : png
    String path="d:/java202102/workspace/2020.03.10.sky.png";
    int lastIndex = path.lastIndexOf("/");
    String path2 = path.substring(lastIndex+1);
  
    int lastJum = path2.lastIndexOf(".");
    String ext = path2.substring(lastJum+1);
    String fileName = path2.substring(0, lastJum);

    System.out.println("------------------");
    System.out.println(fileName);
    System.out.println(ext);
    
    //2) Ȯ����� �̹��� �������� Ȯ���Ͻÿ�(png, jpg,gif)
    //������ "������ ���۵Ǿ����ϴ�"
    //Ʋ���� "������ �ٽ� �������ּ���"
    //Ȯ��� ���� �ҹ��ڷ� �ٲ��� ���ڿ� ��
    ext = ext.toLowerCase();
    if(ext.equals("png")||ext.equals("jpg")||ext.equals("gif"))
    	System.out.println("������ ���۵Ǿ����ϴ�");
    else System.out.println("������ �ٽ� �������ּ���");
    
    
    
}
}