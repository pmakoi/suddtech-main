package com.suddtech.easyshop.dto;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class WebCart implements Cart {

	 private long cartId;
		private SortedMap<String, Item> items = new TreeMap<String, Item>();

	    public long getCartId() {
	        return cartId;
	    }

	    public void setCartId(final long cartId) {
	        this.cartId = cartId;
	    }

	    public void addItem(String item) {
			if (!items.containsKey(item)) {
				items.put(item, new WebItem(item, new BigDecimal(Math.random(), new MathContext(2, RoundingMode.HALF_EVEN)), BigDecimal.ONE));
			} else if (items.containsKey(item)) {
				final Item old = items.get(item);
				items.put(item, new WebItem(old, BigDecimal.ONE.add(old.getQuantity())));
			}
		}

		public List<Item> getItems() {
			return new ArrayList<Item>(items.values());
		}

		public void removeItem(String item) {
			if (items.containsKey(item)) {
				items.remove(item);
			}		
		}

		
		
}
