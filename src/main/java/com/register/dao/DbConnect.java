package com.register.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {
	public static Connection getConnect() throws ClassNotFoundException, SQLException {
		 Class.forName("com.mysql.cj.jdbc.Driver");

         // Establish the database connection
     
		 Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Sama0788");
		return con;
	}
	}


