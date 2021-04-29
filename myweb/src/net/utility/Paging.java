package net.utility;

public class Paging {  
  /**
   * �닽�옄 �삎�깭�쓽 �럹�씠吏�, 1 �럹�씠吏�遺��꽣 �떆�옉
   * �쁽�옱 �럹�씠吏�: 11 / 22   [�씠�쟾] 11 12 13 14 15 16 17 18 19 20 [�떎�쓬]
   * 
   * @param totalRecord �쟾泥� �젅肄붾뱶�닔
   * @param nowPage     �쁽�옱 �럹�씠吏�
   * @param recordPerPage �럹�씠吏��떦 �젅肄붾뱶 �닔 
   * @return
   */
  public String paging(int totalRecord, int nowPage, int recordPerPage, String col, String word, String filenm){
    int pagePerBlock = 10; // 블럭당 페이지 수
    int totalPage = (int)(Math.ceil((double)totalRecord/recordPerPage)); // 전체페이지
    int totalGrp = (int)(Math.ceil((double)totalPage/pagePerBlock));// 전체그룹
    int nowGrp = (int)(Math.ceil((double)nowPage/pagePerBlock));    // �쁽�옱 洹몃９
    int startPage = ((nowGrp - 1) * pagePerBlock) + 1; // �듅�젙 洹몃９�쓽 �럹�씠吏� 紐⑸줉 �떆�옉 
    int endPage = (nowGrp * pagePerBlock);             // �듅�젙 洹몃９�쓽 �럹�씠吏� 紐⑸줉 醫낅즺  
    
    StringBuffer str = new StringBuffer();
    
    str.append("<style>");
    str.append("  #paging {text-align: center; margin-top: 5px; font-size: 1em;}");
    str.append("  #paging A:link {text-decoration:none; color:black; font-size: 1em;}");
    str.append("  #paging A:hover{text-decoration:underline; background-color: #ffffff; color:black; font-size: 1em;}");
    str.append("  #paging A:visited {text-decoration:none;color:black; font-size: 1em;}");
    str.append("</style>");
    str.append("<DIV id='paging'>");
    //str.append("�쁽�옱 �럹�씠吏�: " + nowPage + " / " + totalPage + "&nbsp;&nbsp;");

    int _nowPage = (nowGrp-1) * pagePerBlock; // 10媛� �씠�쟾 �럹�씠吏�濡� �씠�룞
    if (nowGrp >= 2){
      str.append("[<A href='./"+filenm+"?col="+col+"&word="+word+"&nowPage="+_nowPage+"'>previous</A>]");
    }

    for(int i=startPage; i<=endPage; i++){
      if (i > totalPage){
        break;
      }
 
      if (nowPage == i){ // �쁽�옱 �럹�씠吏��씠硫� 媛뺤“ �슚怨�
        str.append("<span style='font-size: 1.2em; font-weight: bold;'>"+i+"</span>&nbsp;");  
      }else{
        str.append("<A href='./"+filenm+"?col="+col+"&word="+word+"&nowPage="+i+"'>"+i+"</A>&nbsp;");
      }
      
    }
    
    _nowPage = (nowGrp * pagePerBlock)+1; // 10媛� �떎�쓬 �럹�씠吏�濡� �씠�룞
    if (nowGrp < totalGrp){
      str.append("[<A href='./"+filenm+"?col="+col+"&word="+word+"&nowPage="+_nowPage+"'>next</A>]");
    }
    str.append("</DIV>");
    
    return str.toString();
  }
  
