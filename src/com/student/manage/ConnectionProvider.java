package com.student.manage;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	
	static Connection con;
	
	public static Connection createConnection() {
		try {
			// load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// create the connection
			String username = "root";
			String password = "vinayak@2003";
			String url = "jdbc:mysql://localhost:3306/student_manage?useSSL=false";
			
			con = DriverManager.getConnection(url, username, password);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
}
