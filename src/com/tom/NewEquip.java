package com.tom;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewEquip extends HttpServlet implements Filter{
	private static final long serialVersionUID = 1L;
	public static String driverName="com.mysql.jdbc.Driver";
	public static String userName="root";
	public static String userPwd="123456";
	public static String dbName="test_data";
	public static String tableName="user";
	private String encoding = "UTF-8";     

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		
		String id=request.getParameter("id");
		String type=request.getParameter("type");
		String department=request.getParameter("department");
		String manufacturer=request.getParameter("manufacturer");
		String vendor=request.getParameter("vendor");
		String pro_time=request.getParameter("pro_time");
		String an_time=request.getParameter("an_time");
		String an_person=request.getParameter("an_person");
		String contact=request.getParameter("contact");
	//	String log=request.getParameter("log");
		
		//连数据库
		String url="jdbc:mysql://localhost/"+dbName+"?user="+userName+"&password="+userPwd;
		try
		{
		Class.forName("com.mysql.jdbc.Driver").newInstance();

		Connection connection=DriverManager.getConnection(url);

		Statement statement = connection.createStatement();
		
		//在这里手动修改表的名称！！！莫名其妙，用不了面向对象的方法。。。

	//	String sql="insert into equipment VALUES ('"+id+"','"+manufacturer+"','"+vendor+"','"+pro_time+"','"+an_time+"','"+an_person+"','"+contact+"');";
	//	String sql="insert into equipment(id,vendor) VALUES ('"+id+"','"+vendor+"');";
		String sql="insert into equipment VALUES ('"+id+"','"+type+"','"+department+"','"+manufacturer+"','"+vendor+"','"+pro_time+"','"+an_time+"','"+an_person+"','"+contact+"');";
		statement.executeUpdate(sql); 
		
	

		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding(encoding);
        chain.doFilter(request,response);
		
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		String value = filterConfig.getInitParameter("encoding");
        if(value != null && !"".equals(value)){
            encoding = value;
        }
	}
}
