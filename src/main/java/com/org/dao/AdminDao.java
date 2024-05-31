package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.org.dto.Admin;
import com.org.utility.Helper;

public class AdminDao 
{
	public List<Admin> fetchAll()
	{
		EntityManagerFactory emf = Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createQuery("SELECT s FROM Admin s");
		
		List<Admin> list = query.getResultList();
		
		return list;
		
	}
	
	
	public Admin fetchById(int id)
	{
		EntityManagerFactory emf = Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();
		
		return em.find(Admin.class, id);
	}
	
	
	
	public List<Admin> fetchByEmailAndPassword(String email, String password)
	{
		EntityManagerFactory emf = Helper.getEMFactory();
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createQuery("SELECT s FROM Admin s WHERE s.email=?1 AND s.password=?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		
		List<Admin> list = query.getResultList();
		
		return list;
	}
}
