package com.srv.productservice.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GenericDaoImpl<T,ID> implements GenericDAO<T,ID>{
	Class<T> classObject;
	
	@Autowired
	private EntityManager entityManager;
	
	public GenericDaoImpl()  {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setClass(Class<T> classObject) {
		this.classObject = classObject;	
	}

	@Override
	public List<T> findAll() {
		TypedQuery<T> query = entityManager.createQuery("from "+classObject.getName(), classObject);
		return query.getResultList();
	}

	@Override
	public T findByID(ID id) {
		return entityManager.find(classObject, id);
	}

	@Override
	public T update(T t) {
		// TODO Auto-generated method stub
		return entityManager.merge(t);
	}

	@Override
	public void delete(T t) {
		entityManager.remove(t);
	}

	@Override
	public void deleteByID(ID id) {
		T t = findByID(id);
		entityManager.remove(t);	
	}

}
