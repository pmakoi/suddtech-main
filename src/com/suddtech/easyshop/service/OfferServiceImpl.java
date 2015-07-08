package com.suddtech.easyshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suddtech.easyshop.dao.OfferDao;
import com.suddtech.easyshop.model.Offer;

@Service("offerService")
public class OfferServiceImpl implements OfferService {
	private OfferDao offerDao;

	public List<Offer> getCurrent() {
		return offerDao.getList();//.getOffers();
	}
	@Autowired
	public void setOfferDao(OfferDao offerDao) {
		this.offerDao = offerDao;
	}
	@Override
	public void createOffer(Offer offer) {
		offerDao.create(offer);//.saveOrUpdate(offer);
		
	}


}
