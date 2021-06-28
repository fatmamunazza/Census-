package com.censusapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
	
	private static final String url="jdbc:mysql://localhost:3306/bms_db";
	private static final String user="Admin";
	private static final String password="Sapient123";
	
	private static Connection  myConn;
	private JDBCConnection() {
		myConn=null;
	}
	
	public static Connection startdatabaseConnection() {
		if(myConn==null) {
			try {
				myConn = DriverManager.getConnection(url,user,password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return myConn;
	}
}