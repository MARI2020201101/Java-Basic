package net.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginProc extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try{
			req.setCharacterEncoding("UTF-8");
			
			String uid = req.getParameter("uid").trim();
			String upw = req.getParameter("upw").trim();
			
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out = resp.getWriter();

			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset='UTF-8'>");
			out.println("<title>Login</title>");
			out.println("</head>");
			out.println("<body>");		
			
		
			out.println("<h1> 아이디 : "+ uid +"</h1>");
			out.println("<h1> 패스워드 : "+ upw +"</h1>");
			out.println("</body>");	
			out.println("</html>");
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}

	
}
