package com.srv.productservice.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;



@Entity(name="product")
public class Product {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int SKU;
	
	@Column(name="name")
	String name;
	
	@OneToOne
	@JoinColumn(name="brand_id")
	Brand brand;
	
	@Column(name="price")
	int price;
	
	@Column(name="color ")
	String color;
	String size;
	
	@OneToOne
	@JoinColumn(name="seller_id")
	Seller seller;
	
	@OneToOne
	@JoinColumn(name="category_id")
	Category category;
	
	
	public Seller getSeller() {
		return seller;
	}


	public void setSeller(Seller seller) {
		this.seller = seller;
	}


	public Product() {
		// TODO Auto-generated constructor stub
	}


	public int getSKU() {
		return SKU;
	}


	public void setSKU(int sKU) {
		SKU = sKU;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Brand getBrand() {
		return brand;
	}


	public void setBrand(Brand brand) {
		this.brand = brand;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getSize() {
		return size;
	}


	public void setSize(String size) {
		this.size = size;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public Product(String name, Brand brand, int price, String color, String size, Seller seller, Category category) {
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.color = color;
		this.size = size;
		this.seller = seller;
		this.category = category;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof Product) {
		Product newProduct = (Product)obj;
		 return this.getSKU() == newProduct.getSKU() ;
		}
		else {
			return false;
		}
	}

}
