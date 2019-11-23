package com.srv.productservice.service;

import java.util.List;
import java.util.Map;

import com.srv.productservice.entity.Brand;
import com.srv.productservice.entity.Product;

public interface ProductService {
	List<Product> findAllProducts();
	//List<Brand> findAllBrands();
	
	
	
	Product findByID(int id);
	void deleteProduct(Product product);
	Product updateProduct(Product product);
	void deleteProductByID(int id);
	
	Map<String,List<Product>> groupByBrands( );
	Map<String,List<Product>> groupByColors( );
	Map<String,List<Product>> groupBySizes( );
	
	Map<String,List<Product>> groupByBrandsValue(String key);
	Map<String,List<Product>> groupByColorsValue(String key);
	Map<String,List<Product>> groupBySizesValue(String key);
	List<Product> findAllProductsByCategory(String category);



	List<Brand> findAllBrands();

}
