<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#FFE4E1">
<%
 String var=(String)request.getAttribute("error");

%>

<form method="post" action="CustomerServlet">
<br><br><br>
<table  align="center" width="25%" border="0"  >
<tr><td align="left" ><font color="red"><%=((var!=null)?var:"")%></font></td></tr>
<tr><td>
<table align="center" width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#DDA0DD">

<tr><td align="center" colspan="3"><h2>Registration</h2></td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td><b>LastName</b></td><td><input type="text" name="lastName"/></td></tr>
<tr><td align="center" colspan="3">&nbsp;</td></tr>
<tr><td>&nbsp;</td><td><b>FirstName</b></td><td><input type="text" name="firstName"/></td></tr>
<tr><td align="center" colspan="3">&nbsp;</td></tr>
<tr><td>&nbsp;</td><td><b>Gender</b></td><td><input type="radio" name="gender" value="m" >male<br><input type="radio" name="gender" value="f" >female<br></td></tr>
<tr><td align="center" colspan="3">&nbsp;</td></tr>
<tr><td>&nbsp;</td><td><b>EmailID</b></td><td><input type="text" name="emailId"/></td></tr>
<tr><td align="center" colspan="3">&nbsp;</td></tr>
<tr><td>&nbsp;</td><td><b>Password</b></td><td><input type="password" name="password"/></td></tr>
<tr><td align="center" colspan="3">&nbsp;</td></tr>
<tr><td>&nbsp;</td><td><b>Confirm Password</b></td><td><input type="password" name="confirmPassword"/></td></tr>
<tr><td align="center" colspan="3">&nbsp;</td></tr>
<tr><td>&nbsp;</td><td><b>PhoneNumber</b></td><td><input type="text" name="phoneNumber"/></td></tr>
<tr><td align="center" colspan="3">&nbsp;</td></tr>
<tr><td align="center" colspan="3"><input type="submit" /></td></tr>
<tr><td align="center" colspan="3">&nbsp;</td></tr>



</table>
</td></tr>
</table>
</form>

</body>
</html>