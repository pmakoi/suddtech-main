package com.suddtech.easyshop.model;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
@Component
@Scope(value=WebApplicationContext.SCOPE_SESSION, proxyMode=ScopedProxyMode.TARGET_CLASS)
public class Cart {
	private Map<Product, Integer> contents = new HashMap<Product, Integer>();

	public Map<Product, Integer> getContents() {
		return contents;
	}

	public void setContents(Map<Product, Integer> contents) {
		this.contents = contents;
	}

	public void addProduct(Product product, int count) {
		if (contents.containsKey(product)) {
			contents.put(product, contents.get(product) + count);
		} else {
			contents.put(product, count);
		}

	}

	public void removeProduct(Product product) {
		contents.remove(product);
	}
	public void clear(){
		contents.clear();
	}
	public double getTotalCost(){
		double totalCost=0;
		for(Product product:contents.keySet()){
			totalCost+=product.getPrice();
		}
		return totalCost;
	}
public String toString(){
	return contents.toString();
}
}