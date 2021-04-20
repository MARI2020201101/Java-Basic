package Test;

public class CalPayment {
	int m;

	public void calYogum(int m) {
		int gibonYogum = 900;
		int cyugaYogum = 0;
		if (m > 2000) {
			cyugaYogum = (int) (Math.ceil(Math.ceil(m-2000)/200))*100;
		}
		System.out.println("운행거리 : " + m + "m");
		System.out.println("기본요금 : " + gibonYogum + "원");
		System.out.println("추가요금 : " + cyugaYogum + "원");
		System.out.println("총요금 : " + (cyugaYogum + gibonYogum) + "원");
		
			}

	public static void main(String[] args) {
		CalPayment calPayment = new CalPayment();
		calPayment.calYogum(3100);
	}
}