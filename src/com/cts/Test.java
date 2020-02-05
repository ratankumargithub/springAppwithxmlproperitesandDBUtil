package com.cts;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;


public class Test {

	static DaoBean dao;
	
	public void setDao(DaoBean dao) {
		this.dao = dao;
	}



	public void execute(){
		
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Roll :");
		int roll=sc.nextInt();
		
		System.out.println("Enter Name :");
		String name=sc.next();
		
		System.out.println("Enter Marks :");
		int marks=sc.nextInt();
		
		
		StudentBean student=new StudentBean(roll, name, marks);
		
		boolean f=dao.insertStudentDetails(student);
		
		if(f)
			System.out.println("Record inserted..");
		else
			System.out.println("Not Inserted..");
		
	}
	
	
	
	public static void main(String[] args) {
		
		
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		
		  Test t=ctx.getBean("test",Test.class);
		
		  t.execute();
		
	
		
	}

}
