package net.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.action.CommandAction;

public class MyController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	private HashMap<String, Object> commandMap;
	
	@SuppressWarnings("deprecation")
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
		
		//읽어온 properties파일 안의 내용을 key-value로 나누어서 commandMap에 저장
		Iterator iter = properties.keySet().iterator();
		if(iter.hasNext()) {
			String key = (String) iter.next();
			String value = properties.getProperty(key);
			System.out.println("value : " + value);
			try{
				Class<?> commandClass = Class.forName(value);
				System.out.println(commandClass.getName());

				Object instance = commandClass.getDeclaredConstructor().newInstance();
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

	public void process(HttpServletRequest req, HttpServletResponse resp){
		String uri = req.getRequestURI();
		CommandAction commandServlet = (CommandAction) commandMap.get(uri);
		try {
			commandServlet.requestPro(req, resp);
		} catch (Exception e) {
			System.out.println("Servlet Exception : "+ e);
		}
		
		
		
	}
	
	
	/*
	 * @Override public void init() throws ServletException {
	 * System.out.println("MyController init..."); }
	 * 
	 * @Override protected void service(HttpServletRequest arg0, HttpServletResponse
	 * arg1) throws ServletException, IOException {
	 * System.out.println("MyController...."); super.service(arg0, arg1); }
	 */

}
