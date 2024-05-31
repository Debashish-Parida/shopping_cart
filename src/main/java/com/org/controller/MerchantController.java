package com.org.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.org.dao.AdminDao;

import com.org.dao.MerchantDao;
import com.org.dto.Admin;

import com.org.dto.Merchant;

@Controller
public class MerchantController 
{
	@PostMapping("/register_merchant")
	public ModelAndView RegisterMerchant(@ModelAttribute Merchant merchant)
	{
		/*AdminDao dao=new AdminDao(); Admin admin = dao.fetchById(1);
		      OR*/
		Admin admin=new AdminDao().fetchById(1);
		
		ArrayList<Merchant> merchants = new ArrayList<>();
		
		merchants.add(merchant);
		
		merchant.setAdmin(admin);
		admin.setMerchants(merchants);
		
		/*MerchantDao dao2=new MerchantDao(); dao2.saveAndUpdate(merchant);
		         OR */
		new MerchantDao().saveAndUpdate(merchant);
		
		ModelAndView mav = new ModelAndView("registerMerchant.jsp");
		
		mav.addObject("registered", "Registration Successfull");
		
		return mav;
		
	}
	
	@PostMapping("/login_merchant")
	public ModelAndView loginMerchant(@RequestParam String email, @RequestParam String password, HttpSession session)
	{
          List<Merchant> merchants=new MerchantDao().fetchByEmailAndPassword(email, password);
		
		if(merchants.isEmpty())
		{
			ModelAndView mav=new ModelAndView("loginMerchant.jsp");
			mav.addObject("fail", "Invalid mail or password");
			return mav;
		}
		
		session.setAttribute("merchantObj", merchants.get(0));
		ModelAndView mav = new ModelAndView("merchant/merchant_home.jsp");
		return mav;
		
		
		
	}
}
