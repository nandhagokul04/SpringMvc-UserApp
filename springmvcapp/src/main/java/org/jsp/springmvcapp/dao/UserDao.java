package org.jsp.springmvcapp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.jsp.springmvcapp.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class UserDao {
	@Autowired
     private EntityManager entityManager;
	public User Saveuser(User u) {
	EntityTransaction transaction=entityManager.getTransaction();
	transaction.begin();
	entityManager.persist(u);
	transaction.commit();
	return u;
	}
	public User updateUser(User user) {
		User dbUser = entityManager.find(User.class, user.getId());
		EntityTransaction transaction = entityManager.getTransaction();
		if (dbUser != null) {
			dbUser.setEmail(user.getEmail());
			dbUser.setName(user.getName());
			dbUser.setPassword(user.getPassword());
			dbUser.setPhone(user.getPhone());
			transaction.begin();
			transaction.commit();
			return user;
		}
		return null;
	}

	public User findById(int id) {
		return entityManager.find(User.class, id);
	}

	public boolean deleteUser(int id) {
		User u = entityManager.find(User.class, id);
		if (u != null) {
			EntityTransaction transaction = entityManager.getTransaction();
			entityManager.remove(u);
			transaction.begin();
			transaction.commit();
			return true;
		}
		return false;
	}

	public User verifyUser(long phone, String password) {
		Query q = entityManager.createQuery("select u from User u where u.phone=?1 and u.password=?2");
		q.setParameter(1, phone);
		q.setParameter(2, password);
		try {
			return (User) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public User verifyUser(String email, String password) {
		Query q = entityManager.createQuery("select u from User u where u.email=?1 and u.password=?2");
		q.setParameter(1, email);
		q.setParameter(2, password);
		try {
			return (User) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public User verifyUser(int id, String password) {
		Query q = entityManager.createQuery("select u from User u where u.id=?1 and u.password=?2");
		q.setParameter(1, id);
		q.setParameter(2, password);
		try {
			return (User) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}		}
	public EntityManager getEntityManager() {
		return entityManager;
	}
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
}
