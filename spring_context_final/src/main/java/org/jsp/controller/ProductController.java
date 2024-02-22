package org.jsp.controller;
import java.util.Scanner;

import org.jsp.app.Config;
import org.jsp.dao.ProductDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProductController {
   static Scanner s=new Scanner(System.in);
   static ProductDao dao;
   static{
	   ApplicationContext context=new AnnotationConfigApplicationContext(Config.class);
	   dao=context.getBean(ProductDao.class);
   }
   public static void main(String[] args) {
	   {
		   System.out.println("Enter 1 to save product");
		   System.out.println("Enter 1 to save product");
		   System.out.println("Enter 1 to save product");
		   System.out.println("Enter 1 to save product");
		   System.out.println("Enter 1 to save product");
	   }
	   switch(s.nextInt()) {
	   case 1:{
		   dao.SaveProduct();
	   }
	   }
}
}
