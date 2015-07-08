package com.suddtech.easyshop.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public abstract class GenericDaoImpl<T extends Serializable> implements
		GenericDao<T> {
	//private static Logger logger = Logger.getLogger(GenericDaoImpl.class);

	protected Class<T> clazz;

	@Autowired
	private SessionFactory sessionFactory;

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void setEntityClass(final Class<T> clazz) {
		this.clazz = clazz;
	}

	@SuppressWarnings("unchecked")
	public T getByID(String id) {
		return (T) getCurrentSession().get(clazz, id);
	}

	public void create(T entity) {
		saveOrUpdate(entity);		
	}

	@SuppressWarnings("unchecked")
	public List<T> search(Map<String, Object> parameterMap) {
		Criteria criteria = getCurrentSession().createCriteria(clazz);
		Set<String> fieldName = parameterMap.keySet();
		for (String field : fieldName) {
			criteria.add(Restrictions.ilike(field, parameterMap.get(field)));
		}
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<T> getList() {
		List<T> objects = getCurrentSession().createQuery(
				"from " + clazz.getName()).list();
		return objects;
	}

	public void update(T entity) {
		saveOrUpdate(entity);
	}

	public void delete(T entity) {
		getCurrentSession().delete(entity);
	}

	public void deleteById(String id) {
		delete(getByID(id));
	}

	public void saveOrUpdate(T entity) {
		getCurrentSession().save(entity);
	}

	protected DetachedCriteria createDetachedCriteria() {
		return DetachedCriteria.forClass(clazz);
	}
	 @SuppressWarnings("unchecked")
	public List<T> findByCriteria(Criterion... criterion) {  
	        Criteria crit = getCurrentSession().createCriteria(clazz);  
	        for (Criterion c : criterion) {  
	            crit.add(c);  
	        }  
	        return crit.list();  
	   }  

	@SuppressWarnings("unchecked")
	@Override
	public boolean exists(String name) {
		Criteria crit = getCurrentSession().createCriteria(clazz);
		crit.add(Restrictions.idEq(name));
		T t = (T) crit.uniqueResult();
		return t != null;
	}
}
