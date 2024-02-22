package org.jsp.springempapp.dao;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.jsp.springempapp.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {
	Scanner s=new Scanner(System.in);
	@Autowired
	private EntityManager manager;
	Query q;
	
	public void SaveEmployee() {
		EntityTransaction t=manager.getTransaction();
		Employee e=new Employee();
		System.err.println("Employee name,desg,sal,phn,mail,pass ");
		e.setName(s.next());
		e.setDesg(s.next());
		e.setSal(s.nextDouble());
		e.setPhone(s.nextLong());
		e.setMail(s.next());
		e.setPassword(s.next());
		manager.persist(e);
		t.begin();
		t.commit();
		System.out.println("Employee saved with id "+e.getId());
	}
	public void UpdateEmployee(int id) {
		EntityTransaction t=manager.getTransaction();
		Employee e=manager.find(Employee.class, id);
		if(e!=null) {
		System.err.println("Employee name,desg,sal,phn,mail,pass ");
		e.setName(s.next());
		e.setDesg(s.next());
		e.setSal(s.nextDouble());
		e.setPhone(s.nextLong());
		e.setMail(s.next());
		e.setPassword(s.next());
		manager.persist(e);
		t.begin();
		t.commit();
		System.out.println("Employee saved with id "+e.getId());}
		else {
			System.err.println("Invalid Id!");
		}
	}
	public void FindById(int id) {
		Employee e=manager.find(Employee.class, id);
		if(e!=null) {
			System.out.println("Employee id : "+e.getId());
			System.out.println("Employee name : "+e.getName());
			System.out.println("Employee name : "+e.getDesg());
			System.out.println("Employee name : "+e.getSal());
			System.out.println("Employee name : "+e.getPhone());
			System.out.println("Employee name : "+e.getMail());
			System.out.println("Employee name : "+e.getPassword());
		}
		else {
			System.err.println("Invalid Id!");
		}
	}
	public void VerifyEmployeeByPhoneandpass(long a ,String b) {
		q=manager.createQuery("select e from Employee e where e.phone=?1 and e.password=?2");
	    q.setParameter(1, a);
	    q.setParameter(2, b);
	    try {
	    Employee e=(Employee) q.getSingleResult();
	    System.out.println("Employee id : "+e.getId());
		System.out.println("Employee name : "+e.getName());
		System.out.println("Employee name : "+e.getDesg());
		System.out.println("Employee name : "+e.getSal());
		System.out.println("Employee name : "+e.getPhone());
		System.out.println("Employee name : "+e.getMail());
		System.out.println("Employee name : "+e.getPassword());
	    }
	    catch(NoResultException e){
	    	System.err.println("Invalid DATA !");
	    }
	}
	public void VerifyEmployeeByMailandpass(String a ,String b) {
		q=manager.createQuery("select e from Employee e where e.mail=?1 and e.password=?2");
	    q.setParameter(1, a);
	    q.setParameter(2, b);
	    try {
	    Employee e=(Employee) q.getSingleResult();
	    System.out.println("Employee id : "+e.getId());
		System.out.println("Employee name : "+e.getName());
		System.out.println("Employee name : "+e.getDesg());
		System.out.println("Employee name : "+e.getSal());
		System.out.println("Employee name : "+e.getPhone());
		System.out.println("Employee name : "+e.getMail());
		System.out.println("Employee name : "+e.getPassword());
	    }
	    catch(NoResultException e){
	    	System.err.println("Invalid DATA !");
	    }
	}
	public void VerifyEmployeeByIdandPass(int a ,String b) {
		q=manager.createQuery("select e from Employee e where e.id=?1 and e.password=?2");
	    q.setParameter(1, a);
	    q.setParameter(2, b);
	    try {
	    Employee e=(Employee) q.getSingleResult();
	    System.out.println("Employee id : "+e.getId());
		System.out.println("Employee name : "+e.getName());
		System.out.println("Employee name : "+e.getDesg());
		System.out.println("Employee name : "+e.getSal());
		System.out.println("Employee name : "+e.getPhone());
		System.out.println("Employee name : "+e.getMail());
		System.out.println("Employee name : "+e.getPassword());
	    }
	    catch(NoResultException e){
	    	System.err.println("Invalid DATA !");
	    }
	}
	public void FindByName(String name) {
		
	}
	public void FindBySalary(double salary) {
		
	}
	public void Filter(double a,double b) {
		
	}
	

}