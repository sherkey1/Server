<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showData.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<!--jQuery References-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js" type="text/javascript"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.9.1/jquery-ui.min.js" type="text/javascript"></script>
  
<!--Theme-->
<link href="http://cdn.wijmo.com/themes/rocket/jquery-wijmo.css" rel="stylesheet" type="text/css" title="rocket-jqueryui" />
  
<!--Wijmo Widgets CSS-->
<link href="http://cdn.wijmo.com/jquery.wijmo-complete.all.2.3.1.min.css" rel="stylesheet" type="text/css" />
  
<!--Wijmo Widgets JavaScript-->
<script src="http://cdn.wijmo.com/jquery.wijmo-open.all.2.3.1.min.js" type="text/javascript"></script>
<script src="http://cdn.wijmo.com/jquery.wijmo-complete.all.2.3.1.min.js" type="text/javascript"></script>

	
	<script type="text/javascript">
    $(document).ready(function () {
        $("#accordion").wijaccordion({
    header: "h2", 
    expandDirection: "bottom"
    });
    });
</script>

  </head>
  
  <body>
	<div id="accordion">
	<h2>信息显示</h2>
        <div><img src="http://wijmo.com/wp-content/themes/wijmov2/img/wijmo_logo.png"></div>
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
    
     
     
      
	</div>
  </body>
</html>
