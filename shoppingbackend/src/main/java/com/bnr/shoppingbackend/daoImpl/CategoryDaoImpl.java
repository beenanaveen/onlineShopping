package com.bnr.shoppingbackend.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bnr.shoppingbackend.dao.CategoryDao;
import com.bnr.shoppingbackend.dto.Category;

@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao{

	public static List<Category> categories=new ArrayList<>();
	static {
		Category c=new Category();
		c.setId(1);
		c.setName("Laptop");
		c.setDescription("Laptop description");
		c.setImageUrl("Cat1.png");
		categories.add(c);
		c=new Category();
		c.setId(2);
		c.setName("Telivison");
		c.setDescription("Telivision description");
		c.setImageUrl("Cat2.png");
		categories.add(c);
		
		c=new Category();
		c.setId(3);
		c.setName("Mobile");
		c.setDescription("Mobile description");
		c.setImageUrl("Cat3.png");
		categories.add(c);
		
		
	}
	@Override
	public List<Category> listAllCategories(){
	
		return categories;
	}
	

}
