package com.suddtech.easyshop.service;

import java.util.List;

import com.suddtech.easyshop.model.Offer;

public interface OfferService {
	public List<Offer> getCurrent();

	public void createOffer(Offer offer);

	
}
