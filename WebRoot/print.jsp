<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

</head>
<body>
	<h2>产品编号</h2>
     <div><%=request.getAttribute("id") %><br> 
     <img
				src="<%=request.getAttribute("url") %>"
				height="100px" width=300px /></div> 
      
 	<h2>产品型号</h2>
     <div><%=request.getAttribute("type") %></div>  
     <h2>所属科室</h2>
     <div><%=request.getAttribute("department") %></div>  
     <h2>生产厂家</h2>
     <div><%=request.getAttribute("manufacturer") %></div>  
     <h2>销售厂商</h2>
     <div><%=request.getAttribute("vendor") %></div> 
     <h2>生产时间</h2>
     <div><%=request.getAttribute("pro_time") %></div> 
     <h2>安装时间</h2>
     <div><%=request.getAttribute("an_time") %></div> 
     <h2>安装人员</h2>
     <div><%=request.getAttribute("an_person") %></div> 
     <h2>联系方式</h2>
     <div><%=request.getAttribute("contact") %></div> 
</body>
</html>