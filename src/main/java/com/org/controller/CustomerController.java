package com.org.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.org.dao.CustomerDao;
import com.org.dto.Cart;
import com.org.dto.Customer;

@Controller
public class CustomerController 
{
	@PostMapping("/register_customer")
	public ModelAndView RegisterCustomer(@ModelAttribute Customer customer)
	{
		Cart cart= new Cart();
		
		customer.setCart(cart);
		cart.setCustomer(customer);
		
		new CustomerDao().saveAndUpdate(customer);
		
		ModelAndView mav =new ModelAndView("RegisterCustomer.jsp");
		
		mav.addObject("success", "Registration Successfull");
		return mav;
	}
	
	@PostMapping("/login_customer")
	public ModelAndView loginCustomer(@RequestParam String email, @RequestParam String password, HttpSession session)
	{
		List<Customer> customers=new CustomerDao().fetchByEmailAndPassword(email,password);
		
		if(customers.isEmpty())
		{
			ModelAndView mav=new ModelAndView("LoginCustomer.jsp");
			mav.addObject("fail", "Invalid mail or password");
			return mav;
		}
		
		session.setAttribute("customerObj", customers.get(0));
		ModelAndView mav = new ModelAndView("customer/customer_home.jsp");
		return mav;
	}
}
