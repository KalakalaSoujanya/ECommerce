<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<br>
<br>
<br>
<br>

<form method="post" action="Products?action=add">
<table align="center" width="40%" border="0" cellpadding="0" cellspacing="0" bgcolor="#DDA0DD">
<tr><td align="center" colspan="3"><h2>Add NewProducts</h2></td></tr>
<tr><td>&nbsp;<td></tr>
<tr><td>&nbsp;<td></tr>
<tr><td>&nbsp;<td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td><b>ProductName</b></td><td><input type="text" name="productName"/></td></tr>
<tr><td>&nbsp;<td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td><b>ProductStock</b></td><td><input type="text" name="productStock"/></td></tr>
<tr><td>&nbsp;<td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td><b>ProductPrice</b></td><td><input type="text" name="productPrice"/></td></tr>
<tr><td>&nbsp;<td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td><b>ProductDescription</b></td><td><input type="text" name="productDescription"/></td></tr>
<tr><td>&nbsp;<td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td><b>ProductType</b></td><td><input type="text" name="productType"/></td></tr>
<tr><td>&nbsp;<td></tr>
<tr><td>&nbsp;<td></tr>
</table>
<br>
<br>
<br>

<table align="center" >
<tr><td ><input type= "submit" value="add"/><td></tr>
</table>
</form>
</body>
</html>