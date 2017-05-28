<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List,com.commerce.servlet.Customer" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="Header.jsp" %> 


<br><br><br>
<form action="CustomerServlet?action=search" method="post">
<% String search=request.getParameter("search"); %>
<table width="60%" border="0" align="center">
<tr><td align="right"><input  type="text" name="search"  value="<%= ((search!=null)?search:"") %>"/><input type="submit" value="search" /></td></tr>
<tr><td>&nbsp;</td></tr>
</table>
</form>
<table width="60%" align="center" bgcolor="#FFE4E1" border="1" cellpadding="0" cellspacing="0">
<tr bgcolor="purple">
<th>CustomerID</th>
<th>CustomerLastName</th>
<th>CustomerFirstName</th>
<th>CustomerGender</th>
<th>CustomerEmailID</th>
<th>CustomerPhoneNo</th>
</tr>
<%
List customers=(List)request.getAttribute("customers");
int length=customers.size();
Customer e= null;
int numCustomers=(Integer)request.getAttribute("numCustomers");
int pages=(int)Math.floor(numCustomers/5);
if(numCustomers%length>0){pages++;}
for(int i=0;i<length;i++){
	e=(Customer)customers.get(i);
	%>
	<tr><td align="center"><%=e.getCust_ID() %></td>
	<td><%=e.getLastName() %></td>
	<td><%=e.getFirstName() %></td>
	<td><%=e.getGender() %></td>
	<td><%=e.getEmailID() %></td>
	<td><%=e.getPhoneNo() %></td></tr>
	
	<% } %>
</table>
<table align="center" width="60%">
<tr><td align="left"><%for(int i=1;i<=pages;i++){%>
 <a href="CustomerServlet?action=search&pageNumber=<%=i %>&search=<%=((search!=null)?search:"")%>"><%=i %></a><%} %></td>
 </tr>
 
</table>
</body>
</html>