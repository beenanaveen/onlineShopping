package com.bnr.shoppingbackend;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bnr.shoppingbackend.dao.CategoryDao;
import com.bnr.shoppingbackend.dto.Category;

public class CategoryTest {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDao categoryDao;
	private Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.bnr.shoppingbackend");
		context.refresh();
		categoryDao = context.getBean("categoryDao", CategoryDao.class);
	}

	/*
	 * @Test public void testAddCategory() { category=new Category();
	 * category.setName("Telivision");
	 * category.setDescription("Television description");
	 * category.setImageUrl("Cat2.png");
	 * assertEquals("Successfully added Category",true,categoryDao.add(category));
	 * 
	 * }
	 */
	/*
	 * @Test public void testUpdateCategory() { category=categoryDao.get(2);
	 * category.setDescription("Modified Television");
	 * assertEquals("Succesfull to update category",true,categoryDao.update(category
	 * )); }
	 */
	/*
	 * @Test public void testDeleteCategory() { category=categoryDao.get(2);
	 * 
	 * assertEquals("Succesfull to update category",true,categoryDao.delete(category
	 * )); }
	 */

	/*
	 * @Test public void testListAllCategories() { List<Category>
	 * list=categoryDao.listAllCategories();
	 * 
	 * assertEquals("Succesfull to selected category",1,categoryDao.
	 * listAllCategories().size()); }
	 */
	@Test
	public void testCRUDCategory() {
		category = new Category();
		category.setName("Telivision");
		category.setDescription("Television description");
		category.setImageUrl("Cat1.png");
		assertEquals("Successfully added Category", true, categoryDao.add(category));
		
		category = new Category();
		category.setName("Laptop");
		category.setDescription("Laptop description");
		category.setImageUrl("Cat2.png");
		assertEquals("Successfully added Category", true, categoryDao.add(category));

		category = new Category();
		category.setName("Mobile");
		category.setDescription("Mobile description");
		category.setImageUrl("Cat3.png");
		assertEquals("Successfully added Category", true, categoryDao.add(category));

		// fetching and updating
		category = categoryDao.get(2);
		category.setDescription("Modified Television");
		assertEquals("Succesfull to update category", true, categoryDao.update(category));
		assertEquals("Succesfull to update category", true, categoryDao.delete(category));
		
		// testing getting all categories in the table
		List<Category> list = categoryDao.listAllCategories();
		assertEquals("Succesfull to selected category", 2, categoryDao.listAllCategories().size());

	}
}
