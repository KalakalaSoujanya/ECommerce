<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="com.commerce.servlet.Product" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="Header.jsp" %> 
<br>
<br>
<br>
<br>
<% Product product=(Product)request.getAttribute("product"); %>
<form method="post" action="Products?action=update&productId=<%= product.getProductId() %>">
<table align="center" width="40%" border="0" cellpadding="0" cellspacing="0" bgcolor="#DDA0DD">
<tr><td align="center" colspan="3"><h2>View Product</h2></td></tr>
<tr><td>&nbsp;<td></tr>
<tr><td>&nbsp;<td></tr>
<tr><td>&nbsp;<td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td><b>Product Id</b></td><td><%= product.getProductId() %></td></tr>
<tr><td>&nbsp;<td></tr>
<tr><td>&nbsp;<td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td><b>Product Name</b></td><td><input type="text" name="productName"  value="<%= product.getProductName() %>"/></td></tr>
<tr><td>&nbsp;<td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td><b>Product Stock</b></td><td><input type="text" name="productStock"  value="<%= product.getProductStock() %>"/></td></tr>
<tr><td>&nbsp;<td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td><b>Product Price</b></td><td><input type="text" name="productPrice"  value="<%=product.getProductPrice()  %>"/></td></tr>
<tr><td>&nbsp;<td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td><b>Product Description</b></td><td><input type="text" name="productDescription"  value="<%=product.getProductDescription()  %>"/></td></tr>
<tr><td>&nbsp;<td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td><b>Product Type</b></td><td><input type="text" name="productType"  value="<%=product.getProductType()  %>"/></td></tr>
<tr><td>&nbsp;<td></tr>
<tr><td>&nbsp;<td></tr>
</table>
<br>
<br>
<br>

<table align="center" >
<tr><td ><input type= "submit" value="Update"/><td></tr>
</table>
</form>
</body>
</html>