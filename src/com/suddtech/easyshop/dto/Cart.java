package com.suddtech.easyshop.dto;

import java.io.Serializable;
import java.util.List;

public interface Cart extends Serializable{
long getCartId();
	
	List<Item> getItems();
	
	void addItem(String item);
	
	void removeItem(String item);
}
