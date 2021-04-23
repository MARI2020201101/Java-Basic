package net.testbean;

public class CalcBean {
	
	public int abs(int a) {
		return Math.abs(a);
	}
	public long fact(int a) {
		return a==0? 1: a*fact(a-1);
	}
}
