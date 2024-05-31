package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.org.dto.Cart;
import com.org.utility.Helper;

public class CartDao 
{
	public List<Cart> fetchAll()
	{
		EntityManagerFactory emf = Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createQuery("SELECT s FROM Cart s");
		
		List<Cart> list = query.getResultList();
		
		return list;
		
	}
	
	
	public Cart fetchById(int id)
	{
		EntityManagerFactory emf = Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();
		
		return em.find(Cart.class, id);
	}
	
	
	
	public List<Cart> fetchByEmailAndPassword(String email, String password)
	{
		EntityManagerFactory emf = Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createQuery("SELECT s FROM Cart s WHERE s.email=?1 AND s.password=?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		
		List<Cart> list = query.getResultList();
		
		return list;
	}
}
