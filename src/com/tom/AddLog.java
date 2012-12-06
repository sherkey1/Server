package com.tom;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class AddLog extends HttpServlet{

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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out=response.getWriter();
		String product=request.getParameter("product");
		String time=request.getParameter("time");
		String person=request.getParameter("person");
		String contact=request.getParameter("contact");
		String log=request.getParameter("log");
		
		try
		{
		
		//连数据库
		String url="jdbc:mysql://localhost/"+dbName+"?user="+userName+"&password="+userPwd;
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();

		Connection connection=DriverManager.getConnection(url);

		Statement statement = connection.createStatement();
		
		//在这里手动修改表的名称！！！莫名其妙，用不了面向对象的方法。。。
		
		String sql="insert into maintain(product,time,person,contact,log) values('"+product+"','"+time+"','"+person+"','"+contact+"','"+log+"');";

		statement.executeUpdate(sql); 
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
