<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
<title>Insert title here</title>

</head>
<body>
<div class="container">
	<h1>성적프로그램(배열)</h1>
	<br>
<%		
	String[] name= {"라일락","진달래","개나리","무궁화","홍길동"};
	int[] kor= {100, 50, 95, 80, 60};
	int[] eng= {100, 55, 95, 85, 40};
	int[] mat= {100, 60, 35, 90, 30};
	
	//1)평균구하기
	int[] aver = new int[5];
	
	for(int i = 0; i<kor.length ; i++) {
		aver[i] = (kor[i]+eng[i]+mat[i])/3;
	}
	//2)등수구하기(기준:평균)
	int[] rank = {1,1,1,1,1};
	for(int i=0; i<aver.length ; i++) {
		for(int j =0; j<aver.length; j++) {
			if(aver[i]<aver[j]) {
	    		rank[i]++;
	    	}
		}
	}
	 int total = 0;
     String[] result = {"","","","",""};
     for(int i = 0;i<aver.length ;i++) {
     	total += aver[i];
     }
     int totalaver = total/aver.length;
     for(int i =0; i<aver.length ; i++) {
     	if(totalaver<aver[i]) result[i]="합격";
     	else if(totalaver==aver[i]) result[i]="재시험";
     	else result[i] ="불합격";
     }
     String[] star = {"","","","",""};
     for(int i = 0;i<aver.length; i++) {
     	int num = (aver[i]/10);
     	for(int j=0; j<num; j++) {
     		star[i]=star[i]+"*";
     	}
     }
     String[] student = {"","","","",""};
     for(int i= 0; i<aver.length; i++) {
     	if(aver[i]>=95) student[i]="장학생";
     	else student[i] ="학생";
     }
 %>

<table class="table table-striped">
<thead class="table-success">
	 <tr>
		 <th>이름</th>
		 <th>국어</th>
		 <th>수학</th>
		 <th>영어</th>
		 <th>평균</th>
		 <th>등수</th>
		 <th>결과</th>
	 </tr>
</thead>	 
	<% for(int i=0;i<aver.length;i++){
		%>
	<tr>
	 	<td><%=name[i] %></td>
	 	<td><%=kor[i] %></td>
	 	<td><%=mat[i] %></td>
	 	<td><%=eng[i] %></td>
	 	<td><%=aver[i] %></td>
	 	<td><%=rank[i] %></td>
	 	<td><%=result[i] + star[i] +"&nbsp;"+student[i]%></td>
	 </tr>		
	<% }%>

 </table>
 </div>
</body>
</html>