package com.bnr.shoppingbackend.dao;

import java.util.List;

import com.bnr.shoppingbackend.dto.Category;

public interface CategoryDao {
	public List<Category> listAllCategories();
}
