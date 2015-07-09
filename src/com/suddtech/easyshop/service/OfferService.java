package com.suddtech.easyshop.service;

import java.util.List;

import com.suddtech.easyshop.model.Offer;

public interface OfferService {
	public List<Offer> getCurrent();

	public void createOffer(Offer offer);

	public Offer getOffer(String username);

	public void saveOrUpdate(Offer offer);

	public void delete(int id);

	
}