  /**
   * SPAN�깭洹몃�� �씠�슜�븳 諛뺤뒪 紐⑤뜽�쓽 吏��썝, 1 �럹�씠吏�遺��꽣 �떆�옉
   * �쁽�옱 �럹�씠吏�: 11 / 22   [�씠�쟾] 11 12 13 14 15 16 17 18 19 20 [�떎�쓬]
   * 
   * @param totalRecord �쟾泥� �젅肄붾뱶�닔
   * @param nowPage     �쁽�옱 �럹�씠吏�
   * @param recordPerPage �럹�씠吏��떦 �젅肄붾뱶 �닔 
   * @return
   */
  public String paging2(int totalRecord, int nowPage, int recordPerPage, String col, String word, String filenm){
    int pagePerBlock = 10; // 釉붾윮�떦 �럹�씠吏� �닔
    int totalPage = (int)(Math.ceil((double)totalRecord/recordPerPage)); // �쟾泥� �럹�씠吏� 
    int totalGrp = (int)(Math.ceil((double)totalPage/pagePerBlock));// �쟾泥� 洹몃９
    int nowGrp = (int)(Math.ceil((double)nowPage/pagePerBlock));    // �쁽�옱 洹몃９
    int startPage = ((nowGrp - 1) * pagePerBlock) + 1; // �듅�젙 洹몃９�쓽 �럹�씠吏� 紐⑸줉 �떆�옉 
    int endPage = (nowGrp * pagePerBlock);             // �듅�젙 洹몃９�쓽 �럹�씠吏� 紐⑸줉 醫낅즺  
    
    StringBuffer str = new StringBuffer();
    
    str.append("<style>");
    str.append("  #paging {text-align: center; margin-top: 5px; font-size: 1em;}");
    str.append("  #paging A:link {text-decoration:none; color:black; font-size: 1em;}");
    str.append("  #paging A:hover{text-decoration:none; background-color: #CCCCCC; color:black; font-size: 1em;}");
    str.append("  #paging A:visited {text-decoration:none;color:black; font-size: 1em;}");
    str.append("  .span_box_1{");
    str.append("    font-size: 1em;");
    str.append("    border: 1px;");
    str.append("    border-style: solid;");
    str.append("    border-color: #cccccc;");
    str.append("    padding:0px 0px 0px 0px; ");
    str.append("    margin:0px 0px 0px 0px; ");
    str.append("  }");
    str.append("  .span_box_2{");
    str.append("    background-color: #CCCCCC;");
    str.append("    font-size: 1em;");
    str.append("    border: 1px;");
    str.append("    border-style: solid;");
    str.append("    border-color: #cccccc;");
    str.append("    padding:0px 0px 0px 0px; ");
    str.append("    margin:0px 0px 0px 0px; ");
    str.append("  }");
    str.append("</style>");
    str.append("<DIV id='paging'>");
    //str.append("�쁽�옱 �럹�씠吏�: " + nowPage + " / " + totalPage + "&nbsp;&nbsp;");

    int _nowPage = (nowGrp-1) * pagePerBlock; // 10媛� �씠�쟾 �럹�씠吏�濡� �씠�룞
    if (nowGrp >= 2){
      str.append("<A href='./"+filenm+"?col="+col+"&word="+word+"&nowPage="+_nowPage+"'><span class='span_box_1'>previous</span></A>&nbsp;");
    }

    for(int i=startPage; i<=endPage; i++){
      if (i > totalPage){
        break;
      }
 
      if (nowPage == i){
        str.append("<span class='span_box_2'>&nbsp;"+i+"&nbsp;</span>&nbsp;");
      }else{
        str.append("<A href='./"+filenm+"?col="+col+"&word="+word+"&nowPage="+i+"'><span class='span_box_1'>&nbsp;"+i+"&nbsp;</span></A>&nbsp;");  
      }
    }
    
    _nowPage = (nowGrp * pagePerBlock)+1; // 10媛� �떎�쓬 �럹�씠吏�濡� �씠�룞
    if (nowGrp < totalGrp){
      str.append("<A href='./"+filenm+"?col="+col+"&word="+word+"&nowPage="+_nowPage+"'><span class='span_box_1'>next</span></A>&nbsp;");
    }
    str.append("</DIV>");
    
    return str.toString();
  }
  
