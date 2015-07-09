package com.suddtech.easyshop.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.suddtech.easyshop.model.Offer;

@Repository
@Transactional
@Component("offerDao")
public class OfferDaoImpl extends GenericDaoImpl<Offer> implements OfferDao {
	public OfferDaoImpl(){
	this.setEntityClass(Offer.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Offer> getOffers(String username) {
		Criteria crit = getCurrentSession().createCriteria(Offer.class);

		crit.createAlias("user", "u");
		
		crit.add(Restrictions.eq("u.enabled", true));
		crit.add(Restrictions.eq("u.username", username));

		return crit.list();

	}

}
