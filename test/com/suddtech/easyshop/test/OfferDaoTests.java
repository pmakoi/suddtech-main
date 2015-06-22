package com.suddtech.easyshop.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.suddtech.easyshop.dao.OfferDao;
import com.suddtech.easyshop.dao.UserDao;
import com.suddtech.easyshop.model.Offer;
import com.suddtech.easyshop.model.User;

public class OfferDaoTests {
	@Autowired
	UserDao userDao;
	
	@Autowired
	OfferDao offerDao;
	@Test
	public void testOffers(){
	User user=new User("kjuak_11","Peter Makoi","hellothere","kjuak@ya.com",true,"user");	
	
	userDao.create(user);
	Offer offer=new Offer(user,"This is a test offer");
	offerDao.create(offer);
	List<Offer> offers=offerDao.getList();
	assertEquals("should be one offer in the database",1, offers.size());
	assertEquals("Retrieved offer should match created offer.", offer, offers.get(0));
	
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public void setOfferDao(OfferDao offerDao) {
		this.offerDao = offerDao;
	}
	

}
