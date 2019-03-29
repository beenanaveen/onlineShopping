package com.bnr.shoppingbackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bnr.shoppingbackend.dao.ProductDao;
import com.bnr.shoppingbackend.daoImpl.ProductDaoImpl;
import com.bnr.shoppingbackend.dto.Product;

public class ProductTest {
	private static  AnnotationConfigApplicationContext context;

	private static ProductDao productDao;
	private Product product;
	@BeforeClass
	public static void  init() {
		context=new AnnotationConfigApplicationContext();
		context.scan("com.bnr.shoppingbackend");
		context.refresh();
		productDao=context.getBean("productDao",ProductDao.class);
	}
	
	@Test
	public void testProductCRUD() {
		/*product=new Product();
		product.setActive(true);
		product.setBrand("Samsung");
		product.setCategoryId(3);
		product.setDescription("Samsung galaxy");
		product.setName("Samsung");
		product.setSupplierId(1);
		product.setUnitPrice(6000);
		assertEquals("Something went wrong while adding product",true,productDao.add(product));
	
		product.setBrand("Samsung Galaxy");
		assertEquals("Something went wrong while updating product",true,productDao.update(product));
*/
		//assertEquals("Something went wrong while updating product",true,productDao.delete(product));
		assertEquals("Something went wrong while getting list product",5,productDao.listAllProducts().size());
		assertEquals("Something went wrong while getting list product",4,productDao.listActiveProducts().size());
		assertEquals("Something went wrong while getting list product",2,productDao.listActiveProductsByCategory(1).size());
		assertEquals("Something went wrong while getting list product",2,productDao.getLatestActiveProducts(2).size());
		
	}
	

}
