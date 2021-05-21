package net.bbs2;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.action.CommandAction;
import net.utility.Utility;

public class BbsInsert implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Exception {

		BoardDataBean bean = new BoardDataBean();
		bean.setContent(request.getParameter("content"));
		bean.setWriter(request.getParameter("writer"));
		bean.setSubject(request.getParameter("subject"));
		bean.setEmail(request.getParameter("email"));
		bean.setPasswd(request.getParameter("passwd"));
		bean.setIp(request.getRemoteAddr());
		bean.setReg_date(new Timestamp(System.currentTimeMillis()));
		bean.setNum(Integer.parseInt(request.getParameter("num")));
		bean.setRe_step(Integer.parseInt(request.getParameter("re_step")));
		bean.setRef(Integer.parseInt(request.getParameter("ref")));
		bean.setRe_level(Integer.parseInt(request.getParameter("re_level")));

		BoardDBBean dao = new BoardDBBean();
		dao.insertArticle(bean);
		request.setAttribute("root", Utility.getRoot());
		return "insertProc.jsp";
		
	}

}
