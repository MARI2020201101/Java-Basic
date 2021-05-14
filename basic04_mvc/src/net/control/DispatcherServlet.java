package net.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DispatcherServlet service....");
		System.out.println("request.getRequestURL() : "+request.getRequestURL());
		int jum =request.getRequestURI().indexOf(".");
		int index = request.getRequestURI().lastIndexOf("/");
		String uri = request.getRequestURI().substring(index+1,jum);
		String view = "control/"+uri+".jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
		//super.service(request, response);
	}

	@Override
	public void destroy() {
		System.out.println("DispatcherServlet destroy....");

		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		System.out.println("DispatcherServlet init....");
		super.init();
	}

}
