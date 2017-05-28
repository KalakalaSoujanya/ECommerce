package com.commerce.servlet;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.commerce.servlet.Product;

public class ProductHelper {
	
	
	Connection con;
	 
	public ProductHelper(){
		try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ecommerce","ecommerce");
		
		
	}catch(Exception e){ System.out.println(e);}
		
	}
	
	
	public void close(){
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List getProducts(int pageSize, int pageNumber){
		List<Product> list= new ArrayList<Product>();
			try{  
				
				Statement stmt=con.createStatement();  
				
				int startRow=(pageNumber-1)*pageSize+1;
				int endRow=pageNumber*pageSize;
				
				ResultSet rs=stmt.executeQuery("Select * FROM(Select t.*, rownum r from PRODUCT t) Where r >="+startRow+" and r <="+endRow);
				
				
				Product e= null;
				while(rs.next()){  
				e= new Product(rs.getInt(1),rs.getString(2),rs.getInt(3), rs.getFloat(4),rs.getString(5),rs.getString(6));
				list.add(e);
				}  
				
				}catch(Exception e){ System.out.println(e);}
				finally{
					return list;
				}
				}
	public List searchProducts(String search,int pageSize, int pageNumber){
		List<Product> list= new ArrayList<Product>();
			try{  
				
				Statement stmt=con.createStatement(); 
				
				
				
				int startRow=(pageNumber-1)*pageSize+1;
				int endRow=pageNumber*pageSize;
				if(search==null){
					search="";
				}
				  
				
				
				ResultSet rs=stmt.executeQuery("Select * FROM(Select t.*, rownum r from PRODUCT t where t.PROD_NAME like '%"+search+"%') Where r >="+startRow+" and r <="+endRow);
				
				Product e= null;
				while(rs.next()){  
				e= new Product(rs.getInt(1),rs.getString(2),rs.getInt(3), rs.getFloat(4),rs.getString(5),rs.getString(6));
				list.add(e);
				} 
			}catch(Exception e){ System.out.println(e);}
				finally{
					return list;
				}
	}
			
				public boolean createProduct(Product p){
					try{
						
								Statement stmt=con.createStatement(); 
								 
								 
								
								ResultSet rt=stmt.executeQuery("select max (PROD_ID) from PRODUCT");
								int id=0;
								while(rt.next()){  
								id= rt.getInt(1);
								
								}
						String query="insert into Product values("+(id+1)+",'" + p.getProductName()+"','"+p.getProductStock()+"','"+p.getProductPrice()+"','"+p.getProductDescription()+"','"+p.getProductType()+"')";
								
								int rs=stmt.executeUpdate(query);
								  
								
								
					return true;
					}catch(Exception e) {System.out.println(e);}
					
					
					
					return false;
					
				
			
			}
				public Product getProduct(int productId){
					Product product=null;
						try{  
							 
							  
							
							Statement stmt=con.createStatement();  
							  
							
							ResultSet rs=stmt.executeQuery("select * from PRODUCT where PROD_ID="+productId);
							
							while(rs.next()){  
							product= new Product(rs.getInt(1),rs.getString(2),rs.getInt(3), rs.getFloat(4),rs.getString(5),rs.getString(6));
							
							}  
							
							}catch(Exception e){ System.out.println(e);}
							finally{
								return product;
							}
							}
				public boolean updateProduct(Product p){
					try{
						
								Statement stmt=con.createStatement();  
								 
								
								
								
						String query="update Product set Prod_Name='"+p.getProductName()+"',Prod_Stock="+p.getProductStock()+",Prod_Price="+p.getProductPrice()+",Prod_Description='"+p.getProductDescription()+"',Prod_Type='"+p.getProductType()+"' where Prod_Id="+p.getProductId();
								System.out.println("--***---" +query);
								int rs=stmt.executeUpdate(query);
								
								
					return true;
					}catch(Exception e) {System.out.println(e);}
					
					
					
					return false;
					
				
			
			}
				
				
				public int getNumProducts(String search){
					int count= 0;
						try{  
						
							Statement stmt=con.createStatement();  
							  String query=null;
							  if(search==null){
								  
								  query="select count(*) from PRODUCT";
							  }else{
								  query="select count(*) from PRODUCT where PROD_NAME like '%"+search+"%'";
							  }
							  System.out.println(query);
							
							 ResultSet rs=stmt.executeQuery(query);
							
							
							while(rs.next()){  
							
						     count=rs.getInt(1);
							}
							}catch(Exception e){ System.out.println(e);}
							finally{
								return count;
							}
							}
				
			}
	



