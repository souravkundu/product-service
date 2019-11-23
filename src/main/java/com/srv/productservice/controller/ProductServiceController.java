package com.srv.productservice.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

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
	
	@RequestMapping("/")
	public void redirectURL(HttpServletResponse response) {
		 try {
			response.sendRedirect("all");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	public Map<String,List<Product>> groupByBrands(@RequestParam(name="brand" ,required = false) String brand ) {
		if(brand == null)
		return productService.groupByBrands();
		else 
			return productService.groupByBrandsValue(brand);
	}
	
	@GetMapping("/group/color")
	public Map<String,List<Product>> groupByColor(@RequestParam(name="color" ,required = false) String color ) {
		if(color == null)
		return productService.groupByColors();
		else
		return productService.groupByColorsValue(color);
	}
	
	@GetMapping("/group/size")
	public Map<String,List<Product>> groupBySize(@RequestParam(name="size" ,required = false) String size ) {
		if(size == null)
		return productService.groupBySizes();
		else
			return productService.groupBySizesValue(size);
	}


}
