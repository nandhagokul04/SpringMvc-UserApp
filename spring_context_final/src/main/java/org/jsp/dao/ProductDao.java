package org.jsp.dao;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.jsp.dto.Merchant;
import org.jsp.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao {
	@Autowired
	private EntityManager manager;
	Scanner s = new Scanner(System.in);
	Query q;

	public void SaveProduct() {
		EntityTransaction t = manager.getTransaction();
		Product p=new Product();
		System.out.println("Enter name,brand,catagory,description,cost");
		p.setName(s.next());
		p.setBrand(s.next());
		p.setCatagory(s.next());
		p.setDescription(s.next());
		p.setCost(s.nextDouble());
		System.out.println("Enter merchangt id");
		int id=s.nextInt();
		Merchant m=manager.find(Merchant.class, id);
		if(m!=null) {
		p.setMerchant(m);
		t.begin();
		manager.persist(p);
		t.commit();}
		else {
			System.err.println("invalid Merchant id!");
		}
		
	}
}
