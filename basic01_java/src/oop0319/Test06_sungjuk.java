package oop0319;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test06_sungjuk {
public static void main(String[] args) {
	//����) �������α׷�
	//���� �Է��ڷ� (sungjuk.txt )�� �����ͼ� -> read
	//���� ��� ���� �ϼ��ϱ� (result. txt) -> write
	/*
    1) �Է����� : sungjuk.txt

    2) ������� : result.txt
                          �� / �� / �� /��
       ---------------------------------------------------
       �̸�     ����   ����  ����   ���  ���  ���
       ---------------------------------------------------                       
       ���϶�    100  100  100  100   1   �հ� ********** ���л�
       ���޷�
       ���޷�     50   55   60   55   4   ���հ� *****
       ������     95   95   35   75   3   ����� *******
       ����ȭ     80   85   90   85   2   �հ� ********
       ȫ�浿     60   40   30   43   5   ���հ� ****
       ---------------------------------------------------
       */
	
	String filename = "C:\\java202102\\setup\\sungjuk.txt";
	String resultfile = "C:\\java202102\\setup\\result.txt";
	String[] namelist = new String[5];
	Integer[] korList = new Integer[5];
	Integer[] engList = new Integer[5];
	Integer[] matList = new Integer[5];
	Integer[] avgList = new Integer[5];
	Integer[] rank = {1,1,1,1,1};
	String[] result = new String[5];
	String[] star = new String[5];
	String[] etc = new String[5];
	try {
		
		BufferedReader br = new BufferedReader(new FileReader(filename));
		while(true) {
			String s = br.readLine();
			String[] slist = s.split(",");
			if(s==null) {break;}
			
			
			
			for(String ss : slist) {
				System.out.println(ss);
			}
			for(int i = 0; i<namelist.length ; i++) {
				namelist[i]= slist[0];
				korList[i] = Integer.parseInt(slist[1]);
				engList[i] = Integer.parseInt(slist[2]);
				matList[i] = Integer.parseInt(slist[3]);
				avgList[i] = (korList[i]+engList[i]+matList[i])/3;
				System.out.print(namelist[i]);
				System.out.print(korList[i]);
				System.out.print(engList[i]);
				System.out.print(matList[i]);
				System.out.println(avgList[i]);
			}
			
			System.out.println(s);
			br.close();
		}

		//PrintWriter out = new PrintWriter(new FileWriter(resultfile));
	} catch (Exception e) {
		System.out.println("���� �б� ���� : " + e.getMessage());
	}
}
}