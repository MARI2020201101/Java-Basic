package net.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Welcome extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * method- get 방식으로 요청되면 호출됨
		 * req: jsp내장객체 request와 동일
		 * rep: jsp내장객체 response와 동일
		 * */
		
		//html문서로 요청하기 vs 명령어로 요청하기
		
		try {
			
			System.out.println("request.getRequestURL() : "+request.getRequestURL());
			
			int jum =request.getRequestURI().indexOf(".");
			int index = request.getRequestURI().lastIndexOf("/");
			String uri = request.getRequestURI().substring(index+1,jum);
			System.out.println("selected uri :"+uri);
			//단순 문자열 응답(AJAX)
			//resp.setContentType("text/plain; charset=UTF-8");
			//HTML문서 구조로 응답
			resp.setContentType("text/html; charset=UTF-8");
			
			PrintWriter out = resp.getWriter();
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset=\"UTF-8\">");
			out.println("<title>welcome</title>");
			out.println("</head>");
			out.println("<body>");		
			out.println("<h1>hello servlet!</h1>");
			out.println("</body>");	
			out.println("</html>");
		}catch(Exception e) {
			
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
