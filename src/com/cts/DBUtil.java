package com.cts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DBUtil {
	
	
	
	
	private static Connection conn;
	
	public static Connection createConnection(String dname,String url){
		
		if(conn == null){
			
			try {
				Class.forName(dname);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//String url="jdbc:mysql://localhost:3306/ratandb";
			
			try {
				conn=DriverManager.getConnection(url,"root","root");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			
			
		}
		return conn;
	}

}
