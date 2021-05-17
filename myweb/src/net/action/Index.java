package net.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Index extends HttpServlet implements CommandAction{

	private static final long serialVersionUID = 1L;

	@Override
	public void requestPro(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String view = "/index.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);	
		rd.forward(request, response);
		
	}

}
