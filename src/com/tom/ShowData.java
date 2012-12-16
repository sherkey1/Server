package com.tom;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowData extends HttpServlet{

	private static final long serialVersionUID = 1L;
	public static String driverName="com.mysql.jdbc.Driver";
	public static String userName="root";
	public static String userPwd="123456";
	public static String dbName="test_data";
	public static String tableName="user";
	
	public static String manufacturer=null;
	public static String vendor=null;
	public static String pro_time=null;
	public static String an_time=null;
	public static String an_person=null;
	public static String contact=null;
	public static String log=null;
	

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		String id=request.getParameter("id");
		PrintWriter out=response.getWriter();

		
		//连数据库
		String url="jdbc:mysql://localhost/"+dbName+"?user="+userName+"&password="+userPwd;
		try
		{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection connection=DriverManager.getConnection(url);
		Statement statement = connection.createStatement();
		
		//在这里手动修改表的名称！！！莫名其妙，用不了面向对象的方法。。。

		String sql="select * from equipment where id='"+id+"';";
		ResultSet rs = statement.executeQuery(sql); 
		if(rs.next())
		{
			manufacturer=rs.getString("manufacturer").toString();
			vendor=rs.getString("vendor").toString();
			pro_time=rs.getString("pro_time");
			an_time=rs.getString("an_time");
			an_person=rs.getString("an_person");
			contact=rs.getString("contact");
		//	log=rs.getString("log");
			
			request.setAttribute("manufacturer", manufacturer);
			request.setAttribute("vendor", vendor);
			request.setAttribute("pro_time", pro_time);
			request.setAttribute("an_time", an_time);
			request.setAttribute("an_person", an_person);
			request.setAttribute("contact", contact);
		//	request.setAttribute("log", log);
			
			request.getRequestDispatcher("/showData.jsp").forward(request, response);
			
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}


	}

}
