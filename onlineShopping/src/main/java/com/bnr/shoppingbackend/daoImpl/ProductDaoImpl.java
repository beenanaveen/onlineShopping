package com.bnr.shoppingbackend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bnr.shoppingbackend.dao.ProductDao;
import com.bnr.shoppingbackend.dto.Product;

@Repository("productDao")
@Transactional
public class ProductDaoImpl implements ProductDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean add(Product product) {
		try {
			sessionFactory.getCurrentSession().persist(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Product product) {
		product.setActive(false);
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Product> listAllProducts() {
		String sql = "FROM Product";
		Query query = sessionFactory.getCurrentSession().createQuery(sql, Product.class);
		return query.getResultList();
	}

	@Override
	public Product get(int productId) {
		return sessionFactory.getCurrentSession().get(Product.class, productId);
	}

	@Override
	public List<Product> listActiveProducts() {
		String sql = "FROM Product WHERE active=:active";
		Query query = sessionFactory.getCurrentSession().createQuery(sql, Product.class).setParameter("active", true);
		return query.getResultList();
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		String sql = "FROM Product WHERE active=:active AND categoryId=:categoryId";
		Query query = sessionFactory.getCurrentSession().createQuery(sql, Product.class).setParameter("active", true)
				.setParameter("categoryId", categoryId);
		return query.getResultList();
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		String sql="FROM Product WHERE active=:active ORDER BY id";
		Query query=sessionFactory.getCurrentSession().createQuery(sql,Product.class)
				.setParameter("active", true)
		        .setMaxResults(count);
		return query.getResultList();
	}

}
