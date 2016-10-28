package com.emusicshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.emusicshop.dao.ProductDao;
import com.emusicshop.model.Product;

@Controller
public class MainController {

	@Autowired
	@Qualifier("jdbctemplate")
	private ProductDao productdao;
	
	@RequestMapping("/")
	public String home(){
		return "home";
	}
	@RequestMapping("/product")
	public String productList(Model model){
		
		model.addAttribute("products", productdao.getProductList());
		List<Product> prodocts = productdao.getProductList();
		System.out.println(prodocts.get(0).getProductName());
		return "product/index";
	}
	@RequestMapping("/product/{id}")
	public String productShow(@PathVariable int id, Model model){
		
		model.addAttribute("product", productdao.getProductById(id));
		System.out.println(productdao.getProductById(id));
		return "product/show";
	}
	
	@RequestMapping("/admin")
	public String admin(){
		return "admin/index";
	}
	@RequestMapping("/admin/product")
	public String adminProductList(Model model){
		
		model.addAttribute("products", productdao.getProductList());
		
		return "admin/product/index";
	}
	@RequestMapping("/admin/product/add")
	public String adminProductAdd(Model model){
		
		return "admin/product/add";
	}
	
}
