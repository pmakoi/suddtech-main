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
		return offerDao.getList();// .getOffers();
	}

	@Autowired
	public void setOfferDao(OfferDao offerDao) {
		this.offerDao = offerDao;
	}

	@Override
	public void createOffer(Offer offer) {
		offerDao.create(offer);// .saveOrUpdate(offer);

	}

	@Override
	public Offer getOffer(String username) {
		if (username == null) {
			return null;
		}

		List<Offer> offers = offerDao.getOffers(username);

		if (offers.size() == 0) {
			return null;
		}

		return offers.get(0);

		// return offerDao.getOffer(username);
	}

	public boolean hasOffer(String name) {
		if (name == null) {
			return false;
		}
		List<Offer> offers = offerDao.getOffers(name);
		if (offers.size() == 0) {
			return false;
		}
		return true;
	}

	@Override
	public void saveOrUpdate(Offer offer) {
		offerDao.saveOrUpdate(offer);
	}

	@Override
	public void delete(int id) {
		offerDao.delete(id);
	}

}
