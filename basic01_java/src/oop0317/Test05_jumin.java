package oop0317;

import java.util.Calendar;
import java.util.Locale;

public class Test05_jumin {
public static void main(String[] args) {
	
	Jumin id = new Jumin("9701292417212");
	if(id.validate2()) {
		System.out.println("�ֹι�ȣ�� �½��ϴ�. ");
	}else {
		System.out.println("�ֹι�ȣ�� Ʋ���ϴ�. ");
	}

	id.disp();
	
}
}