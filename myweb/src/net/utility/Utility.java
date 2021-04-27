package net.utility;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.StringTokenizer;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.ImageIcon;

public class Utility {
  // �꽌鍮꾩뒪�떆�뿉�뒗 �룄硫붿씤�쑝濡� 蹂�寃쎈맖.도메인
  private static final String root = "/myweb";

  public static synchronized String getRoot() {
    return root;
  }

  /**
   * 2048 -> 2媛� 由ы꽩�맖
   * 
   * @param filesize
   * @return
   */
  public static synchronized long toUnit(long filesize) {
    long size = 0;

    if (filesize > 1024) {
      size = filesize / 1024; // KB
    } else {
      size = filesize / (1024 * 1024); // MB
    }

    return size;
  }

  /**
   * 2048 -> 2 KB媛� 由ы꽩�맖
   * 
   * @param filesize
   * @return
   */
  public static synchronized String toUnitStr(long filesize) {
    String size = "";

    if (filesize > 1024) {
      size = filesize / 1024 + " KB"; // KB
    } else {
      size = filesize / (1024 * 1024) + " MB"; // MB
    }

    return size;
  }

  /**
   * �삤�뒛 �궇吏쒕�� 臾몄옄�뿴濡� 由ы꽩�빀�땲�떎.
   * 
   * @return
   */
  public static synchronized String getCalendarDay() {
    String str = "";
    Calendar cal = Calendar.getInstance();
    str = "" + cal.get(Calendar.DATE); // �궇吏�

    return str;
  }

  /**
   * 2010-12-14 �삎�떇�쓽 �궇吏쒕�� 由ы꽩�빀�땲�떎.
   * 
   * @return 2008-01-30 �삎�떇�쓽 臾몄옄�뿴 由ы꽩
   */
  public static synchronized String getDate() {
    SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");

    String date = sd.format(new Date());

    // System.out.println(date);
    return date;
  }

  /**
   * 20101214 �삎�떇�쓽 �궇吏쒕�� 由ы꽩�빀�땲�떎.
   * 
   * @return 20101214 �삎�떇�쓽 臾몄옄�뿴 由ы꽩
   */
  public static synchronized String getDate2() {
    SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd");

    String date = sd.format(new Date());

    // System.out.println(date);
    return date;
  }

  /**
   * 20101214 �삎�떇�쓽 �궇吏쒕�� 由ы꽩�빀�땲�떎.
   * 
   * @param _date
   * @return
   */
  public static synchronized String getDate3(Date _date) {
    SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd");
    String date = sd.format(_date);

    // System.out.println(date);
    return date;
  }

  /**
   * 2010�뀈 12�썡 14�씪 �삎�떇�쓽 �궇吏쒕�� 由ы꽩�빀�땲�떎.
   * 
   * @return
   */
  public static synchronized String getDate4() {
    SimpleDateFormat sd = new SimpleDateFormat("yyyy�뀈 MM�썡 dd�씪");
    String date = sd.format(new Date());

    // System.out.println(date);
    return date;
  }

  /**
   * 20101214�씪 �삎�떇�쓽 �궇吏쒕�� 由ы꽩�빀�땲�떎.
   * 
   * @param _date
   * @return
   */
  public static synchronized String getDate5(Date _date) {
    SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd");
    String date = sd.format(_date);

    // System.out.println(date);
    return date;
  }

  /**
   * 2010-12-14 �삎�떇�쓽 �궇吏쒕�� 由ы꽩�빀�땲�떎.
   * 
   * @return 2008-01-30 �삎�떇�쓽 臾몄옄�뿴 由ы꽩
   */
  public static synchronized String getDate6(int year, int month, int day) {
    SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");

    new Date();
    String date = sd.format(new Date(year - 1900, month, day));

    // System.out.println(date);
    return date;
  }

  /**
   * �궡�슜以묒뿉 �듅�닔臾몄옄 �몴�쁽�쓣 �쐞�빐 HTML �듅�닔臾몄옄濡� 蹂��솚�빀�땲�떎. 
   * �삁) �뀒�씠釉� �깭洹�
   *     <TABLE> -> &lt;TABLE&gt;
   */
  public static synchronized String convertChar(String str) {

    str = str.replaceAll(" ", "&nbsp;");
    str = str.replaceAll("<", "&lt;");
    str = str.replaceAll(">", "&gt;");
    str = str.replaceAll("'", "&apos;");   // '
    str = str.replaceAll("\"", "&quot;");  // "
    str = str.replaceAll("\r\n", "<BR>");  // �씪�씤 蹂�寃�
    
    return str;
  }
  
  public static synchronized String convertCharTA(String str) {

    str = str.replaceAll("<", "&lt;");
    str = str.replaceAll(">", "&gt;");
    str = str.replaceAll("'", "&apos;");   // '
    str = str.replaceAll("\"", "&quot;");  // "
    
    return str;
  }
  
  public static synchronized String getString(HttpServletRequest request, String variable) {
    String value = "";

    variable = request.getParameter(variable);
    if (variable != null) {
      variable = variable.trim();
      if (variable.length() > 0) {
        value = variable;
      }

    } else {
      value = variable;
    }

    return value;
  }

