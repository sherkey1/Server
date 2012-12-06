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
		
		//�����ݿ�
		String url="jdbc:mysql://localhost/"+dbName+"?user="+userName+"&password="+userPwd;
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();

		Connection connection=DriverManager.getConnection(url);

		Statement statement = connection.createStatement();
		
		//�������ֶ��޸ı�����ƣ�����Ī������ò����������ķ���������

		String sql="select * from equipment where id='"+id+"';";

		ResultSet rs = statement.executeQuery(sql); 
		
		//�Ѳ�ѯ�Ľ���ŵ�List��
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
		//����json��
		JSONArray array = new JSONArray();
		for(Equipment bean:list){
			//�����û�JSON���� 
			JSONObject obj = new JSONObject(); 
			try{
			obj.put("��Ʒ�ͺ�", bean.getId());
			obj.put("��������", bean.getManufacturer());
			obj.put("���۳���", bean.getVendor()); 
			obj.put("��������", bean.getPro_time()); 
			obj.put("��װ����", bean.getAn_time()); 
			obj.put("��װ��Ա", bean.getAn_person()); 
			obj.put("��ϵ��ʽ", bean.getContact()); 
			
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
