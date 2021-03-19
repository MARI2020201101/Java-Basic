package oop0315;

public class Test05_String {

	public static void main(String[] args) {
		String str = new String("Gone with the Wind");
		System.out.println(str.length()); // ���� ���� (����)
		System.out.println(str.charAt(0));
		System.out.println(str.charAt(str.length()-1));
		System.out.println(str.indexOf('G')); //���ڿ��� ����
		System.out.println(str.indexOf("e",4));
		//���� ���ڿ� = -1
		
		System.out.println(str.startsWith("o"));
		System.out.println(str.endsWith("d"));
		System.out.println(str.startsWith("Gone"));
		System.out.println(str.replace('n', 'N'));
		System.out.println(str.concat(" Dont forget me"));
		System.out.println(str.isBlank());
		System.out.println(str.isEmpty());
		String str2 = "";
		String str3 = " ";
		
		System.out.println(str2.isBlank()); //true
		System.out.println(str2.isEmpty()); //true
		System.out.println(str3.isBlank());  //true
		System.out.println(str3.isEmpty());  //false
		//blank �� trim ���鵵 �������� ó��
		
		if(str.isEmpty())System.out.println("���ڿ� �Դϴ�");
		else System.out.println("���ڿ��� �ƴմϴ�");
		
		String name1 = "HAPPY";
		String name2 = new String("HAPPY");
		
		if(name1==name2)System.out.println("����");
		else System.out.println("�ٸ���");
		//reference (�ּҰ�) �� �ٸ��⶧���� "�ٸ���"

		if(name1.equals(name2))System.out.println("����");
		else System.out.println("�ٸ���");
		//���밪�� "����"
		
		String name3 = name1;
		if(name1==name3)System.out.println("����");
		else System.out.println("�ٸ���");
		
		//���ڿ��� �Ϻκи� �����ϱ�(�ڡڡڡڡ�)
		//������ 0���� ����
		System.out.println(str.substring(6));
		System.out.println(str.substring(6,12));
		System.out.println(str.substring(10,13));
		//�߶������ ���ڼ� +1 �ϱ� 
		//	->why?? ���ڿ��� �������� ���� ������ Ȯ���ؾ� �ϱ� ����
		System.out.println(str.substring(0,1));
		System.out.println(str.substring(str.length()-1,str.length()));
		System.out.println(str.substring(str.length()-1)); //�����ε���
	}

}