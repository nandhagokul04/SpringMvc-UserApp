package org.jsp.springempapp.controller;

import java.util.Scanner;

import org.jsp.springempapp.EmployeeConfig;
import org.jsp.springempapp.dao.EmployeeDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EmployeeController {
		static Scanner s=new Scanner(System.in);
		static EmployeeDao dao;
		static {
			ApplicationContext context = new AnnotationConfigApplicationContext(EmployeeConfig.class);
			dao = context.getBean(EmployeeDao.class);
		}
		public static void main(String[] args) {
		System.out.println("Enter 1 to save employee");
		System.out.println("Enter 2 to update employee");
		System.out.println("Enter 3 to find employee by id");
		System.out.println("Enter 4 to verify employee by phone and password");
		System.out.println("Enter 5 to verify employee by mail and password");
		System.out.println("Enter 6 to verify employee by Id and password");
		System.out.println("Enter 7 to find employee by desg");
		switch(s.nextInt()) {
		case 1:{
			dao.SaveEmployee();break;
			
		}
		case 2:{
			System.out.println("Enter id to update");
			dao.UpdateEmployee(s.nextInt());break;
			
		}
		case 3:{
			System.out.println("Enter id to find");
			dao.FindById(s.nextInt());
			break;
			
		}
		case 4:{
			System.out.println("Enter phone and password to verify");
			dao.VerifyEmployeeByPhoneandpass(s.nextLong(),s.next());
			break;
			
		}
		case 5:{
			System.out.println("Enter mail and password to verify");
			dao.VerifyEmployeeByMailandpass(s.next(),s.next());
			break;
		}
		case 6:{
			System.out.println("Enter Id and password to verify");
			dao.VerifyEmployeeByIdandPass(s.nextInt(),s.next());
			break;
		}
		}
		
	}

}
