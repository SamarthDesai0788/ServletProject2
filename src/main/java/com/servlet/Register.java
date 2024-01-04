package com.servlet;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.register.dao.RegisterQuery;


@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
		String name=request.getParameter("name");
	    String password=request.getParameter("pass");
	    String city=request.getParameter("city");
	    RegisterQuery query=new RegisterQuery();
	    int count=query.insert(name, password, city);
	    if(count>0)
	    	{
	    	response.sendRedirect("login.html");
	    	}else{
	    	response.sendRedirect("Error.html");	  
	    	}
		}
catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		}

}