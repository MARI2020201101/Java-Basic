
package oop0310;


public class Test02_swith {
public static void main(String[] args) {
	
	switch("a") {
	case "a": System.out.println("SEOUL");break;
	case "b": System.out.println("BUSAN");break;
	case "c": System.out.println("JEJU");break;
	default : System.out.println("기타"); break;
	}
	
	//문제1) 평균에 따라 abcdf학점출력
	int kor=10, eng=100,mat=100;
	int aver =(kor+eng+mat )/3;
	String result = "";
	if (aver>90) result = "A";
	else if(aver>80)result ="B";
	else if(aver>70)result = "C";
	else if(aver>70)result = "D";
	else result = "E";
	System.out.println("학점은 "+ result +"입니다");
	
	switch(aver/10) {
	case 10:result = "A+";break;
	case 9:result = "A";break;
	case 8:result = "B";break;
	case 7:result = "C";break;
	case 6:result = "D";break;
	default : result = "F";break;
	}System.out.println("학점은 "+ result +"입니다");
	
	//문제 2) 연산기호(op)에 따라 결과값 출력
	int i=5, j=7;
	char op ='+';
	/*
	 * 출력결과 5+3=8 5-3=2 5*3=15 5/3=0.7 5%3=2
	 */
	double res2=0.0;
	int res1 =0;
	switch(op){
		case'+' : res1=i+j; break; 
		case'-' : res1=i-j; break; 
		case'*' : res1=i*j; break; 
		case'/' : res2=i/j; break; 
		case'%' : res1=i%j; break; 
	}
	//문3) 주민번호를 이용해서 나이와 성별 출력
	//980101 
	//00년생부터 앞자리 3-4
	
	int firstNum = 2;
	int myYear= 98;
	int year = 21;
	int age = 0;
	String sex = "";
	if(firstNum<3){
		age = year + (100-myYear);
	}else {
		age = year - myYear;
	}System.out.println("age : "+age);
	if(firstNum%2!=0)sex = "남";
	else sex = "여";
	System.out.println("성별 : "+ sex);
	
	switch(1) {
	case 1: 
	case 2: myYear = 1900+myYear;break;
	case 3: 
	case 4: myYear = 2000+myYear;break;
	}
	
}
}