  public static synchronized int getInt(HttpServletRequest request, String variable) {
    int value = 0;

    variable = request.getParameter(variable);
    if (variable != null) {
      variable = variable.trim();
      if (variable.length() > 0) {
        value = Integer.parseInt(variable);
      }
    } else {
      value = 0;
    }

    return value;
  }

  // 以� 諛붽씀湲�
  public static synchronized String getConvertCharTextArea(String str) {
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == '&') {
        str = str.substring(0, i) + "&" + str.substring(i + 1, str.length());
      }
    }
    return str;
  }

  public static synchronized String convertToDBMSforTextArea(String str) {
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == '<') {
        str = str.substring(0, i) + "<" + str.substring(i + 1, str.length());
      } else if (str.charAt(i) == '>') {
        str = str.substring(0, i) + ">" + str.substring(i + 1, str.length());
      }
    }
    return str;
  }

  public static synchronized String convertToHTMLforTextArea(String str) {
    str.replaceAll("<", "<");
    str.replaceAll(">", ">");

    return str;
  }

  /**
   * 濡쒓렇�씤�븳 愿�由ъ옄 �씤吏� 寃��궗
   * 
   * @param session
   * @return
   */
  public static synchronized boolean isAdmin(HttpServletRequest request) {
    boolean sw = false;

    HttpSession session = request.getSession();
    String s_id = Utility.checkNull((String) session.getAttribute("s_id"));
    // System.out.println("�쁽�옱 濡쒓렇�씤 愿�由ъ옄 s_id: " + s_id);
    if (s_id.equals("") == true) { // 濡쒓렇�씤�븯吏� �븡�� 寃쎌슦
      sw = false;
    } else {
      sw = true;
    }

    return sw;
  }

  /**
   * 濡쒓렇�씤�븳 �궗�슜�옄�씤吏� 寃��궗
   * 
   * @param request
   * @return
   */
  public static synchronized boolean isMember(HttpServletRequest request) {
    boolean sw = false;

    HttpSession session = request.getSession();
    String s_member_id = Utility.checkNull((String) session
        .getAttribute("s_member_id"));
    // System.out.println("�쁽�옱 濡쒓렇�씤 �궗�슜�옄 s_member_id: " + s_member_id);
    if (s_member_id.equals("") == true) { // 濡쒓렇�씤�븯吏� �븡�� 寃쎌슦
      sw = false;
    } else {
      sw = true;
    }

    return sw;
  }

  /**
   * 濡쒓렇�씤�븳 �궗�슜�옄 �씤吏� 寃��궗
   * 
   * @param session
   * @return
   */
  public static synchronized boolean isUser(HttpServletRequest request) {
    boolean sw = false;

    HttpSession session = request.getSession();
    String s_member_id = Utility.checkNull((String) session
        .getAttribute("s_member_id"));
    if (s_member_id.length() > 1) { // 濡쒓렇�씤�븯吏� �븡�� 寃쎌슦
      sw = true;
    } else {
      sw = false;
    }

    return sw;
  }

  public static synchronized boolean checkImageFile(String filename) {
    boolean sw = false;

    if (filename != null) {
      sw = filename.endsWith(".jpg") || filename.endsWith(".jpeg")
          || filename.endsWith(".gif") || filename.endsWith(".png")
          || filename.endsWith(".bmp");
    }

    return sw;
  }

  public static synchronized String getBrowser(HttpServletRequest request) {
    String header = request.getHeader("User-Agent");
    if (header.indexOf("MSIE") > -1) {
      return "MSIE";
    } else if (header.indexOf("Chrome") > -1) {
      return "Chrome";
    } else if (header.indexOf("Opera") > -1) {
      return "Opera";
    }
    return "Firefox";
  }

  public static synchronized String getDisposition(String filename, String browser) {
    String dispositionPrefix = "attachment;filename=";
    String encodedFilename = null;
    try {
      if (browser.equals("MSIE")) {
        encodedFilename = URLEncoder.encode(filename, "UTF-8").replaceAll(
            "\\+", "%20");
      } else if (browser.equals("Firefox")) {
        encodedFilename =

        "\"" + new String(filename.getBytes("UTF-8"), "8859_1") + "\"";
      } else if (browser.equals("Opera")) {
        encodedFilename =

        "\"" + new String(filename.getBytes("UTF-8"), "8859_1") + "\"";
      } else if (browser.equals("Chrome")) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < filename.length(); i++) {
          char c = filename.charAt(i);
          if (c > '~') {
            sb.append(URLEncoder.encode("" + c, "UTF-8"));
          } else {
            sb.append(c);
          }
        }
        encodedFilename = sb.toString();
      } else {
        System.out.println("Not supported browser");
      }
    } catch (Exception e) {

    }

    return dispositionPrefix + encodedFilename;
  }

  /**
   * �엫�쓽�쓽 �젙�닔瑜� 由ы꽩�빀�땲�떎.
   * 
   * @param range
   *          �젙�닔踰붿쐞 0 ~ 踰붿쐞-1
   * @return �궃�닔 由ы꽩
   */
  public static synchronized int random(int range) {
    // 0 ~ range-1源뚯� �궛異쒕맖.
    int rnd = 0;
    Random random = new Random();
    rnd = random.nextInt(range);

    return rnd;
  }

  public static synchronized Date getDate(String date) {
    Date currentTime = new Date();
    SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
    try {
      currentTime = sd.parse(date);
    } catch (Exception e) {
    }
    // System.out.println(date);
    return currentTime;
  }

  public static synchronized String progress(String enddate) {
    java.util.Date nowtime = new java.util.Date();
    java.util.Date endtime = getDate(enddate);

    // System.out.println("nowtime: " + nowtime.toLocaleString());
    // System.out.println("endtime: " + nowtime.toLocaleString());
    String progress = null;

    if (nowtime.after(endtime) == true) {
      progress = "醫낅즺";
    } else {
      progress = "吏꾪뻾";
    }

    return progress;
  }

  /**
   * 泥쒕떒�쐞留덈떎 而대쭏瑜� 異쒕젰�빀�땲�떎.
   * 
   * @param price
   *          湲덉븸
   * @return 而대쭏媛� �룷�븿�맂 臾몄옄�뿴
   */
  public static synchronized String comma(int price) {
    DecimalFormat comma = new DecimalFormat("###,##0");
    String cs = comma.format(price);

    return cs;
  }

  public static synchronized String comma(long price) {
    DecimalFormat comma = new DecimalFormat("###,##0");
    String cs = comma.format(price);

    return cs;
  }

  /**
   * null 臾몄옄瑜� 怨듬갚 臾몄옄濡� 蹂�寃쏀빀�땲�떎.
   * 
   * @param str
   *          寃��궗�븷 臾몄옄�뿴
   * @return null 媛믪쓣 媛�吏�怨� �엳�뒗 媛앹껜�뒗 怨듬갚 臾몄옄�뿴濡� 由ы꽩�맖
   */
  public static synchronized String checkNull(String str) {
    if (str == null) {
      return "";  // null �씠硫� 鍮덇났諛깆쑝濡� 由ы꽩
    } else {
      return str; // �썝�옒�쓽 臾몄옄�뿴 由ы꽩
    }
  }

  /**
   * request 媛앹껜�뿉�꽌 臾몄옄�뿴�쓣 異붿텧�빀�땲�떎.
   * 
   * @param request
   * @param str
   *          異붿텧�븷 蹂��닔
   * @return 蹂��솚�맂 臾몄옄�뿴
   */
  public static synchronized String checkNull(HttpServletRequest request, String str) {
    String rstr = "";

    if (request.getParameter(str) != null) {
      rstr = request.getParameter(str);
    } else {
      rstr = "";
    }

    return rstr;
  }

  /**
   * 臾몄옄�뿴�씠 Object ���엯�쑝濡� �쟾�넚�맂 寃껋쓣 null 泥섎━
   * 
   * @param str
   * @return
   */
  public static String checkNull(Object str) {
    if ((String) str == null) {
      return "";
    } else {
      return (String) str;
    }
  }

  /**
   * FileUpload 1.2 �븳湲� 蹂��솚
   * 
   * @param str
   * @return
   */
  public static synchronized String getEncodFileUpload12(String str) {
    String corean = null;
    try {
      corean = new String(str.getBytes("ISO-8859-1"), "UTF-8");
      // corean= new String(str.getBytes("ISO-8859-1"), "KSC5601");
    } catch (Exception e) {
      return corean;
    }
    return corean;
  }

  /**
   * MVC, Tomcat 7.0湲곕컲 JSP �럹�씠吏� �븳湲� 蹂��솚
   * 
   * @param str
   * @return
   */
  public static synchronized String getEncodeMVC(String str) {
    String corean = null;
    try {
      corean = new String(str.getBytes("ISO-8859-1"), "UTF-8");
      // corean= new String(str.getBytes("ISO-8859-1"), "KSC5601");
    } catch (Exception e) {
      return corean;
    }
    return corean;
  }

  /**
   * fileupload 1.2.2 �븳湲� 泥섎━
   * 
   * @param ko
   * @return
   */
  public static synchronized String fileupload122Enc(String ko) {
    String corean = null;
    try {
      // corean= new String(ko.getBytes("8859_1"), "euc-kr");
      corean = new String(ko.getBytes("ISO-8859-1"), "utf-8");
      // corean= new String(ko.getBytes("8859_1"), "iso-8859-1");
      // corean= new String(ko.getBytes("utf-8"), "8859_1");
      // corean= new String(ko.getBytes("8859_1"), "KSC5601");
    } catch (Exception e) {
      return corean;
    }
    return corean;
  }

  /**
   * fileupload 1.2.2 �븳湲� 泥섎━
   * 
   * @param ko
   * @return
   */
  public static synchronized String fileupload122DownEnc(String ko) {
    // charsetTest(ko);

    String corean = null;
    try {
      // corean= new String(ko.getBytes("iso-8859-1"), "euc-kr");
      // corean= new String(ko.getBytes("iso-8859-1"), "utf-8");
      // corean= new String(ko.getBytes("8859_1"), "iso-8859-1");
      // corean= new String(ko.getBytes("utf-8"), "8859_1");
      // corean= new String(ko.getBytes("iso-8859-1"), "KSC5601");
      corean = new String(ko.getBytes("KSC5601"), "EUC-KR");
    } catch (Exception e) {
      return corean;
    }
    return corean;
  }

  public static synchronized String getType(String fileUrl) {
    String type = "";
    fileUrl = "file:" + fileUrl;
    try {
      URL u = new URL(fileUrl);
      URLConnection uc = u.openConnection();
      type = uc.getContentType();

    } catch (Exception e) {
      System.out.println(e.toString());
    }

    return type;
  }

  /**
   * 二쇱뼱吏� 臾몄옄�뀑�쓽 臾몄옄肄붾뱶瑜� 蹂��솚�빀�땲�떎.
   * 
   * @param ko
   * @return
   */
  public static synchronized String ko(String ko) {
    String str = null;
    try {
      // corean= new String(ko.getBytes("8859_1"), "euc-kr");
      // corean= new String(ko.getBytes("8859_1"), "utf-8");
      // corean= new String(ko.getBytes("8859_1"), "iso-8859-1");
      // corean= new String(ko.getBytes("8859_1"), "utf-8");
      str = new String(ko.getBytes("8859_1"), "KSC5601");
      for (int i = 0; i < str.length(); i++) {
        if (str.charAt(i) == ' ') {
          str = str.substring(0, i) + "%20"
              + str.substring(i + 1, str.length());
          i = i + 3;
        }
      }

    } catch (Exception e) {

    }
    return str;
  }

  /**
   * �궡�슜以묒뿉 �듅�닔臾몄옄 �몴�쁽�쓣 �쐞�빐 HTML �듅�닔臾몄옄濡� 蹂��솚�빀�땲�떎.
   */
  public static synchronized String getConvertBR(String str) {
    return str.replace("\n", "<BR>");
  }

  /**
   * �뙆�씪 Download�떆 �븳湲� �뙆�씪 �씤肄붾뵫
   * 
   * @param str
   * @return
   */
  public static synchronized String getEncod(String str) {
    try {
      // resin UTF-8 濡� 吏��젙
      // str = java.net.URLEncoder.encode(str, "EUC-KR");
      // str = java.net.URLEncoder.encode(str, "UTF-8");
      str = java.net.URLEncoder.encode(str, "KSC5601");
    } catch (Exception e) {

    }

    // System.out.println(str);

    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == '+') {
        str = str.substring(0, i) + "%20" + str.substring(i + 1, str.length());
        i = i + 3;
      }
    }
    // System.out.println("理쒖쥌蹂��솚 �삎�깭: "+str);
    return str;
  }

  /**
   * Struts2 GET諛⑹떇 �븳湲� 臾몄옄�뀑 �씤肄붾뵫
   * 
   * @param str
   * @return
   */
  public static synchronized String getEncodGet(String str) {
    try {

      str = java.net.URLEncoder.encode(str, "EUC-KR");
      // str = java.net.URLEncoder.encode(str, "UTF-8");
      // str = java.net.URLEncoder.encode(str, "KSC5601");

      for (int i = 0; i < str.length(); i++) {
        if (str.charAt(i) == '+') {
          str = str.substring(0, i) + "%20"
              + str.substring(i + 1, str.length());
          i = i + 3;
        }
      }
    } catch (Exception e) {

    }

    return str;
  }

  /**
   * �뒪�듃�읉痢� �옄猷뚯떎 �븳湲� 異쒕젰 硫붿냼�뱶
   * 
   * @param str
   * @return
   */
  public static synchronized String encodStruts2(String str) {
    try {
      // str = java.net.URLEncoder.encode(str, "EUC-KR");
      // str = java.net.URLEncoder.encode(str, "UTF-8");
      str = java.net.URLEncoder.encode(str, "KSC5601");

      for (int i = 0; i < str.length(); i++) {
        if (str.charAt(i) == '+') {
          str = str.substring(0, i) + "%20"
              + str.substring(i + 1, str.length());
          i = i + 3;
        }
      }
    } catch (Exception e) {

    }

    return str;
  }

  /**
   * FCKEditor 2.6.8 �븳湲� 蹂��솚
   * 
   * @param str
   * @return
   */
  public static synchronized String encodFCK268(String str) {
    String corean = null;
    try {
      corean = new String(str.getBytes("ISO-8859-1"), "UTF-8");
      // corean= new String(str.getBytes("ISO-8859-1"), "KSC5601");
    } catch (Exception e) {
      return corean;
    }
    return corean;
  }

  /**
   * �뙆�씪�쓣 �궘�젣�빀�땲�떎.
   * 
   * @param folder
   *          �뙆�씪�씠 ���옣�맂 �뤃�뜑
   * @param filename
   *          �궘�젣�븷 �뙆�씪紐�
   * @return true-�궘�젣 �꽦怨�, false-�궘�젣 �떎�뙣
   */
  public static synchronized boolean deleteFile(String folder, String filename) {
    boolean ret = false;

    try {
      if (filename != null) { // 湲곗〈�뿉 �뙆�씪�씠 議댁옱�븯�뒗 寃쎌슦 �궘�젣
        File file = new File(folder + "/" + filename);
        // �뙆�씪�씠 議댁옱�븯�뒗吏� �솗�씤 �썑 �궘�젣
        if (file.exists()) {
          ret = file.delete();
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return ret;
  }

  /**
   * application�씠由꾩쓣 �엯�젰諛쏆븘 �젅�� 寃쎈줈瑜� �궛異쒗빀�땲�떎. �삁) getRealPath(request, "WEB-INF/config")
   * 
   * @param request
   * @param dir
   *          application �씠由�
   * @return �젅�� 寃쎈줈 由ы꽩
   * @throws IOException
   */
  public static synchronized String getRealPath(HttpServletRequest request, String dir) {
    // ByteArrayOutputStream baos = new ByteArrayOutputStream();
    String path = "";
    
    try{
      path = request.getRealPath(dir) + "/";  
      System.out.println("Upload path: " + path);
    }catch(Exception e){
      System.out.println(e.toString());
    }

    return path;
  }

  /**
   * �븳湲� 蹂��솚 肄붾뱶瑜� 李얜뒗 湲곕뒫�쓣 吏��썝
   * 
   * @param s
   */
  public static synchronized void charsetTest(String s) {
    try {
      String[] charset = { "EUC-KR", "KSC5601", "ISO-8859-1", "8859_1",
          "ASCII", "UTF-8" };
      for (int i = 0; i < charset.length; i++) {
        for (int j = 0; j < charset.length; j++) {
          if (i == j)
            continue;
          System.out.print(charset[i] + " -> " + charset[j] + " : ");
          System.out.println(new String(s.getBytes(charset[i]), charset[j]));
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * null 臾몄옄瑜� �닽�옄 0�쑝濡� 蹂�寃쏀빀�땲�떎.
   * 
   * @param request
   *          request 媛앹껜
   * @param str
   *          寃��궗�븷 臾몄옄�뿴
   * @return �닽�옄瑜� 由ы꽩
   */
  public static synchronized int checkInt(HttpServletRequest request, String str) {
    int su = 0;
    if (request.getParameter(str) != null) {
      su = Integer.parseInt(request.getParameter(str));
    }

    return su;
  }

  public static int checkInt(String str) {
    int su = 0;
    if (str != null) {
      su = Integer.parseInt(str);
    }

    return su;
  }

  /**
   * null 臾몄옄瑜� �닽�옄 0�쑝濡� 蹂�寃쏀빀�땲�떎.
   * 
   * @param request
   *          request 媛앹껜
   * @param str
   *          寃��궗�븷 臾몄옄�뿴
   * @return �닽�옄瑜� 由ы꽩
   */
  public static synchronized int checkAttrInt(HttpServletRequest request, String str) {
    int su = 0;
    if (request.getAttribute(str) != null) {
      Integer itg = (Integer) (request.getAttribute(str));
      su = itg.intValue();
    }

    return su;
  }

  /**
   * Ajax �븳湲� 蹂��솚
   * 
   * @param ko
   * @return
   */
  public static synchronized String koAjax(String ko) {
    String corean = null;
    try {
      // corean= new String(ko.getBytes("ISO-8859-1"), "UTF-8");
      corean = new String(ko.getBytes("KSC5601"), "EUC-KR");
    } catch (Exception e) {
      return corean;
    }
    return corean;
  }

  /**
   * �옄諛붿뒪�겕由쏀듃 �듅�닔臾몄옄, 以꾨컮轅� 臾몄옄 蹂��솚
   * 
   * @param str
   * @return
   */
  public static synchronized String toJS(String str) {
    if (str != null) {
      return str.replace("\\", "\\\\").replace("\'", "\\\'")
          .replace("\"", "\\\"").replace("\r\n", "\\n").replace("\n", "\\n");

    } else {
      return "";
    }
  }

  /**
   * Ajax �븳湲� 蹂��솚
   * 
   * @param ko
   * @return
   */
  public static synchronized String koAndroid(String ko) {
    String corean = null;
    try {
      // corean= new String(ko.getBytes("UTF-8"), "EUC-KR");
      // corean= new String(ko.getBytes("ISO-8859-1"), "UTF-8");
      // corean= new String(ko.getBytes("KSC5601"), "EUC-KR");
      corean = new String(ko.getBytes("8859_1"), "UTF-8");
    } catch (Exception e) {
      return corean;
    }
    return corean;
  }

  /**
   * 臾몄옄�뿴 寃쎈줈瑜� 諛쏆븘 紐⑤뱺 �뙆�씪 紐⑸줉�쓣 由ы꽩
   * 
   * @param dir
   * @return
   */
  public static synchronized String[] fileNameList(String dir) {
    File sdDir = null;
    String[] str = null;

    try {
      // Check SD Card mount.
      sdDir = new File("."); // /sdcard
      // 議댁옱/�벐湲� �뿬遺� �솗�씤
      if (sdDir.exists() && sdDir.canWrite()) {
        File _dir = new File(dir);
        if (_dir.exists() && _dir.canRead()) {
          str = _dir.list();
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return str;
  }

  /**
   * �뙆�씪 媛앹껜瑜� 諛쏆븘 �뙆�씪 紐⑸줉�쓣 由ы꽩
   * 
   * @param dir
   * @return
   */
  public static synchronized String[] fileNameList(File dir) {
    String[] str = null;

    try {
      str = dir.list();
    } catch (Exception e) {
      e.printStackTrace();
    }

    return str;
  }

  /**
   * �뙆�씪 紐⑸줉�뿉�꽌 �솗�옣�옄瑜� �젣嫄고븿
   * 
   * @param str
   * @return
   */
  public static synchronized ArrayList convertFilenameNotExtend(String[] str) {
    ArrayList retVal = new ArrayList();
    ;

    for (int i = 0; i < str.length; i++) {
      int point = str[i].indexOf(".");
      retVal.add(str[i].substring(0, point));
    }

    return retVal;
  }

  /**
   * �뙆�씪�뿉�꽌 �솗�옣�옄瑜� �젣嫄고븿. �삁) data.txt --> data
   * 
   * @param str
   * @return
   */
  public static synchronized String convertFilenameNotExtend(String str) {
    String noExt = "";
    int point = str.indexOf(".");
    noExt = str.substring(0, point);

    return noExt;
  }

  // �뤃�뜑瑜� �깮�꽦
  public static synchronized void makeFolder(String _dir) {
    File sdDir = null; // �뤃�뜑紐�
    File dir = null;

    sdDir = new File(".");
    dir = new File(sdDir.toString() + "/" + _dir);

    if (sdDir.exists() && sdDir.canWrite()) {
      if (dir.exists() == false) {
        dir.mkdir();
      }
    }

  }

  public static synchronized String onlyFilename(String _str) {
    // /sdcard/smartalbum/20101201_090101.jpg
    int ps = _str.lastIndexOf("/");
    // System.out.println("ps: " + ps);

    String str = _str.substring(ps + 1); // 20101201_090101.jpg

    int pd = str.lastIndexOf(".");
    System.out.println("pd: " + pd);

    str = str.substring(0, pd);

    return str;
  }

  public static synchronized String convertFilename(String str) {
    // 20101201_090101
    // 012345678901234
    // 2010�뀈 12�썡 1�씪 09�떆 01遺� 01珥�
    String year = str.substring(0, 4);
    String month = str.substring(4, 6);
    String day = str.substring(6, 8);
    String hour = str.substring(9, 11);
    String minute = str.substring(11, 13);
    String second = str.substring(13);

    String _str = year + "�뀈 " + month + "�썡 " + day + "�씪 " + hour + "�떆 "
        + minute + "遺� " + second + "珥� ";

    return _str;
  }

  /**
   * �뙆�씪 �궘�젣
   * @param fname
   * @return
   */
  public static synchronized boolean deleteFile(String fname) {
    File file = new File(fname);
    boolean ret = false;
    
    if (file.exists()){
      ret = file.delete();
    }
    
    return ret;
  }

  /**
   * 諛붿씠�듃諛곗뿴濡� �릺�뼱 �엳�뒗 臾몄옄�뿴�쓣 諛쏆븘 �썝�옒�쓽 臾몄옄�뿴濡� 蹂��솚
   * 
   * @param str
   * @return
   */
  public static synchronized String byteToString(String str) {
    String retVal = "";

    try {
      StringTokenizer st = new StringTokenizer(str, ",");
      byte[] _str = new byte[st.countTokens()];
      int i = -1;

      while (st.hasMoreTokens()) {
        i++;
        _str[i] = Byte.parseByte(st.nextToken());
      }
      retVal = new String(_str, 0, _str.length, "UTF-8");
    } catch (Exception e) {

    }

    return retVal;
  }

  /**
   * 臾몄옄�뿴�쓣 諛붿씠�듃 諛곗뿴 臾몄옄�뿴濡� 蹂��솚
   * 
   * @param str
   * @return
   */
  public static synchronized String stringToByte(String str) {
    String deli = ","; // 援щ텇�옄
    String retVal = "";
    try {
      byte[] bstr = str.getBytes("UTF-8");

      for (int i = 0; i < bstr.length; i++) {
        retVal = retVal + deli + bstr[i];
      }
    } catch (Exception e) {

    }
    return retVal;

  }

  /**
   * �쁽�옱 �떆媛꾩쓣 1970�뀈 1�썡 1�씪遺��꽣 �닔移섑삎�떇�쑝濡� 由ы꽩
   * 
   * @return
   */
  public static synchronized long getTimeNumber() {
    long time = System.currentTimeMillis();

    return time;
  }

  /**
   * 二쇱뼱吏� �떆媛꾩쓣 1970�뀈 1�썡 1�씪遺��꽣 �닔移섑삎�떇�쑝濡� 由ы꽩
   * 
   * @return
   */
  public static synchronized long getTimeNumber(String date) {
    Date _date = new Date();
    SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
    try {
      _date = sd.parse(date);
    } catch (Exception e) {
    }
    // System.out.println(date);
    long time = _date.getTime();

    return time;
  }

  /**
   * 二쇱뼱吏� �궇吏쒖� 湲곌컙�쓣 怨꾩궛�븯�뿬 �깉湲� �뿬遺� �뙋�떒 �쁽�옱 �궇吏쒓� 2013-02-04 湲��쓣 �벑濡앸궇吏� 2013-02-02
   * getTimeNew("2013-02-04", 2) : �깉湲� 泥섎━, true getTimeNew("2013-02-04", 3) : �깉湲�
   * 泥섎━, false
   * 
   * @param date
   *          臾몄옄�뿴濡� �맂 �궇吏�
   * @param period
   *          �깉湲�濡� 吏��젙�븷 湲곌컙
   * @return
   */
  public static synchronized boolean getTimeNew(String date, int period) {
    boolean sw = false;

    Date _date = new Date();
    SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
    try {
      _date = sd.parse(date);
    } catch (Exception e) {
    }
    // System.out.println(date);
    // 1970�뀈1�썡1�씪遺��꽣 �떆媛꾩쓣 1000�쓣 1珥덈줈�븯�뿬 怨꾩궛�븯�뿬 由ы꽩
    long time = _date.getTime(); // 湲��쓣 �옉�꽦�븳 �떆媛�

    // �쁽�옱 �떆媛꾩쓣 1970�뀈 1�썡 1�씪遺��꽣 �닔移섑삎�떇�쑝濡� 由ы꽩
    long currentTime = System.currentTimeMillis();

    // �쁽�옱 �떆媛꾧낵 湲� �벑濡앹떆媛꾩쓽 李⑥씠瑜� 怨꾩궛
    long diff = currentTime - time;

    // 1�씪 86,400,000: 1珥덈�� 1000�쑝濡� �븯猷⑤�� 怨꾩궛
    // 0.0001 --> 1: �삤�뒛 �궇吏�
    // 1.00002 --> 2: �뼱�젣 �궇吏�
    int day = (int) Math.ceil(((double) diff / 86400000));

    if (day <= period) {
      sw = true; // 理쒖떊湲� 泥섎━
    }
    return sw;
  }

  /**
   * �씠誘몄� �궗�씠利덈�� 蹂�寃쏀븯�뿬 �깉濡쒖슫 �씠誘몄�瑜� �깮�꽦�빀�땲�떎. �썝蹂� �씠誘몄��뒗 異뺤냼�썑 �궘�젣�빀�땲�떎.
   * 
   * @param dir
   *          湲곗� �뤃�뜑
   * @param _src
   *          �썝蹂� �씠誘몄�
   * @param width
   *          �깮�꽦�맆 �씠誘몄� �꼫鍮�
   * @param height
   *          �깮�꽦�맆 �씠誘몄� �넂�씠, ImageUtil.RATIO�뒗 �옄�룞 鍮꾨� 鍮꾩쑉
   * @throws IOException
   */
  public static synchronized String imgResize(String dir, String filename, int width,
      int height) throws IOException {

    File src = new File(dir + "/" + filename);
    File dest = new File(dir + "/" + Utility.convertFilenameNotExtend(filename)
        + "_s.jpg");

    int RATIO = 0;
    int SAME = -1;

    Image srcImg = null;
    // �뙆�씪�쓽 �솗�옣�옄 異붿텧
    String suffix = src.getName().substring(src.getName().lastIndexOf('.') + 1)
        .toLowerCase();
    // �씠誘몄��쓽 �솗�옣�옄瑜� 寃��깋�븯�뿬 �씠誘몄� �뙆�씪�씤吏� 寃��궗
    if (suffix.equals("jpg") || suffix.equals("bmp") || suffix.equals("png")
        || suffix.equals("gif")) {
      srcImg = ImageIO.read(src); // 硫붾え由ъ뿉 �씠誘몄� �깮�꽦
    } else {
      srcImg = new ImageIcon(src.getAbsolutePath()).getImage();
    }

    int srcWidth = srcImg.getWidth(null); // �썝蹂� �씠誘몄� �꼫鍮� 異붿텧
    int srcHeight = srcImg.getHeight(null); // �썝蹂� �씠誘몄� �넂�씠 異붿텧

    int destWidth = -1, destHeight = -1; // ���긽 �씠誘몄� �겕湲� 珥덇린�솕

    if (width == SAME) { // �꼫鍮꾧� 媛숈� 寃쎌슦
      destWidth = srcWidth;
    } else if (width > 0) {
      destWidth = width;
    }

    if (height == SAME) { // �넂�씠媛� 媛숈� 寃쎌슦
      destHeight = srcHeight;
    } else if (height > 0) {
      destHeight = height;
    }

    // 鍮꾩쑉�뿉 �뵲瑜� �겕湲� 怨꾩궛
    if (width == RATIO && height == RATIO) {
      destWidth = srcWidth;
      destHeight = srcHeight;
    } else if (width == RATIO) {
      double ratio = ((double) destHeight) / ((double) srcHeight);
      destWidth = (int) ((double) srcWidth * ratio);
    } else if (height == RATIO) {
      double ratio = ((double) destWidth) / ((double) srcWidth);
      destHeight = (int) ((double) srcHeight * ratio);
    }

    // 硫붾え由ъ뿉 ���긽 �씠誘몄� �깮�꽦
    Image imgTarget = srcImg.getScaledInstance(destWidth, destHeight,
        Image.SCALE_SMOOTH);
    int pixels[] = new int[destWidth * destHeight];
    PixelGrabber pg = new PixelGrabber(imgTarget, 0, 0, destWidth, destHeight,
        pixels, 0, destWidth);
    try {
      pg.grabPixels();
    } catch (InterruptedException e) {
      throw new IOException(e.getMessage());
    }
    BufferedImage destImg = new BufferedImage(destWidth, destHeight,
        BufferedImage.TYPE_INT_RGB);
    destImg.setRGB(0, 0, destWidth, destHeight, pixels, 0, destWidth);

    // �뙆�씪�뿉 湲곕줉
    ImageIO.write(destImg, "jpg", dest);

    System.out.println(dest.getName() + " �씠誘몄�瑜� �깮�꽦�뻽�뒿�땲�떎.");

    // �썝蹂� �뙆�씪 �궘�젣
    boolean ret = Utility.deleteFile(dir + "/" + filename);
    if (ret == true) {
      System.out.println("�뙆�씪�쓣 �궘�젣 �뻽�뒿�땲�떎.: " + filename);
    }

    return dest.getName();
  }

  /**
   * �씠誘몄� �궗�씠利덈�� 蹂�寃쏀븯�뿬 �깉濡쒖슫 �씠誘몄�瑜� �깮�꽦�빀�땲�떎.
   * 
   * @param src
   *          �썝蹂� �씠誘몄�
   * @param dest
   *          �깮�꽦�릺�뒗 �씠誘몄�
   * @param width
   *          �깮�꽦�맆 �씠誘몄� �꼫鍮�
   * @param height
   *          �깮�꽦�맆 �씠誘몄� �넂�씠, ImageUtil.RATIO�뒗 �옄�룞 鍮꾨� 鍮꾩쑉
   * @throws IOException
   */
  public static synchronized String imgResize(File src, File dest, int width, int height)
      throws IOException {
    int RATIO = 0;
    int SAME = -1;

    Image srcImg = null;
    // �뙆�씪�쓽 �솗�옣�옄 異붿텧
    String suffix = src.getName().substring(src.getName().lastIndexOf('.') + 1)
        .toLowerCase();
    // �씠誘몄��쓽 �솗�옣�옄瑜� 寃��깋�븯�뿬 �씠誘몄� �뙆�씪�씤吏� 寃��궗
    if (suffix.equals("jpg") || suffix.equals("bmp") || suffix.equals("png")
        || suffix.equals("gif")) {
      srcImg = ImageIO.read(src); // 硫붾え由ъ뿉 �씠誘몄� �깮�꽦
    } else {
      srcImg = new ImageIcon(src.getAbsolutePath()).getImage();
    }

    int srcWidth = srcImg.getWidth(null); // �썝蹂� �씠誘몄� �꼫鍮� 異붿텧
    int srcHeight = srcImg.getHeight(null); // �썝蹂� �씠誘몄� �넂�씠 異붿텧

    int destWidth = -1, destHeight = -1; // ���긽 �씠誘몄� �겕湲� 珥덇린�솕

    if (width == SAME) { // �꼫鍮꾧� 媛숈� 寃쎌슦
      destWidth = srcWidth;
    } else if (width > 0) {
      destWidth = width;
    }

    if (height == SAME) { // �넂�씠媛� 媛숈� 寃쎌슦
      destHeight = srcHeight;
    } else if (height > 0) {
      destHeight = height;
    }

    // 鍮꾩쑉�뿉 �뵲瑜� �겕湲� 怨꾩궛
    if (width == RATIO && height == RATIO) {
      destWidth = srcWidth;
      destHeight = srcHeight;
    } else if (width == RATIO) {
      double ratio = ((double) destHeight) / ((double) srcHeight);
      destWidth = (int) ((double) srcWidth * ratio);
    } else if (height == RATIO) {
      double ratio = ((double) destWidth) / ((double) srcWidth);
      destHeight = (int) ((double) srcHeight * ratio);
    }

    // 硫붾え由ъ뿉 ���긽 �씠誘몄� �깮�꽦
    Image imgTarget = srcImg.getScaledInstance(destWidth, destHeight,
        Image.SCALE_SMOOTH);
    int pixels[] = new int[destWidth * destHeight];
    PixelGrabber pg = new PixelGrabber(imgTarget, 0, 0, destWidth, destHeight,
        pixels, 0, destWidth);
    try {
      pg.grabPixels();
    } catch (InterruptedException e) {
      throw new IOException(e.getMessage());
    }
    BufferedImage destImg = new BufferedImage(destWidth, destHeight,
        BufferedImage.TYPE_INT_RGB);
    destImg.setRGB(0, 0, destWidth, destHeight, pixels, 0, destWidth);

    // �뙆�씪�뿉 湲곕줉
    ImageIO.write(destImg, "jpg", dest);

    System.out.println(dest.getName() + " �씠誘몄�瑜� �깮�꽦�뻽�뒿�땲�떎.");

    return dest.getName();
  }

  /**
   * FileUpload 1.2 �븳湲� 蹂��솚
   * 
   * @param str
   * @return
   */
  public static synchronized String encodFileUpload12(String str) {
    String corean = null;
    try {
      corean = new String(str.getBytes("ISO-8859-1"), "UTF-8");
      // corean= new String(str.getBytes("ISO-8859-1"), "KSC5601");
    } catch (Exception e) {
      return corean;
    }
    return corean;
  }

  /**
   * �씠誘몄��씤吏� 寃��궗
   * @param filename
   * @return
   */
  public static synchronized boolean isImage(String filename) {
    boolean sw = false;

    if (filename != null) {
      filename = filename.toLowerCase();
      sw = filename.endsWith(".jpg") || filename.endsWith(".jpeg")
          || filename.endsWith(".gif") || filename.endsWith(".png")
          || filename.endsWith(".bmp");
    }

    return sw;
  }

  public static synchronized String trim(String str, int length) {
    String _str = "";
    if (str.length() > length) {
      _str = str.substring(0, length);
    } else {
      _str = str;
    }

    return _str;
  }

}//class end
