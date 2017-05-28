<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#fffee">
<br><br><br><br><br><br>
<%
 String var=(String)request.getAttribute("error");

%>
<font color="red"><%=((var!=null)?var:"")%></font>
<form method="post" action="LoginServlet">

<table align="center" width="20%" border="0">
<tr><td align="center" colspan="2"><h1>Login</h1></td></tr>
<tr><td align="center" colspan="2">&nbsp;</td></tr>
<tr><td><b>username</b></td><td><input type="text" name="emailId"/></td></tr>
<tr><td align="center" colspan="2">&nbsp;</td></tr>
<tr><td><b>password</b></td><td><input type="password" name="password"/></td></tr>
<tr><td align="center" colspan="2">&nbsp;</td></tr>
<tr><td align="center" colspan="2"><input type="submit" /></td></tr>
</form>
</table>
</body>
</html>