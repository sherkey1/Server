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


import net.sf.json.*;


import com.tom.*;

public class Query extends HttpServlet{
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
		PrintWriter out=response.getWriter();
		String id=request.getParameter("id");
		
		try
		{
		
		//连数据库
		String url="jdbc:mysql://localhost/"+dbName+"?user="+userName+"&password="+userPwd;
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();

		Connection connection=DriverManager.getConnection(url);

		Statement statement = connection.createStatement();
		
		//在这里手动修改表的名称！！！莫名其妙，用不了面向对象的方法。。。

		String sql="select * from equipment where id='"+id+"';";

		ResultSet rs = statement.executeQuery(sql); 
		
		//把查询的结果放到List中
		List<Equipment> list=new ArrayList<Equipment>();
		while(rs.next())
		{
			Equipment e=new Equipment();
			e.setId(rs.getString("id"));
			e.setManufacturer(rs.getString("manufacturer"));
			e.setVendor(rs.getString("vendor"));
			e.setPro_time(rs.getString("pro_time"));
			e.setAn_time(rs.getString("an_time"));
			e.setAn_person(rs.getString("an_person"));
			e.setContact(rs.getString("contact"));
			
			list.add(e);
		}
		//放入json中
		JSONArray array = new JSONArray();
		for(Equipment bean:list){
			//单个用户JSON对象 
			JSONObject obj = new JSONObject(); 
			try{
			obj.put("产品型号", bean.getId());
			obj.put("生产厂家", bean.getManufacturer());
			obj.put("销售厂商", bean.getVendor()); 
			obj.put("生产日期", bean.getPro_time()); 
			obj.put("安装日期", bean.getAn_time()); 
			obj.put("安装人员", bean.getAn_person()); 
			obj.put("联系方式", bean.getContact()); 
			
			}catch (Exception e) {
			// TODO: handle exception
			}
			array.add(obj); 
			} 
		out.write(array.toString());
		out.flush();
		out.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
