package oop0311;


public class Test05_sungjuk {

	public static void main(String[] args) {
		
		String[] name= {"���϶�","���޷�","������","����ȭ","ȫ�浿"};
        int[] kor= {100, 50, 95, 80, 60};
        int[] eng= {100, 55, 95, 85, 40};
        int[] mat= {100, 60, 35, 90, 30};
        
        //1)��ձ��ϱ�
        int[] aver = new int[5];
        
        for(int i = 0; i<kor.length ; i++) {
        	aver[i] = (kor[i]+eng[i]+mat[i])/3;
        }
        //2)������ϱ�(����:���)
        int[] rank = {1,1,1,1,1};
        for(int i=0; i<aver.length ; i++) {
        	for(int j =0; j<aver.length; j++) {
        		if(aver[i]<aver[j]) {
            		rank[i]++;
            	}
        	}
        	
        }
        for(int i= 0; i<aver.length; i++)
        System.out.printf("�̸�: %s , ��� : %d , ��� : %d \n", name[i] ,aver[i], rank[i]);
        
        
        //3) ����(����� �������� �հ�, �����, ���հ�)
        int total = 0;
        String[] result = {"","","","",""};
        for(int i = 0;i<aver.length ;i++) {
        	total += aver[i];
        }
        int totalaver = total/aver.length;
        for(int i =0; i<aver.length ; i++) {
        	if(totalaver<aver[i]) result[i]="�հ�";
        	else if(totalaver==aver[i]) result[i]="�����";
        	else result[i] ="���հ�";
        }
        
        for(int i =0 ; i<aver.length;i++) {
        	System.out.print(name[i]+" ");
        	System.out.print(kor[i]+" ");
        	System.out.print(eng[i]+" ");
        	System.out.print(mat[i]+" ");
        	System.out.print(aver[i]+" ");
        	System.out.print(rank[i]+"�� ");
        	
        	if(aver[i]>=70) {
            	if(kor[i]<40||eng[i]<40|| mat[i]<40) System.out.println("�����");
            	else System.out.println("�հ�");
            }else System.out.println("���հ�");
        	
        	
        }
        
        
        //4) ��� 10���� * ����
        String[] star = {"","","","",""};
        for(int i = 0;i<aver.length; i++) {
        	int num = (aver[i]/10);
        	for(int j=0; j<num; j++) {
        		star[i]=star[i]+"*";
        	}
        }
        for(int i = 0; i<aver.length;i++) {
        	for(int stars =0; stars<aver[i]/10;stars++) {
            	System.out.print("*");
            	
            }System.out.println(" ");
        }
        
       
        //5) ��� 95���̻� = ���л�
        String[] student = {"","","","",""};
        for(int i= 0; i<aver.length; i++) {
        	if(aver[i]>=95) student[i]="���л�";
        	else student[i] ="�л�";
        }
        System.out.println("-----------------------------------------------");
        for(int i= 0; i<aver.length; i++)
            System.out.printf("�̸�: %s , �� : %s , Ư�̻��� : %s \n", name[i] ,star[i], student[i]);
            
	}

}