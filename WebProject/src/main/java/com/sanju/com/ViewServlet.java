package com.sanju.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/viewservlet")
public class ViewServlet extends HttpServlet {
/**
	 * 
	 */
	private static final long serialVersionUID = 4986844187892268418L;

@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 response.setContentType("text/html");
	 CustomersBo custbo = new CustomersBo();
     PrintWriter out = response.getWriter();
     out.println("<a href='index.html'  style ='color:red;'>Add New Customers</a>");  
     out.println("<h1>Customers List</h1>");  
	  List<Customers> list = custbo.getAll();
	  out.print("<table border='1' width='50%' style ='color:blue; ");  
      out.print("<tr'><th>Id</th>"
			      		+ "<th>Name</th>"
			      		+ "<th>Email</th>"
			      		+ "<th>Address</th>"
			      		+ "<th>City</th>"
			      		+ "<th style ='color:black;'>Edit</th>"
			      		+ "<th style ='color:black;'>Delete</th></tr>");  
            for(Customers e:list){ 
       out.print("<tr><td>"+e.getC_Id()+"</td><td>"+e.getC_Name()+"</td>"
               +"<td>"+e.getC_email()+"</td><td>"+e.getC_Address()+"</td> <td>"+e.getC_city()+"</td> <td>"
               		+ "<a href='editservlet?Id="+e.getC_Id()+"' style='color:black;'>Edit</a></td>"+
               "<td><a href='deleteservlet?Id="+e.getC_Id()+"' style ='color:black;'>Delete</a></td></tr>");  
      }
      out.print("</table>");
      out.close();

	}

}
