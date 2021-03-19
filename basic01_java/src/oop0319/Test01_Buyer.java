package oop0319;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

class Product { //extends Object (�ڹ��� �ְ� ����)
	public int price; //��ǰ����
	public int bonusPoint; //���ϸ���
	public Product() {}
	public Product(int price) {
		this.price = price;
		this.bonusPoint = (int)(price*0.1);
	}
	
}
class SmartTV extends Product{
	public SmartTV() {
		super(100); //�θ��� �������Լ� ȣ���ؼ� ���� �ʱⰪ ����ش�
		//���ʽ� ����Ʈ�� �ڵ�����~
	}
	@Override
	public String toString() {
		return "����ƮƼ��";
	}
}
class Notebook extends Product{
	public Notebook(){
		super(200);
	}
	@Override
	public String toString() {
		return "��Ʈ��";
	}
}
class Handphone extends Product{
	public Handphone() {
		super(150);
	}

	@Override
	public String toString() {
		return "�ڵ���";
	}
	
}

//��ǰ �����ϴ� ���
class Buyer{
	private int myMoney = 1000;
	private int myMilige = 0;
	//���Ÿ��
	private List<Product> items = new ArrayList();
	private Product[] list = new Product[10];
	private int i = 0;
	
	public void buy(Product product) {
		
		if(myMoney < product.price) {
			System.out.println("�ܾ��� �����մϴ�.");
		}else {
			this.myMoney -= product.price;
			this.myMilige += product.bonusPoint;
			items.add(product);
			list[i++]= product;
			
			System.out.println(product.toString() + " ��/�� �����Ͽ����ϴ�.");
		}
		
	}
	public void disp() {
		System.out.println("���� ��� : " + this.myMoney);
		System.out.println("���ϸ��� : " + this.myMilige);
		System.out.print("���� ��� : ");
		items.forEach((i)-> System.out.print(i.toString() + ", "));
		items.forEach(i->System.out.println(" ��� ��� : "+ i.price+" "));
	}
	
	public void disp2() {
		StringBuilder shoplist = new StringBuilder();
		int hap = 0;
		
		for(int n =0; n<list.length ; n++ ) {
			if(list[n]==null) {
				break;
			}
			shoplist.append(list[n].toString() + " ");
			hap += list[n].price;
		}
		System.out.println("��� ���2 : "+ hap);
		System.out.println("���� ��� 2 : " + shoplist);
	}
}

class Order{
	private int myMoney = 1000;
	private int myMileage = 0;
	
	Vector<Product> items = new Vector();
	public void disp() {
		System.out.print("order ��� :");
		items.stream().distinct().forEach(i -> System.out.print(i+ " "));
		System.out.println();
		System.out.println("���ϸ��� : " + myMileage);
		int hap = items.stream().mapToInt(i -> i.price).sum();
		System.out.println("������ : " + hap);
	};
	public void buy(Product product) {
		if(product.price> myMoney) {
			System.out.println("�ܾ��� �����մϴ�!");
			return;
		}
		myMoney-=product.price;
		myMileage += product.bonusPoint;
		items.add(product);
	}
	public void refund(Product product) {
		if(items.contains(product)) {
		myMoney += product.price;
		myMileage -= product.bonusPoint;
		System.out.println("��ǰ�� �����Ͽ����ϴ�. ");
		System.out.println("���� ��� : " + myMoney);
		System.out.println("���ϸ��� : " + myMileage);
		}
		else System.out.println("������ ���� �����ϴ�. ");
			return;
		
	};
}
public class Test01_Buyer {

	public static void main(String[] args) {
		SmartTV smartTV= new SmartTV();
		Notebook notebook = new Notebook();
		Handphone handphone = new Handphone();
		
		Buyer kim = new Buyer();
		kim.buy(smartTV);
		kim.buy(smartTV);
		kim.buy(notebook);
		kim.buy(handphone);
		kim.buy(handphone);
		kim.buy(handphone);
	
		
		kim.disp();
		System.out.println("------------------------------");
		kim.disp2();
		
		System.out.println("------------------------------");
		Order order = new Order();
		order.buy(handphone);
		order.buy(handphone);
		order.buy(smartTV);
		order.buy(notebook);
		order.buy(notebook);
		
		order.disp();
		System.out.println("----------------------------��ǰ");
		order.refund(notebook);
	}
}