package com.commerce.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class CustomerHelper {
	
   public boolean createCustomer(Customer c){
		try{
										//Step1
		Class.forName("oracle.jdbc.driver.OracleDriver");
										//Step2
		Connection con=DriverManager.getConnection(  
  	"jdbc:oracle:thin:@localhost:1521:xe","ecommerce","ecommerce");  
														  
		//step3 create the statement object  
		Statement stmt=con.createStatement();  
														  
		//step4 execute query  
	    ResultSet rt=stmt.executeQuery("select max (CUST_ID) from Customer");
	    int id=0;
		while(rt.next()){  
		id= rt.getInt(1);
														
	    }
        String query="insert into Customer values("+(id+1)+",'" + c.getLastName()+"','"+c.getFirstName()+"','"+c.getGender()+"','"+c.getEmailID()+"','"+c.getPassword()+"','"+c.getPhoneNo()+"')";
	    System.out.println("--***---" +query);
		int rs=stmt.executeUpdate(query);
	    //step5 close the connection object  
	    con.close(); 
														
		return true;
		}catch(Exception e) {System.out.println(e);} 
		return false;
		}
						
						public List getCustomer(int pageSize,int pageNumber){
		List<Customer> list= new ArrayList<Customer>();
			try{  
				//step1 load the driver class  
				Class.forName("oracle.jdbc.driver.OracleDriver");  
				  
				//step2 create  the connection object  
				Connection con=DriverManager.getConnection(  
				"jdbc:oracle:thin:@localhost:1521:xe","ecommerce","ecommerce");  
				  
				//step3 create the statement object  
				Statement stmt=con.createStatement();
				int startRow=(pageNumber-1)*pageSize+1;
				int endRow=pageNumber*pageSize;
				
				//step4 execute query  
				ResultSet rs=stmt.executeQuery("Select Cust_ID,LastName,FirstName,Gender,EmailID,Phone_No FROM Customer");
				
				Customer e= null;
				while(rs.next()){  
				e= new Customer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
				list.add(e);
				}//step5 close the connection object  
				con.close();  
				}catch(Exception e){ System.out.println(e);}
				finally{
					return list;
				}
						}
						

						public List searchCustomers(String search,int pageSize,int pageNumber){
							List<Customer> list= new ArrayList<Customer>();
								try{  Class.forName("oracle.jdbc.driver.OracleDriver");
								//Step2
								Connection con=DriverManager.getConnection(  
										"jdbc:oracle:thin:@localhost:1521:xe","ecommerce","ecommerce");  
												  
								//step3 create the statement object  
								Statement stmt=con.createStatement();
								int startRow=(pageNumber-1)*pageSize+1;
								int endRow=pageNumber*pageSize;
								if(search==null){
									search="";
								}
									
								
								ResultSet rs=stmt.executeQuery("Select * FROM(Select t.*, rownum r from Customer t where t.FIRSTNAME like '%"+search+"%' ) Where r >="+startRow+" and r <="+endRow);
									
									
									Customer e= null;
									while(rs.next()){  
									e= new Customer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
									list.add(e);
									} 
								}catch(Exception e){ System.out.println(e);}
									finally{
										return list;
									}
						}
						public boolean addToCart(String productId, String customerId){
						
						try{
							//Step1
						Class.forName("oracle.jdbc.driver.OracleDriver");
													//Step2
						Connection con=DriverManager.getConnection(  
						"jdbc:oracle:thin:@localhost:1521:xe","ecommerce","ecommerce");  
																	  
						//step3 create the statement object  
						Statement stmt=con.createStatement();  
																	  
						//step4 execute query  
						ResultSet rt=stmt.executeQuery("select max (cart_Id) from cart");
						int id=0;
						while(rt.next()){  
						id= rt.getInt(1);
																	
						}
						String query="insert into cart values("+(id+1)+","+productId+",1,'O',null,"+customerId+")";
						System.out.println("--***---" +query);
						int rs=stmt.executeUpdate(query);
						//step5 close the connection object  
						con.close(); 
																	
						return true;
						}catch(Exception e) {System.out.println(e);} 
						return false;
						}	
													

			
				
public int getNumCustomers(String search){
	 
   int count=0;
	
		try{  Class.forName("oracle.jdbc.driver.OracleDriver");
		//Step2
		Connection con=DriverManager.getConnection(  
				"jdbc:oracle:thin:@localhost:1521:xe","ecommerce","ecommerce");  
						  
		//step3 create the statement object  
		Statement stmt=con.createStatement();
		String  query=null;
		 if(search==null){
			  
			  query="select count(*) from Customer";
		  }else{
			  query="select count(*) from Customer where FIRSTNAME like '%"+search+"%'";
		  }
		 
		 ResultSet rs=stmt.executeQuery(query);	
			
		 while(rs.next()){  
				
		     count=rs.getInt(1);
			}
			}catch(Exception e){ System.out.println(e);}
			finally{
				return count;
			}
			
}


public int getCustomerByemail(String email){
	int id=0;
	try{
		//Step1
	Class.forName("oracle.jdbc.driver.OracleDriver");
								//Step2
	Connection con=DriverManager.getConnection(  
	"jdbc:oracle:thin:@localhost:1521:xe","ecommerce","ecommerce");  
												  
	//step3 create the statement object  
	Statement stmt=con.createStatement();  
											  
	//step4 execute query  
	ResultSet rt=stmt.executeQuery("select Cust_ID from Customer where emailId='"+email+"'");
	
	while(rt.next()){  
	id= rt.getInt(1);
												
	}
	//step5 close the connection object  
	con.close(); 
												
	
	}catch(Exception e) {System.out.println(e);} 
	finally{
		return id;
	}
	}	
public boolean isPresentInCart(String productId){
	boolean present=false;
	try{
		//Step1
	Class.forName("oracle.jdbc.driver.OracleDriver");
								//Step2
	Connection con=DriverManager.getConnection(  
	"jdbc:oracle:thin:@localhost:1521:xe","ecommerce","ecommerce");  
												  
	//step3 create the statement object  
	Statement stmt=con.createStatement();  
											  
	//step4 execute query  
	ResultSet rt=stmt.executeQuery("select count(*) from Cart where PROD_ID="+productId+" and status ='O'");
	int count=0;
	
	while(rt.next()){  
	count= rt.getInt(1);
												
	}
	if(count>0){
		present=true;
	}
	//step5 close the connection object  
	con.close(); 
												
	
	}catch(Exception e) {System.out.println(e);} 
	finally{
		return present ;
	}
	}	
public List cartItems(String customerId){
	
 List <CartItem> list= new ArrayList<CartItem>();
	
	try{
		//Step1
	Class.forName("oracle.jdbc.driver.OracleDriver");
								//Step2
	Connection con=DriverManager.getConnection(  
	"jdbc:oracle:thin:@localhost:1521:xe","ecommerce","ecommerce");  
												  
	//step3 create the statement object  
	Statement stmt=con.createStatement();  
												  
	//step4 execute query 
	String query="select PRODUCT.PROD_ID,PRODUCT.PROD_NAME,PRODUCT.PROD_DESCRIPTION,PRODUCT.PROD_PRICE,cart.quantity FROM Cart INNER JOIN PRODUCT ON Cart.PROD_ID=PRODUCT.PROD_ID and cart.status='O'and cart.Cust_ID="+customerId;
	ResultSet rt=stmt.executeQuery(query);
	CartItem e=null;
	while(rt.next()){  
		e= new CartItem(rt.getInt(1),rt.getString(2),rt.getString(3), rt.getFloat(4),rt.getInt(5));
		list.add(e);
		
		} 
	
	//step5 close the connection object  
	con.close(); 
												

	}catch(Exception e) {System.out.println(e);} 
	finally{
	return list ;
	}
		
						
		
						}

	
public boolean deleteCartProduct(int productId){
	try{
		//Step1
	Class.forName("oracle.jdbc.driver.OracleDriver");
								//Step2
	Connection con=DriverManager.getConnection(  
	"jdbc:oracle:thin:@localhost:1521:xe","ecommerce","ecommerce");  
												  
	//step3 create the statement object  
	Statement stmt=con.createStatement();
	String query="delete from Cart where PROD_ID="+productId+ " and status='O'";
	ResultSet rt=stmt.executeQuery(query);
	
	System.out.println(query);
		return true;
		}catch(Exception e){ 
		return false;}
}
public void updateCartItems(List<CartItem> cartProducts){
	
	 
		
		try{
			
		Class.forName("oracle.jdbc.driver.OracleDriver");
									
		Connection con=DriverManager.getConnection(  
		"jdbc:oracle:thin:@localhost:1521:xe","ecommerce","ecommerce");  
											  
		 
		  con.setAutoCommit(false);
			for(CartItem item:cartProducts){										  
			String query="update cart set Quantity=? where PROD_ID=? and status='O'";	
			PreparedStatement p=con.prepareStatement(query);
		p.setInt(1, item.getQuantity());
		p.setInt(2, item.getProductId());
		  p.executeUpdate();  
		
			
			 
			}
		 con.commit();
		con.close(); 
													

		}catch(Exception e) {System.out.println(e);} 
		
}


public boolean placeOrder(String customerId){
	
	 List <CartItem> list= new ArrayList<CartItem>();
		
		try{
			//Step1
		Class.forName("oracle.jdbc.driver.OracleDriver");
									//Step2
		Connection con=DriverManager.getConnection(  
		"jdbc:oracle:thin:@localhost:1521:xe","ecommerce","ecommerce");  
			con.setAutoCommit(false);										  
		//step3 create the statement object  
		Statement stmt=con.createStatement();
		 ResultSet rs=stmt.executeQuery("select max (ORDER_ID) from ShoppingOrder");
		    int id=0;
			while(rs.next()){  
			id= rs.getInt(1);
															
		    }
													  
		//step4 execute query 
		String query="insert into ShoppingOrder values("+(id+1)+",sysdate)";
		int rt=stmt.executeUpdate(query);
		query="update cart set Order_ID="+(id+1)+ ",status='C' where status='O' and Cust_ID="+customerId;
		rt=stmt.executeUpdate(query);
		con.commit();
		//step5 close the connection object  
		con.close(); 
													

		}catch(Exception e) {System.out.println(e);} 
		finally{
		return true ;
		}
			
							
			
							}
}
