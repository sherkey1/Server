<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'newEquip.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">     
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<link href="style/layout.css" rel="stylesheet" type="text/css" />
  	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js" type="text/javascript" charset="utf-8"></script>
	
	<script src="js/jquery.infieldlabel.min.js" type="text/javascript" charset="utf-8"></script>
	
	<!--[if lte IE 6]>
		<style type="text/css" media="screen">
			form label {
					background: #fff;
			}
		</style>
	<![endif]-->
	<script type="text/javascript" charset="utf-8">
		$(function(){ $("label").inFieldLabels(); });
	</script>

	
	


  </head>
  
  <body>
 <form class="newEquip" action="/Server/servlet/newequip" method="post" accept-charset="utf-8">
		<fieldset>
			<legend>新建设备信息</legend>
			
			<p>
				<label for="id">产品型号</label><br />
				<input type="text" name="id" value="" id="id">
			</p>
			<p>
				<label for="manufacturer">生产厂家</label><br />
				<input type="text" name="manufacturer" value="" id="manufacturer">
			</p>
			<p>
				<label for="vendor">销售厂商</label><br />
				<input type="text" name="vendor" value="" id="vendor">
			</p>
			<p>
				<label for="pro_time">生产时间   格式：yyyy-mm-dd</label><br />
				<input type="text" name="pro_time" value="" id="pro_time">
			</p>
			<p>
				<label for="an_time">安装时间  格式：yyyy-mm-dd</label><br />
				<input type="text" name="an_time" value="" id="an_time">
			</p>
			<p>
				<label for="an_person">安装人员</label><br />
				<input type="text" name="an_person" value="" id="an_person">
			</p>
			<p>
				<label for="contact">联系方式</label><br />
				<input type="text" name="contact" value="" id="contact">
			</p>
			
			
			
		</fieldset>
		<p><input type="submit" value="Continue &rarr;"></p>
	</form>

  </body>
</html>
