<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table width="100%" height="150px" bgcolor="purple">
<tr><td>&nbsp;</td>
</tr>
</table>
<table width="100%" height="20px" bgcolor="grey">
<tr><td width="20%">&nbsp;</td>
<td  width="5%" bgcolor="white"><a href="Products?action=search"  ><b>Products</b></a></td>
<% 
String userType=(String)session.getAttribute("userType");

if(userType.equals("admin")){%>
<td  width="5%" bgcolor="white"><a href="CustomerServlet?action=search"  ><b>Customers</b></a></td>

<%}else{%>
<td  width="5%" bgcolor="white"><a href="CustomerServlet?action=viewcartitems"  ><b>ShoppingCart</b></a></td>
<%} %>
<td  width="70%">&nbsp;</td>
<td  width="5%" bgcolor="white"><a href="CustomerServlet?action=logout"  ><b>Logout</b></a></td>
</tr>
</table>

</body>
</html>