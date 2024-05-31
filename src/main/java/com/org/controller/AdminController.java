package com.org.controller;

import javax.persistence.EntityManagerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.org.utility.Helper;

@Controller
public class AdminController 
{
	@RequestMapping("/hii")
	public String m1()
	{
		EntityManagerFactory emf = Helper.getEMFactory();
		
		System.out.println("success");
		return "registerMerchant.jsp";
	}
}
