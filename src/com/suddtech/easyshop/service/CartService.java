package com.suddtech.easyshop.service;

import java.util.List;

import com.suddtech.easyshop.dto.Item;

public interface CartService {
List<Item> getItemsInCart(final long pk);
	
	void addToCart(final long pk, String item);
	
	void removeFromCart(final long pk, String item);


}
