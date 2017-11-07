package com.suddtech.easyshop.service;
import java.util.List;

import com.suddtech.easyshop.model.Product;
public interface ProductService {
public List<Product>getFeaturedProdcuts();
public long countAllProducts();
public void deleteProduct(Product product);
public Product findProduct(Long id);
public List<Product>findAllProducts();
public List<Product>findProductEntries();
public void save(Product product);
}
