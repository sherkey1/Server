<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	hello
	<img src="<%=request.getContextPath()%>/barcode?msg=12345678"
		height="50px" width=130px />
	<table border="1" width="90%">
		<tr>
			<td>
				<h1>code39</h1> <img
				src="<%=request.getContextPath()%>/barcode?msg=0123456789&type=code39"
				height="100px" width=300px />
			</td>
			<td>
				<h1>code128</h1> <img
				src="<%=request.getContextPath()%>/barcode?msg=0123456789&type=code128"
				height="100px" width=300px />
			</td>
		</tr>
		<tr>
			<td>
				<h1>Codabar</h1> <img
				src="<%=request.getContextPath()%>/barcode?msg=0123456789&type=codabar"
				height="100px" width=300px />
			</td>
			<td>
				<h1>intl2of5</h1> <img
				src="<%=request.getContextPath()%>/barcode?msg=01234567890540&type=intl2of5"
				height="100px" width=300px />
			</td>
		</tr>
		<tr>
			<td>
				<h1>upc-a</h1> <img
				src="<%=request.getContextPath()%>/barcode?msg=012345678912&type=upc-a"
				height="100px" width=300px />
			</td>
			<td>
				<h1>ean-13</h1> <img
				src="<%=request.getContextPath()%>/barcode?msg=200123457893&type=ean-13"
				height="100px" width=300px />
			</td>
		</tr>
		<tr>
			<td>
				<h1>ean-8</h1> <img
				src="<%=request.getContextPath()%>/barcode?msg=20123451&type=ean-8"
				height="100px" width=300px />
			</td>
			<td>
				<h1>postnet</h1> <img
				src="<%=request.getContextPath()%>/barcode?msg=01234567890540&type=postnet"
				height="100px" width=300px />
			</td>
		</tr>
		<tr>
			<td>
				<h1>royal-mail-cbc</h1> <img
				src="<%=request.getContextPath()%>/barcode?msg=012345AS678912&type=royal-mail-cbc"
				height="100px" width=300px />
			</td>
			<td>
				<h1>pdf417</h1> <img
				src="<%=request.getContextPath()%>/barcode?msg=200123457893&type=pdf417"
				height="100px" width=300px />
			</td>
		</tr>
		<tr>
			<td>
				<h1>datamatrix</h1> <img
				src="<%=request.getContextPath()%>/barcode?msg=20123451&type=datamatrix"
				height="100px" width=300px />
			</td>
			<td></td>
		</tr>
	</table>
</body>
</html>
