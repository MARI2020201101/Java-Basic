package Test;

public class Operation {

	public void operate(char op,int i,int j) {
		switch(op) {
			case '+': System.out.printf("%d+%d=%d",i,j,(i+j));
				break;
			case '-': System.out.printf("%d-%d=%d",i,j,i-j);
				break;
			case '*': System.out.printf("%d*%d=%d",i,j,i*j);
				break;
			case '/': System.out.printf("%d/%d=%.1f",i,j,i/(j*1.0));
				break;
			case '%': System.out.printf("%d%%%d=%d",i,j,i%j);
				break;	
		}

	}
public static void main(String[] args) {
	Operation operation = new Operation();
	int i=5;
	int j=7;
	char op='%';
	operation.operate(op, i, j);
	
	
}
}
