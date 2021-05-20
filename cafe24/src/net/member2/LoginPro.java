package net.member2;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.action.CommandAction;
import net.utility.Utility;

public class LoginPro implements CommandAction{
private MemberDBBean dao = new MemberDBBean();
	
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		int cnt = dao.login(id,passwd);
		Cookie cookie =null;
		if(cnt!=0) {
			request.setAttribute("id", id);
			request.setAttribute("passwd", passwd);
			HttpSession session = request.getSession();
			session.setAttribute("s_id", id);
			session.setAttribute("s_passwd", passwd);
			
			cookie = new Cookie("c_id",id);
			cookie.setMaxAge(60*60*24*31);
		}else {
			cookie  = new Cookie("c_id","");
			cookie.setMaxAge(0);
		}
		response.addCookie(cookie);
		request.setAttribute("res", cnt);
		//return Utility.getRoot()+"/index.jsp";
		return "loginPro.jsp";
	}

}
