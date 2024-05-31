package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.org.dto.Admin;
import com.org.dto.Merchant;
import com.org.utility.Helper;

public class MerchantDao 
{
	public List<Merchant> fetchAll()
	{
		EntityManagerFactory emf = Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createQuery("SELECT s FROM Merchant s");
		
		List<Merchant> list = query.getResultList();
		
		return list;
		
	}
	
	
	public Merchant fetchById(int id)
	{
		EntityManagerFactory emf = Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();
		
		return em.find(Merchant.class, id);
	}
	
	
	
	public List<Merchant> fetchByEmailAndPassword(String email, String password)
	{
		EntityManagerFactory emf = Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createQuery("SELECT s FROM Merchant s WHERE s.email=?1 AND s.password=?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		
		
		List<Merchant> list = query.getResultList();
		
		return list;
	}
	
	public void saveAndUpdate(Merchant merchant)
	{
		EntityManagerFactory emf = Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		Admin admin= merchant.getAdmin();
		
		et.begin();
		em.merge(admin);
		et.commit();
	}
}
