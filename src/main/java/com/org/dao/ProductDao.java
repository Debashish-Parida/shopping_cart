package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.org.dto.Cart;
import com.org.dto.Merchant;
import com.org.dto.Product;
import com.org.dto.Product;
import com.org.utility.Helper;

public class ProductDao 
{
	public List<Product> fetchAll()
	{
		EntityManagerFactory emf = Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createQuery("SELECT s FROM Product s");
		
		List<Product> list = query.getResultList();
		
		return list;
		
	}
	
	
	public Product fetchById(int id)
	{
		EntityManagerFactory emf = Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();
		
		return em.find(Product.class, id);
	}
	
	
	
	public List<Product> fetchByEmailAndPassword(String email, String password)
	{
		EntityManagerFactory emf = Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createQuery("SELECT s FROM Product s WHERE s.email=?1 AND s.password=?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		
		List<Product> list = query.getResultList();
		
		return list;
	}
	
	public void saveAndUpdate(Product product)
	{
		EntityManagerFactory emf = Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Merchant merchant = product.getMerchant();
		
		et.begin();
		em.merge(merchant);
		et.commit();
	}
}
