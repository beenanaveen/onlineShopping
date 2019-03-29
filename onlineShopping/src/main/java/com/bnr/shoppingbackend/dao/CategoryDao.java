package com.bnr.shoppingbackend.dao;

import java.util.List;

import com.bnr.shoppingbackend.dto.Category;

public interface CategoryDao {
	
	boolean add(Category category);
	public List<Category> listAllCategories();

	public Category get(int id);
	public boolean update(Category category);
	public boolean delete(Category category);
}
