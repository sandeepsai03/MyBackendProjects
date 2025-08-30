package com.excelr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.excelr.entity.Product;
import com.excelr.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/")
	public String getProductionForm(Model model) {
		Product p1=new Product();
		model.addAttribute("product",p1);
		return "save";
	}
	
	
	//@ModelAttribute:Binds form data (like POST request) to a Java object and puts it in the model
	
	@PostMapping("/product")
	public String saveProductData(@ModelAttribute("product") Product product,Model model) {
		
		productService.saveProduct(product);
		model.addAttribute("msg","product saved successfully...");
		return "success";
	}
	
	@GetMapping("/products")
	public String findByAllProducts(Model model) {
		List<Product> products=productService.getAllProducts();
		model.addAttribute("products",products);
		return "findByAll";
	}
	
	//@Pathvariable :Extracts a value from the URL path and assigns it to a method parameter
	@GetMapping("/product/{id}")
	public String getByProductId(@PathVariable("id") Integer productId,Model model) {
		
		Product product=productService.getProductById(productId);
		model.addAttribute("product",product);
		return "getByProduct";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteByProductId(@PathVariable("id") Integer productId,Model model) {
		
		productService.deleteProduct(productId);
		model.addAttribute("msg","product deleted successfully");
		return "deleteSuccess";
	}
}
