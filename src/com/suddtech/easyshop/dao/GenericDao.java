package com.suddtech.easyshop.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Criterion;

public interface GenericDao<T> {
	T getByID(String id);

	List<T> getList();

	List<T> search(Map<String, Object> parameterMap);

	void create(T entity);

	void update(T entity);

	void delete(T entity);

	void delete(int id);

	public T find(int id);

	void saveOrUpdate(T entity);

	// void deleteById(String id);

	List<T> findByCriteria(Criterion... criterion);

	public boolean exists(String username);

}
