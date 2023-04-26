package com.bjpowernode.servlet;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.ServletConfig;
import java.io.IOException;
import java.io.PrintWriter;


public class HelloServlet implements Servlet {
	public void init(ServletConfig config) throws ServletException {
		
	}
	
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		System.out.println("my first Servlet, hello Servlet...");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		// out.print("server: hello client, this is my first servlet");
		out.print("<!doctype html><html><head><title>server response info</title></head><h1>server say: 你好，here is my response!</h1><body></body></html>");
		
	}
	
	public void destroy() {}
	
	public String getServletInfo(){
		return "";
	}
	
	public ServletConfig getServletConfig() {
		return null;
	}
}