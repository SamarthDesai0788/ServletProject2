package com.register.dao;


import java.sql.*;

public class RegisterQuery {
	
		public int insert(String name,String password,String city) throws ClassNotFoundException, SQLException
		{
	Connection con=DbConnect.getConnect();
	String query="insert into login values('"+name+"','"+password+"','"+city+"')";
	Statement stmt=con.createStatement();
	int count=stmt.executeUpdate(query);
	return count;
		}
public ResultSet login(String uname,String pass) throws ClassNotFoundException, SQLException
{
	Connection con=DbConnect.getConnect();
	String query="select * from login where name='"+uname+"' and password='"+pass+"'";
	Statement stmt=con.createStatement();
	ResultSet rs=stmt.executeQuery(query);
	
	return rs;
}
public int update(String name, String password, String city) {
	// TODO Auto-generated method stub
	return 0;
}
	}

