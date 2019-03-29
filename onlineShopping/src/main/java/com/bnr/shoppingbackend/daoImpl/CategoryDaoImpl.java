package com.bnr.shoppingbackend.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bnr.shoppingbackend.dao.CategoryDao;
import com.bnr.shoppingbackend.dto.Category;

@Repository("categoryDao")
@Transactional
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	private SessionFactory sessionFactory;
	public static List<Category> categories = new ArrayList<>();

	@Override
	public List<Category> listAllCategories() {
		String query="FROM Category WHERE active=:active";
		Query<Category> result=sessionFactory.getCurrentSession().createQuery(query);
		result.setParameter("active",true);
		return result.getResultList();
	}

	@Override
	public Category get(int id) {
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));

	}

	@Override
	public boolean add(Category category) {
		try {
			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean update(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {
		category.setActive(false);
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

}
