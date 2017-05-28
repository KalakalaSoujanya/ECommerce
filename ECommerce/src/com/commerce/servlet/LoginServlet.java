package com.commerce.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet();. 
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String emailId=request.getParameter("emailId");
		String password=request.getParameter("password");
		RequestDispatcher rd= null;
		String result=null;
		if(emailId.equals("admin")&&password.equals("admin")){
			request.getSession().setAttribute("userType","admin");
			result="success";
		}else{
		
		LoginHelper Lh= new LoginHelper();
		 result= Lh.Login( emailId, password);
		 request.getSession().setAttribute("userType","customer");
		 CustomerHelper ch=new CustomerHelper();
		 int customerId=ch.getCustomerByemail(emailId);
		 request.getSession().setAttribute("customerId",customerId);
		
		}
	System.out.println("***** success");
		if(result.equals("success")){
			
			rd=request.getRequestDispatcher("Home.jsp");
			
		}
		else{
			request.setAttribute("error","LoginFailed");
			rd=request.getRequestDispatcher("login.jsp");
		}
		rd.forward(request, response);
	}
	

		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
