<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List,com.commerce.servlet.Product,com.commerce.servlet.CartItem" %>  
    
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
<br>
<br>

<form method="post" action="CustomerServlet?action=checkout">
<table width="50%" align="center" bgcolor="yellow" border="1" cellpadding="0" cellspacing="0">
<tr bgcolor="Purple">
<th>ProductId</th>
<th>ProductName</th>
<th>Description</th>
<th>ProductPrice</th>
<th>Quantity</th>
<th>&nbsp;</th>

</tr>
<%
List cartProducts= (List)request.getAttribute("cartProducts");
int length=cartProducts.size();
CartItem e= null;
for(int i=0;i<length;i++){
	e=(CartItem)cartProducts.get(i);
	%>
	<tr  bgcolor="<%=(i%2)==0?"white":"pink" %>"><td width="10%"><%= e.getProductId() %></a></td>
	<td width="20%"><%=e.getProductName() %></td>
	<td width="38%"><%=e.getProductDescription() %></td>
	<td  width="20%" align="center"><%=e.getProductPrice() %></td>
	<td width="1%"><input size="2" type="text" name="quantity<%=e.getProductId()%>" value="<%=e.getQuantity() %>"></td>
	<td  width="10%" align= "center"><a href="CustomerServlet?action=deletecartItem&productId=<%=e.getProductId()%>">Delete</a></td></tr>
	<%} %>	
	
	
</table>
<table width="50%" align="center">
<tr><td>&nbsp;</td></tr>
<tr><td align="center"><input type="submit" value="checkout"/></td></tr>
</table>
</form>	
	
</body>
</html>