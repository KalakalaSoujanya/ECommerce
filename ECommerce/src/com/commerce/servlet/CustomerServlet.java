package com.commerce.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd= null;
		ProductHelper helper= new ProductHelper();
		
		String action= request.getParameter("action");
		int pageNumber=1;
		int pageSize=5;
		String page=request.getParameter("pageNumber");
		if(page!=null){pageNumber=Integer.parseInt(page);}
		
		
		
		 CustomerHelper ch= new CustomerHelper();
		 	
		 /* if(action.equals("list")){ 
			List customers= (List)ch.getCustomer(pageSize, pageNumber);
						request.setAttribute("customers", customers);
					request.getRequestDispatcher("Customers.jsp").forward(request,response);*/
					
		   if(action.equals("search")){
			 String search=request.getParameter("search");
			 int numCustomers=ch.getNumCustomers(search);
			 request.setAttribute("numCustomers", numCustomers);
			List customers=(List)ch.searchCustomers(search,pageSize,pageNumber);
			
			request.setAttribute("customers",customers);
			
			request.getRequestDispatcher("Customers.jsp").forward(request,response);
			  
		  }else if(action.equals("addcart")){
		   	  String productId=request.getParameter("productId");
		   	  String customerId=request.getSession().getAttribute("customerId").toString();
		   	  if(!ch.isPresentInCart(productId)){
		   	  boolean status=ch.addToCart(productId,customerId);
		   	  request.setAttribute("message", "Added to Cart");
		   
		   	  }else{
		   		request.setAttribute("message", "Product already present in the Cart");
		   	  } 
		  	request.getRequestDispatcher("Products?action=search").forward(request,response); 
		  }else if(action.equals("viewcartitems")){
			  String customerId=request.getSession().getAttribute("customerId").toString();
			  List cartProducts=(List)ch.cartItems(customerId);
			  request.setAttribute("cartProducts",cartProducts);
			  request.getRequestDispatcher("ShoppingCart.jsp").forward(request, response);
			  
		  }else if(action.equals("deletecartItem")){
			  int productId=Integer.parseInt(request.getParameter("productId"));
				boolean status=ch.deleteCartProduct(productId);
				if(status){
					String customerId=request.getSession().getAttribute("customerId").toString();
					List cartProducts=(List)ch.cartItems(customerId);
					request.setAttribute("cartProducts",cartProducts);
					request.getRequestDispatcher("ShoppingCart.jsp").forward(request, response);
				}
			 
		  		}else if(action.equals("checkout")){
		  			String customerId=request.getSession().getAttribute("customerId").toString();
		  			List<CartItem> cartProducts=(List)ch.cartItems(customerId);
		  			for( CartItem item:cartProducts){
		  				item.setQuantity(Integer.parseInt(request.getParameter("quantity"+item.getProductId())));
		  			}
		  			ch.updateCartItems(cartProducts);
		  			request.setAttribute("cartProducts", cartProducts);
		  			request.getRequestDispatcher("OrderSummary.jsp").forward(request,response);
		  		} else if(action.equals("placeorder")){
		  			String customerId=request.getSession().getAttribute("customerId").toString();
		  			List<CartItem> cartProducts=(List)ch.cartItems(customerId);
		  			boolean status=ch.placeOrder(customerId);
		  			request.setAttribute("cartProducts", cartProducts);
		  			request.setAttribute("message","Order Placed Successfully" );
		  			request.getRequestDispatcher("OrderSummary.jsp").forward(request,response);
		  		}else if(action.equals("logout")) {
		  			request.getSession().invalidate();
					request.getRequestDispatcher("index.jsp").forward(request, response);
							
		  			
		  		}
		 
		 else {
		
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String gender=request.getParameter("gender");
		String emailId=request.getParameter("emailId");
		String password=request.getParameter("password");
		String confirmPassword=request.getParameter("confirmPassword");
		String phoneNumber=request.getParameter("phoneNumber");
		
		System.out.println("*** in customer servlet");
	if(password!=null &&(password.equals(confirmPassword))){
		Customer c= new Customer(0,lastName, firstName, gender, emailId, password,phoneNumber);
		
		boolean status=ch.createCustomer(c);
		if(status){
		rd=request.getRequestDispatcher("login.jsp");
		}
	
	rd=request.getRequestDispatcher("registration.jsp");
	request.setAttribute("error","Registration Failed");
	rd.forward(request,  response);}
	
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
