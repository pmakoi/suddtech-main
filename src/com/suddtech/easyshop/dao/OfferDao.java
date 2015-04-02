package com.suddtech.easyshop.dao;

import java.util.List;

import com.suddtech.easyshop.model.Offer;

public interface OfferDao {
	public List<Offer> getOffers();
	public Offer getOffer(int id);
	public boolean delete(int id);
	public boolean create(Offer offer);
	public boolean update(Offer offer);
	public int[] create(List<Offer> offers);
}
