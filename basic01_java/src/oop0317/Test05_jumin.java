package oop0317;

import java.util.Calendar;
import java.util.Locale;

public class Test05_jumin {
public static void main(String[] args) {
	
	Jumin id = new Jumin("9701292417212");
	if(id.validate2()) {
		System.out.println("주민번호가 맞습니다. ");
	}else {
		System.out.println("주민번호가 틀립니다. ");
	}

	id.disp();
	
}
}
