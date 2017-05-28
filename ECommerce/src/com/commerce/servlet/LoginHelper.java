package com.commerce.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginHelper {
public LoginHelper(){};
public String Login(String emailId, String password){
	String msg= null;
	try{
		//Step1
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Step2
		Connection con=DriverManager.getConnection(  
				"jdbc:oracle:thin:@localhost:1521:xe","ecommerce","ecommerce");  
				  
				//step3 create the statement object  
				Statement stmt=con.createStatement();  
				  
				//step4 execute query  
				ResultSet rt=stmt.executeQuery("select  password from Customer where  emailId='"+emailId+"'");
				String _password=null;
				while(rt.next()){  
				_password=rt.getString(1);
				
				}//step5 close the connection object  
				con.close();  
	
		if((_password!=null)&&_password.equals(password)){
		msg= "success";
	}else {
		msg= "failure";
	}
	  
	}catch(Exception e){ System.out.println(e);}
	finally{
		return msg;
	}
}
}
