package com.org.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.org.dao.MerchantDao;
import com.org.dao.ProductDao;
import com.org.dto.Merchant;
import com.org.dto.Product;

@Controller
public class ProductController 
{
	@PostMapping("/register_product")
	public void addProduct(@ModelAttribute Product product, @RequestParam int m_id)
	{
		Merchant merchant = new MerchantDao().fetchById(m_id);
		
		ArrayList<Product> products= new ArrayList<>();
		products.add(product);
		
		product.setMerchant(merchant);
		merchant.setProducts(products);
		
		System.out.println(merchant.getName());
		System.out.println(product.getName());
		
		//new ProductDao().saveAndUpdate(product);
		
		//ModelAndView mav = new ModelAndView("addProduct.jsp");
		//mav.addObject("success","Product Added Successfully");
		//return mav;
	}
	
}
