package org.jsp.dao;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.jsp.dto.Merchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MerchantDao {
	Scanner s = new Scanner(System.in);
	@Autowired
	private EntityManager manager;
	Query q;

	public void SaveEmployee() {
		EntityTransaction t = manager.getTransaction();
		Merchant e = new Merchant();
		System.err.println("Employee name,phn,mail,pass ");
		e.setName(s.next());
		e.setPhone(s.nextLong());
		e.setMail(s.next());
		e.setPassword(s.next());
		manager.persist(e);
		t.begin();
		t.commit();
		System.out.println("Employee saved with id " + e.getId());
	}

}
