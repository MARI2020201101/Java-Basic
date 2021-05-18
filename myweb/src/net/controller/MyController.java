package net.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.action.CommandAction;

public class MyController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	private Map<String, CommandAction> commandMap = new HashMap<>();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		//init-param으로 설정해둔 properties 가져오기
		String props = config.getInitParameter("propertyConfig");
		System.out.println("properties : " + props);
		
		//해당 property파일을 inputStream으로 읽기. 
		//Properties : Map + inputStream 기능  
		Properties properties = new Properties();
		try(InputStream in = new FileInputStream(props)){
			properties.load(in);
		}catch(Exception e) {
			System.out.println("InputStream err :" + e);
		}
		
		//읽어온 properties파일 안의 내용을 key-value로 나눈다
		Iterator<?> iter = properties.keySet().iterator();
		while(iter.hasNext()) {
			String key = (String) iter.next();
			String value = properties.getProperty(key);
			System.out.println("value : " + value);
			try{
				//reflection이용해서 value를 실제 object로 바꿈, map에 저장
				Class<?> commandClass = Class.forName(value);
				CommandAction instance = (CommandAction) commandClass.getDeclaredConstructor().newInstance();
				commandMap.put(key, instance);
			}catch(Exception e) {
				System.out.println("No such Class Err : "+e);
			}
			
		}
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req,resp);
	}

	protected void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		//실제 request들어왔을때 map안에 있는 servlet 담당view String으로 가져옴
		try {
			String uri = req.getRequestURI();
			CommandAction commandServlet=commandMap.get(uri);
			String view =commandServlet.requestPro(req, resp);
			
			System.out.println("commandServlet.getClass().getName() :" + commandServlet.getClass().getName());
			/*if(commandServlet.getClass().getName().contains("Pro")) {
				resp.sendRedirect(view);
			}else {*/
				RequestDispatcher rd = req.getRequestDispatcher(view);	
				rd.forward(req, resp);
				/*
				 * }
				 */
		} catch (Exception e) {
			System.out.println("requestProcess Exception : "+ e);
		}	
		
	}

}
