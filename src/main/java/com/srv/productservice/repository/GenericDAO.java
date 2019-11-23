package com.srv.productservice.repository;

import java.util.List;

public interface GenericDAO<T, ID> {
	void setClass(Class<T> classObject);
	List<T> findAll();
	T findByID(ID id);
	T update(T t);
	void delete(T t);
	void deleteByID(ID id);
}
