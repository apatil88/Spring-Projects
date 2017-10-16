package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;


public class TestJdbc {

	public static void main(String[] args) {
		
		final String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		
		String user = "hbstudent";
		String password = "hbstudent";
		
		try{
			System.out.println("Connecting to database: " + jdbcUrl);
			
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, password);
			
			System.out.println("Connection successful!"); 
			
		} catch (Exception e){
			e.printStackTrace();
		}

	}

}
