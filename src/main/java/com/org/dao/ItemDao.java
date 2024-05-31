package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.org.dto.Item;
import com.org.utility.Helper;

public class ItemDao 
{
	public List<Item> fetchAll()
	{
		EntityManagerFactory emf = Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createQuery("SELECT s FROM Item s");
		
		List<Item> list = query.getResultList();
		
		return list;
		
	}
	
	
	public Item fetchById(int id)
	{
		EntityManagerFactory emf = Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();
		
		return em.find(Item.class, id);
	}
	
	
	
	public List<Item> fetchByEmailAndPassword(String email, String password)
	{
		EntityManagerFactory emf = Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createQuery("SELECT s FROM Item s WHERE s.email=?1 AND s.password=?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		
		List<Item> list = query.getResultList();
		
		return list;
	}
}
