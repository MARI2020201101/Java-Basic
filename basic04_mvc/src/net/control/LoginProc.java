package net.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginProc extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req,resp);
	}

	protected void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try{
			req.setCharacterEncoding("UTF-8");
			
			String uid = req.getParameter("uid").trim();
			String upw = req.getParameter("upw").trim();
			
			HttpSession session = req.getSession();
			ServletContext application = req.getServletContext();
			
			if(uid.equals("mari")&&upw.equals("1111")) {
				//로그인 성공시 
				session.setAttribute("s_uid", uid);
				session.setAttribute("s_upw", upw);
				
				application.setAttribute("a_uid", uid);
				application.setAttribute("a_upw", upw);
				
				req.setAttribute("r_uid", uid);
				req.setAttribute("r_upw", upw);
				req.setAttribute("msg", "안녕~");
				
			}else {
				//로그인 실패시
				session.setAttribute("s_uid", "guest");
				session.setAttribute("s_upw", "guest");
				
				application.setAttribute("a_uid", "guest");
				application.setAttribute("a_upw", "guest");
				
				req.setAttribute("r_uid", "guest");
				req.setAttribute("r_upw", "guest");
				req.setAttribute("msg", "게스트 하이~");
			}
			
			String view= "control/loginResult.jsp";
			RequestDispatcher rd = req.getRequestDispatcher(view);
			rd.forward(req,resp);
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
