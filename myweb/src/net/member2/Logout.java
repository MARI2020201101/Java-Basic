package net.member2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.action.CommandAction;
import net.utility.Utility;

public class Logout implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.removeAttribute("s_id");
		session.removeAttribute("s_passwd");
		session.removeAttribute("memid");
		request.setAttribute("root", Utility.getRoot());
		return "logout.jsp";
	}

}
