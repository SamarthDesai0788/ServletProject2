package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.register.dao.RegisterQuery;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("uname");
	    String password=request.getParameter("pass");
	    response.setContentType("text/html");
	    PrintWriter out=response.getWriter();
	    RegisterQuery query=new RegisterQuery();
	    try {
			ResultSet rs=query.login(name, password);
			 if (rs.next()) {
	                // Valid credentials, redirect to success page
	                response.sendRedirect("Success.html");
	            } else {
	                // Invalid credentials, forward to login page
	                out.println("Invalid Credentials");
	                request.getRequestDispatcher("login.html").forward(request, response);
	            }
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        }
		}
}
