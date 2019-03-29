package com.bnr.onlineShopping.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bnr.onlineShopping.exception.ProductNotFoundException;
import com.bnr.shoppingbackend.dao.CategoryDao;
import com.bnr.shoppingbackend.dao.ProductDao;
import com.bnr.shoppingbackend.dto.Category;
import com.bnr.shoppingbackend.dto.Product;




@Controller
public class PageController {
	
	private static final Logger logger=LoggerFactory.getLogger(PageController.class);
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	ProductDao productDao;
	
	@RequestMapping(value= {"/","/home","/index"})
	public ModelAndView index() {
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title","Home");
		mv.addObject("userClicksHome",true);
		//pass list of categories
		mv.addObject("categories",categoryDao.listAllCategories());
		
		logger.info("Inside page controller");
		logger.debug("Inside page controller debug");
		return mv;
	}
	
	@RequestMapping(value= "/about")
	public ModelAndView about() {
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title","About Us");
		mv.addObject("categories",categoryDao.listAllCategories());
		mv.addObject("userClicksAbout",true);
		return mv;
	}
	
	@RequestMapping(value= "/contact")
	public ModelAndView contact() {
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title","Contact Us");
		mv.addObject("userClicksContact",true);
		return mv;
	}
	
	//methods to load all products and based on category
	@RequestMapping(value="/show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title","All Products");
		mv.addObject("categories",categoryDao.listAllCategories());
		mv.addObject("userClicksAllProducts",true);
		return mv;
	}
	//to fetch single category
	
	@RequestMapping(value="/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id")int id) {
		ModelAndView mv=new ModelAndView("page");
		//to fecth single category
		Category category=null;
		category=categoryDao.get(id);
		mv.addObject("category",category);
		
		mv.addObject("categories",categoryDao.listAllCategories());
		mv.addObject("title",category.getName());
		mv.addObject("userClicksCategoryProducts",true);
		return mv;
	}
	
	/*show single product***/
	@RequestMapping(value="/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable("id")int id)throws ProductNotFoundException {
		ModelAndView mv=new ModelAndView("page");
		Product product=productDao.get(id);
		if(product==null)
			throw new ProductNotFoundException();
		product.setViews(product.getViews()+1);
		productDao.update(product);
		mv.addObject("product",product);
		mv.addObject("title",product.getName());
		mv.addObject("userClicksShowProduct",true);
		return mv;
	}
	
}
