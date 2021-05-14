package net.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeCycle extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html; charset=UTF-8");
		out.println("Hello LifeCycle");
		//System.out.println("doGet...");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println("doPost...");
		super.doPost(req, resp);
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		//System.out.println("service...");
		super.service(arg0, arg1);
	}

	@Override
	public void destroy() {
		//System.out.println("destroy...");
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		//System.out.println("init...");
		super.init();
	}

}
