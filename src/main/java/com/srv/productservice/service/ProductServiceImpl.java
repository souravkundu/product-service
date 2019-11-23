package com.srv.productservice.service;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srv.productservice.entity.Brand;
import com.srv.productservice.entity.Product;
import com.srv.productservice.repository.BrandRepository;
import com.srv.productservice.repository.GenericDAO;

enum ProductSizes {
	SMALL("small"), MEDIUM("medium"), LARGE("large");

	private String size;

	private ProductSizes(String size) {
		// TODO Auto-generated constructor stub
		this.size = size;
	}

	public String get() {
		return this.size;
	}
};

enum ProductColors {
	RED("red"), BLACK("black"), WHITE("white"), GREY("grey"), BROWN("brown");
	private String color;

	private ProductColors(String color) {
		// TODO Auto-generated constructor stub
		this.color = color;
	}

	public String get() {
		return this.color;
	}

};

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	GenericDAO<Product, Integer> productDAO;
	
	@Autowired
	BrandRepository brandDAO;

	@Autowired
	public ProductServiceImpl(GenericDAO<Product, Integer> productDAO) {
		this.productDAO = productDAO;
		productDAO.setClass(Product.class);
	}
	

	@Override
	public List<Product> findAllProducts() {
		// TODO Auto-generated method stub
		return productDAO.findAll();
	}

	@Override
	public Product findByID(int id) {
		// TODO Auto-generated method stub
		return productDAO.findByID(id);
	}

	@Override
	public Product updateProduct(Product product) {
		// TODO Auto-generated method stub
		return productDAO.update(product);
	}

	@Override
	public void deleteProduct(Product product) {
		// TODO Auto-generated method stub
		productDAO.delete(product);
	}

	@Override
	public void deleteProductByID(int id) {
		// TODO Auto-generated method stub
		productDAO.deleteByID(id);
	}

	@Override
	public Map<String, List<Product>> groupByBrands() {
		// TODO Auto-generated method stub
		Map<String, List<Product>> map = new HashMap<>();

		for (Brand brand : findAllBrands()) {
			map.put(brand.getName(), productDAO.findAll().stream().filter((product) -> product.getBrand().getName().equals(brand.getName()))
					.collect(Collectors.toList()));
		}
		return map;
	}

	@Override
	public Map<String, List<Product>> groupByColors() {
		Map<String, List<Product>> map = new HashMap<>();

		for (ProductColors pc : EnumSet.allOf(ProductColors.class)) {
			map.put(pc.get(), productDAO.findAll().stream().filter((product) -> product.getColor().equals(pc.get()))
					.collect(Collectors.toList()));
		}
		return map;
	}

	@Override
	public Map<String, List<Product>> groupBySizes() {
		Map<String, List<Product>> map = new HashMap<>();

		for (ProductSizes ps : EnumSet.allOf(ProductSizes.class)) {
			map.put(ps.get(), productDAO.findAll().stream().filter((product) -> product.getSize().equals(ps.get()))
					.collect(Collectors.toList()));
		}
		return map;
	}

	@Override
	public List<Product> findAllProductsByCategory(String category) {

		return findAllProducts().stream().filter((product) -> product.getCategory().getName().equals(category))
				.collect(Collectors.toList());
	}

	@Override
	public List<Brand> findAllBrands() {
		// TODO Auto-generated method stub
		return brandDAO.findAll();
	}

}
