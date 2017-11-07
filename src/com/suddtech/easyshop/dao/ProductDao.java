package com.suddtech.easyshop.dao;

import java.util.List;

import com.suddtech.easyshop.model.Product;

public interface ProductDao extends GenericDao<Product> {
	public Long countProducts();
	public List<Product>findProductsByFeatured(Boolean featured);
	public List<Product>findProductEntries(int firstResult, int maxResults);
	public List<Product>findProductEntries(Product product);

}