  /**
   * SPAN�깭洹몃�� �씠�슜�븳 諛뺤뒪 紐⑤뜽�쓽 吏��썝, 1 �럹�씠吏�遺��꽣 �떆�옉
   * �쁽�옱 �럹�씠吏�: 11 / 22   [�씠�쟾] 11 12 13 14 15 16 17 18 19 20 [�떎�쓬]
   * 
   * @param totalRecord �쟾泥� �젅肄붾뱶�닔
   * @param nowPage     �쁽�옱 �럹�씠吏�
   * @param recordPerPage �럹�씠吏��떦 �젅肄붾뱶 �닔 
   * @return
   */
  public String paging3(int totalRecord, int nowPage, int recordPerPage, String col, String word, String filenm){
    int pagePerBlock = 10; // 釉붾윮�떦 �럹�씠吏� �닔
    int totalPage = (int)(Math.ceil((double)totalRecord/recordPerPage)); // �쟾泥� �럹�씠吏� 
    int totalGrp = (int)(Math.ceil((double)totalPage/pagePerBlock));// �쟾泥� 洹몃９
    int nowGrp = (int)(Math.ceil((double)nowPage/pagePerBlock));    // �쁽�옱 洹몃９
    int startPage = ((nowGrp - 1) * pagePerBlock) + 1; // �듅�젙 洹몃９�쓽 �럹�씠吏� 紐⑸줉 �떆�옉 
    int endPage = (nowGrp * pagePerBlock);             // �듅�젙 洹몃９�쓽 �럹�씠吏� 紐⑸줉 醫낅즺  
    
    StringBuffer str = new StringBuffer();
    
    str.append("<style>");
    str.append("  #paging {text-align: center; margin-top: 5px; font-size: 1em;}");
    str.append("  #paging A:link {text-decoration:none; color:black; font-size: 1em;}");
    str.append("  #paging A:hover{text-decoration:none; background-color: #CCCCCC; color:black; font-size: 1em;}");
    str.append("  #paging A:visited {text-decoration:none;color:black; font-size: 1em;}");
    str.append("  .span_box_1{");
    str.append("    font-size: 1em;");
    str.append("    border: 1px;");
    str.append("    border-style: solid;");
    str.append("    border-color: #cccccc;");
    str.append("    padding:0px 0px 0px 0px; ");
    str.append("    margin:0px 0px 0px 0px; ");
    str.append("  }");
    str.append("  .span_box_2{");
    str.append("    background-color: #668db4;");
    str.append("    color: #FFFFFF;");
    str.append("    font-size: 1em;");
    str.append("    border: 1px;");
    str.append("    border-style: solid;");
    str.append("    border-color: #cccccc;");
    str.append("    padding:0px 0px 0px 0px; ");
    str.append("    margin:0px 0px 0px 0px; ");
    str.append("  }");
    str.append("</style>");
    str.append("<DIV id='paging'>");
    //str.append("�쁽�옱 �럹�씠吏�: " + nowPage + " / " + totalPage + "&nbsp;&nbsp;");

    int _nowPage = (nowGrp-1) * pagePerBlock; // 10媛� �씠�쟾 �럹�씠吏�濡� �씠�룞
    if (nowGrp >= 2){
      str.append("<A href='./"+filenm+"?col="+col+"&word="+word+"&nowPage="+_nowPage+"'><span class='span_box_1'>previous</span></A>&nbsp;");
    }

    for(int i=startPage; i<=endPage; i++){
      if (i > totalPage){
        break;
      }
 
      if (nowPage == i){
        str.append("<span class='span_box_2'>&nbsp;"+i+"&nbsp;</span>&nbsp;");
      }else{
        str.append("<A href='./"+filenm+"?col="+col+"&word="+word+"&nowPage="+i+"'><span class='span_box_1'>&nbsp;"+i+"&nbsp;</span></A>&nbsp;");  
      }
    }
    
    _nowPage = (nowGrp * pagePerBlock)+1; // 10媛� �떎�쓬 �럹�씠吏�濡� �씠�룞
    if (nowGrp < totalGrp){
      str.append("<A href='./"+filenm+"?col="+col+"&word="+word+"&nowPage="+_nowPage+"'><span class='span_box_1'>next</span></A>&nbsp;");
    }
    str.append("</DIV>");
    
    return str.toString();
  }
}//class end
