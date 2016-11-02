package com.emusicshop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
//		List<Product> prodocts = productdao.getProductList();
//		System.out.println(prodocts.get(0).getProductName());
		return "product/index";
	}
	@RequestMapping("/product/{id}")
	public String productShow(@PathVariable int id, Model model){
		
		model.addAttribute("product", productdao.getProductById(id));
		
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
		
		Product product = new Product();
		product.setProductCategory("instrument");
		product.setProductCondition("new");
		product.setProductStatus("active");
		product.setProductPrice(0.0);
		model.addAttribute(product);
		return "admin/product/add";
	}
	
	@RequestMapping(value = "/admin/product/add", method = RequestMethod.POST)
	public String adminProductStore(@ModelAttribute("product") Product product){
		
//		System.out.println(product.toString());
		productdao.addProduct(product);
		
		return "redirect:/admin/product";
	}
	
	@RequestMapping("/admin/product/delete/{id}")
	public String adminProductDelete(@PathVariable int id, Model model){
		
		productdao.deleteProduct(id);
				
		return "redirect:/admin/product";
	}
}
