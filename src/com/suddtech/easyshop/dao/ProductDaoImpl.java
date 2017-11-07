package com.suddtech.easyshop.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.suddtech.easyshop.model.Offer;
import com.suddtech.easyshop.model.Product;
@Repository
@Transactional
@Component("productDao")
public class ProductDaoImpl extends GenericDaoImpl<Product> implements ProductDao {

	public ProductDaoImpl(){
		setEntityClass(Product.class);
	}
	@Override
	public Long countProducts() {
		// TODO Auto-generated method stub
		return(Long)getCurrentSession().createCriteria("Product").setProjection(Projections.rowCount()).uniqueResult();
	}

	@Override
	public List<Product> findProductsByFeatured(Boolean featured) {

		Criteria crit = getCurrentSession().createCriteria(Product.class);

		crit.createAlias("Product", "o");
		
		//crit.add(Restrictions.eq("u.enabled", true));
		crit.add(Restrictions.eq("o.featured", featured));

		return crit.list();
	}

	@Override
	public List<Product> findProductEntries(int firstResult, int maxResults) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findProductEntries(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

}
