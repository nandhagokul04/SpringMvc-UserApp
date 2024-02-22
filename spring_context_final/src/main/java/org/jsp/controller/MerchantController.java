package org.jsp.controller;

import java.util.Scanner;

import org.jsp.app.Config;
import org.jsp.dao.MerchantDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MerchantController {
  static Scanner s=new Scanner(System.in);
  static MerchantDao dao;
  static {
	  ApplicationContext context=new AnnotationConfigApplicationContext(Config.class);
	  dao=context.getBean(MerchantDao.class);  
  }
  public static void main(String[] args) {
		System.out.println("Enter 1 to save Merchant");
		System.out.println("Enter 2 to update Merchant");
		System.out.println("Enter 3 to find Merchant by id");
		System.out.println("Enter 4 to verify Merchant by phone and password");
		System.out.println("Enter 5 to verify Merchant by mail and password");
		switch(s.nextInt()) {
		case 1:{
			dao.SaveEmployee();break;
			
		}
		}
		
		
}
  
  
}
