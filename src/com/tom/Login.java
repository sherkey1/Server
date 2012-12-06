package com.tom;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import com.mysql.jdbc.Driver;

public class Login extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	public static String driverName="com.mysql.jdbc.Driver";
	public static String userName="root";
	public static String userPwd="123456";
	public static String dbName="test_data";
	public static String tableName="user";

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
		String name=request.getParameter("name");
		String pwd=request.getParameter("pwd");
		String message = ":Welcome to android!";
		
		//连数据库
		String url="jdbc:mysql://localhost/"+dbName+"?user="+userName+"&password="+userPwd;
		try
		{
		Class.forName("com.mysql.jdbc.Driver").newInstance();

		Connection connection=DriverManager.getConnection(url);

		Statement statement = connection.createStatement();
		
		//在这里手动修改表的名称！！！莫名其妙，用不了面向对象的方法。。。

		String sql="select * from user where user='"+name+"' and pwd='"+pwd+"';";

		ResultSet rs = statement.executeQuery(sql); 

		
		
		if(rs.next())
		{
			response.getWriter().write("success");
		}
		else
		{
			response.getWriter().write("fail");
		}
		}
		catch(Exception e )
		{
			e.printStackTrace();
		}
		
	}


}
