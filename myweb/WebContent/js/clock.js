$(document).ready(function(){
	showTime();
});

function showTime(){
            //문제) d값을 이용해서 날짜 정보를 아래와 같이 구성해서 id=clock에 출력하시오
        //      2021. 04. 14 (수) PM 03:19:20
        var d=new Date();
        var yoyils=["일","월","화","수","목","금","토"];
        var date2 = d.toString();
        var yoyil = yoyils[d.getDay()];
        var year = d.getFullYear();
        var month = d.getMonth()+1;
        var day =  d.getDate();
       // var yoyil = date2.substring(0,3);
        var time = date2.substring(16,24);

        if(month<10){
            month="0"+month.toString();
        }
        if(day<10){
            day="0"+day.toString();
        }
        var tempTime = time.substring(0,2);
        console.log(tempTime);
        if(parseInt(tempTime)>12){      
            tempTime=(parseInt(tempTime)-12);
            if(tempTime<10){
                tempTime="PM 0"+ tempTime.toString();
            }else{
                tempTime="PM "+tempTime.toString();
            }    
            time=time.substring(2);
        }
        else{
            tempTime="AM "+tempTime.toString();
            time=time.substring(2);
        }
        var str = year + ". "+month+". "+day+ " ("+yoyil+") "+tempTime+time;
        console.log(str);
        document.getElementById("clock").innerHTML=str;
        timer = setTimeout(showTime,1000);    
    }/**
 * 
 */