package com.srv.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srv.productservice.entity.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer> {

}
