package com.bnr.shoppingbackend.dao;

import java.util.List;

import com.bnr.shoppingbackend.dto.Product;

public interface ProductDao {
	public boolean add(Product product);

	boolean update(Product product);

	boolean delete(Product product);

	List<Product> listAllProducts();
	Product get(int productId);
	
	//business methods
	List<Product> listActiveProducts();
	List<Product> listActiveProductsByCategory(int categoryId);
	List<Product> getLatestActiveProducts(int count);
	
}
