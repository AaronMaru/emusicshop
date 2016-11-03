package com.emusicshop.controller;


import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.emusicshop.dao.ProductDao;
import com.emusicshop.model.Product;

@Controller
public class MainController {
	
	private Path path;
	
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
	public String adminProductStore(@ModelAttribute("product") Product product, HttpServletRequest request){
		
        MultipartFile productImage = product.getProductImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "/WEB-INF/resources/" + product.getProductName() + ".png");
        System.out.println(path);
        if(productImage != null && !productImage.isEmpty()){
            try {
                productImage.transferTo(new File(path.toString()));
            } catch (Exception ex){
                ex.printStackTrace();
                throw new RuntimeException("Product image saving failed", ex);
            }
        }
        
        
		System.out.println(product);
//		productdao.addProduct(product);
		
		return "redirect:/admin/product";
	}
	
	@RequestMapping("/admin/product/delete/{id}")
	public String adminProductDelete(@PathVariable int id, Model model){
		
		productdao.deleteProduct(id);
				
		return "redirect:/admin/product";
	}
}
