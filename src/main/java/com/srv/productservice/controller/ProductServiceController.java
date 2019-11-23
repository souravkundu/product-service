package com.srv.productservice.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.srv.productservice.entity.Product;
import com.srv.productservice.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductServiceController {

	@Autowired
	ProductService productService;
	
	public ProductServiceController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/all")
	public List<Product> getAllProducts(@RequestParam(name="category" ,required = false) String category ) {
		if(category == null)
		return productService.findAllProducts();
		else {
			return productService.findAllProductsByCategory(category);
		}
	}
	
	@GetMapping("/group/brand")
	public Map<String,List<Product>> groupByBrands( ) {
		return productService.groupByBrands();
	}
	
	@GetMapping("/group/color")
	public Map<String,List<Product>> groupByColor( ) {
		return productService.groupByColors();
	}
	
	@GetMapping("/group/size")
	public Map<String,List<Product>> groupBySize( ) {
		return productService.groupBySizes();
	}
	
	

}
