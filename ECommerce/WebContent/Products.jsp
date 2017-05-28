<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List,com.commerce.servlet.Product" %>  
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

<% String search=request.getParameter("search"); %>
<% String message=(String)request.getAttribute("message"); %>
<form action="Products?action=search" method="post">

<table width="60%" border="0" align="center">
<% 


if(userType.equals("admin")){%>
<tr><td align="left"><a href="AddProduct.jsp"><b>Add</b></a></td>
<%} %>

<td align="right"><input  type="text" name="search"  value="<%= ((search!=null)?search:"") %>"/><input type="submit" value="search" /></td></tr>
<tr><td>&nbsp;</td></tr>
</table>
</form>
<%= ((message!=null)?message:"") %>
<table width="60%" align="center" bgcolor="yellow" border="1" cellpadding="0" cellspacing="0">
<tr bgcolor="Purple">
<th>ProductId</th>
<th>ProductName</th>
<th>ProductStock</th>
<th>ProductPrice</th>
<th>Description</th>
<th>ProductType</th>
<% if(userType.equals("admin")){%>
<th>&nbsp;</th>
<%}else{%>
<th>&nbsp;</th>
<%} %>
</tr>
<%
List products= (List)request.getAttribute("products");
int length=products.size();

Product e= null;
int numProducts=(Integer)request.getAttribute("numProducts");
int pages=(int)Math.floor(numProducts/5);
if(numProducts%length>0){pages++;}
for(int i=0;i<length;i++){
	e=(Product)products.get(i);
	%>
	<tr bgcolor="<%=(i%2)==0?"white":"pink" %>"><td align= "center"><a href="Products?action=view&productId=<%=e.getProductId() %>"><%= e.getProductId() %></a></td>
	<td><%=e.getProductName() %></td>
	<td align="center"><%=e.getProductStock() %></td>
	<td align="center"><%=e.getProductPrice() %></td>
	<td><%=e.getProductDescription() %></td>
	<td><%=e.getProductType() %></td>
	
	<% if(userType.equals("admin")){%>
		<td align= "center"><a href="Products?action=edit&productId=<%=e.getProductId() %>">Edit</a></td>
		
		<%}else{%>
		<td align= "center"><a href="CustomerServlet?action=addcart&productId=<%=e.getProductId() %>">Add to Cart</a></td>
		<% }%>
		</tr>	
		<%}%>
		</table>
	
	<table align="center" width="60%">
<tr><td align="left"><%for(int i=1;i<=pages;i++){%>
 <a href="Products?action=search&pageNumber=<%=i %>&search=<%=((search!=null)?search:"")%>"><%=i %></a><%} %></td>
 </tr>
 
</table>
</body>
</html>