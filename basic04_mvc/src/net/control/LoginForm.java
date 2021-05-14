package net.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginForm extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//페이지 이동
		
		//1) Redirect 이용
		//resp.sendRedirect("control/loginForm.jsp");

		//2) Forward이용
		String view = "control/loginForm.jsp";
		RequestDispatcher rd = req.getRequestDispatcher(view);
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("login post...");
		super.doPost(req, resp);
	}

}
