package com.bjpowernode.servlet;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.ServletConfig;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


public class StudentServlet implements Servlet {
	public void init(ServletConfig config) throws ServletException {
		
	}
	
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/bjpowernode";
			String user = "root";
			String password = "neu05317X";
			conn = DriverManager.getConnection(url, user, password);
			
			String sql = "select no, name from t_student";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				String no = rs.getString("no");
				String name = rs.getString("name");
				System.out.println(no + " " + name);
				out.print(no + " " + name + "</br>");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public void destroy() {}
	
	public String getServletInfo(){
		return "";
	}
	
	public ServletConfig getServletConfig() {
		return null;
	}
}