package oop0318;

interface IMessage{
	public void msgPrint();//�̿ϼ� �޼ҵ� 
	//new �Ҽ�����. �ֺ���ֱ� ����
}
class Message implements IMessage{
	@Override
	public void msgPrint() {
		System.out.println("Message class...");
	}
}

//�߻�޼ҵ�θ� ������ �� = �������̽� implements.
//�߻�޼ҵ� + �Ϲݸ޼ҵ� ���ΰ� = �߻�Ŭ����
public class Test01_anonymous {
public static void main(String[] args) {
	
	//1) ����Ŭ����
	Message m1 = new Message();
	m1.msgPrint();
	
	//2) ������
	IMessage m = new Message();
	m.msgPrint();
	
	//3) �͸�ü
	//�̺�Ʈ�� �߻����� �� - �Ͻ������� ����
	//�̿ϼ� �޼ҵ� => �����ؼ� �ذ����ֱ�
	//Ű���� ������ ����. Ű���� �� ������ ��. Ű���� ���� ��..
	//�ڹٽ�ũ��Ʈ & jQuery���� �ʼ�
	//$("button").click(){}
	IMessage mess = new IMessage() {
		@Override
		public void msgPrint() {
			System.out.println("�͸�ü������");
		}
	};
	mess.msgPrint();
	
	
}
}
