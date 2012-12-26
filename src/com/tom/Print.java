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

/**
 * Servlet implementation class Print
 */
public class Print extends HttpServlet{
	private static final long serialVersionUID = 1L;
       
	public static String type=null;
	public static String department=null;
	public static String manufacturer=null;
	public static String vendor=null;
	public static String pro_time=null;
	public static String an_time=null;
	public static String an_person=null;
	public static String contact=null;
	public static String url=null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Print() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		
		
		String id=request.getParameter("id");
		type=request.getParameter("type");
		department=request.getParameter("department");
		manufacturer=request.getParameter("manufacturer");
		vendor=request.getParameter("vendor");
		pro_time=request.getParameter("pro_time");
		an_time=request.getParameter("an_time");
		an_person=request.getParameter("an_person");
		contact=request.getParameter("contact");
		
		
		url="http://localhost:8080/Server/barcode?msg="+id+"&type=code39";
		PrintWriter out=response.getWriter();

		

			request.setAttribute("id", id);
			request.setAttribute("type", type);
			request.setAttribute("department", department);
			request.setAttribute("manufacturer", manufacturer);
			request.setAttribute("vendor", vendor);
			request.setAttribute("pro_time", pro_time);
			request.setAttribute("an_time", an_time);
			request.setAttribute("an_person", an_person);
			request.setAttribute("contact", contact);
			request.setAttribute("url", url);
		//	request.setAttribute("log", log);
			
			request.getRequestDispatcher("/print.jsp").forward(request, response);
			

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
