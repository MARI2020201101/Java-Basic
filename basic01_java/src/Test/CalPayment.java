package Test;

public class CalPayment {
	int m;

	public void calYogum(int m) {
		int gibonYogum = 900;
		int cyugaYogum = 0;
		if (m > 2000) {
			cyugaYogum = (int) (Math.ceil(Math.ceil(m-2000)/200))*100;
		}
		System.out.println("����Ÿ� : " + m + "m");
		System.out.println("�⺻��� : " + gibonYogum + "��");
		System.out.println("�߰���� : " + cyugaYogum + "��");
		System.out.println("�ѿ�� : " + (cyugaYogum + gibonYogum) + "��");
		
			}

	public static void main(String[] args) {
		CalPayment calPayment = new CalPayment();
		calPayment.calYogum(3100);
	}
}