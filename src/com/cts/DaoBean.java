package com.cts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


public class DaoBean {
	
	private Connection conn;
	

	public void setConn(Connection conn) {
		this.conn = conn;
	}




	public boolean insertStudentDetails(StudentBean student){
		
		boolean flag=false;
		
		
		try {
			
		
			PreparedStatement ps=conn.prepareStatement("insert into student values(?,?,?)");
			
			
			ps.setInt(1, student.getRoll());
			ps.setString(2, student.getName());
			ps.setInt(3, student.getMarks());
			
			int x=ps.executeUpdate();
			
			if(x>0)
				flag=true;
			
			
			conn.close();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		return flag;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
