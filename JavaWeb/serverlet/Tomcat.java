package org.apache;

import java.util.Scanner;
import java.util.Properties;
import java.io.FileReader;
import javax.servlet.Servlet;

// tomcat服务器开发者

public class Tomcat{
	public static void main(String[] args) throws Exception {
		System.out.println("Tomcat 服务器启动，开始接受用户的访问...");
		System.out.println("请输入您的访问路径：");
		Scanner s = new Scanner(System.in);
		String key = s.nextLine();
		
		FileReader reader = new FileReader("web.properties");
		Properties pro = new Properties();
		pro.load(reader);
		reader.close();
		
		String className = pro.getProperty(key);
		Class clazz = Class.forName(className);
		Object obj = clazz.newInstance();
		Servlet servlet = (Servlet) obj;
		servlet.service();
	}
}