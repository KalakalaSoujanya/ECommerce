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
<%String message=(String)request.getAttribute("message"); %>
<%= ((message!=null)?message:"") %>
<form method="post" action="CustomerServlet?action=placeorder">
<table width="50%" align="center" bgcolor="yellow" border="1" cellpadding="0" cellspacing="0">
<tr bgcolor="Purple">
<th>ProductId</th>
<th>ProductName</th>
<th>Description</th>
<th>ProductPrice</th>
<th>Quantity</th>
<th>TotalPrice</th>

</tr>
<%
List cartProducts= (List)request.getAttribute("cartProducts");
int length=cartProducts.size();
CartItem e= null;
float grandTotal=0;
for(int i=0;i<length;i++){
	e=(CartItem)cartProducts.get(i);
	grandTotal+=e.getProductPrice()*e.getQuantity();
	%>
	<tr  bgcolor="<%=(i%2)==0?"white":"pink" %>"><td width="10%"><%= e.getProductId() %></a></td>
	<td width="20%"><%=e.getProductName() %></td>
	<td width="38%"><%=e.getProductDescription() %></td>
	<td  width="20%" align="right"><%=e.getProductPrice() %></td>
	<td width="1%" align="center"><%=e.getQuantity() %></td>
	<td  width="10%" align= "right"><%=e.getProductPrice()*e.getQuantity() %></td></tr>
	<%} %>	
	<tr><td colspan="5" align="right"><b>Grand Total&nbsp;&nbsp;</b></td><td align="right"><b><%=grandTotal %></b></td></tr>
	
</table>
<table width="50%" align="center">
<tr><td>&nbsp;</td></tr>

<%if(message==null){%>
<tr><td align="center"><input type="submit" value="PlaceOrder"/></td></tr>
<% } %>
</table>
</form>	
	
</body>
</html>