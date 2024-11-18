package com.sanju.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/insertServlet")
public class InsertServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static int count  = 2; 
	static CustomersBo custbo =  new CustomersBo();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		try {
			int Id = Integer.parseInt(request.getParameter("Id"));
			String Name = request.getParameter("Name");
			String  password  = request.getParameter("Enter Password");
			String  Confirmpass =request.getParameter("Enter Confirm Password");
			String C_email = request.getParameter("email");
			String  C_Address = request.getParameter("Address");
			String C_city = request.getParameter("city");
		Customers customer = new Customers(Id, Name, C_email, C_Address, C_city);
		int c = custbo.insertCust(customer);
		if(password.equals(Confirmpass) && c>0) {
			out.println("<h2>Customers details  Saved Successfully....... </h2>");
			RequestDispatcher dispatcher= request.getRequestDispatcher("index.html");
			dispatcher.include(request, response);	
		}else if ( count > 0) {
			out.println("<h2 style='color:red'>Invalid Password....Try Again"  + count +  "Attempts left </h2>");
			count--;
			RequestDispatcher dispatcher  = request.getRequestDispatcher("index.html");
			dispatcher.include(request, response);
		}else {
			out.println("<h2>Sorry!! Not able to Register....");
		}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			out.print(e.getMessage()+" <h2>Exception Occur please check the code Once.</h2>");
		}             
		out.close();
	}

}
