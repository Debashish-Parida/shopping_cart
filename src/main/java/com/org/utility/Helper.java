package com.org.utility;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Helper 
{
	private static EntityManagerFactory emf;
	
	static
	{
		emf=Persistence.createEntityManagerFactory("debashish");
	}
	
	public static EntityManagerFactory getEMFactory()
	{
		return emf;
	}
}
