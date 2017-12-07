package com.o.opanadaoBackend.daoimpl;

import com.o.opanadaoBackend.dao.ProductDAO;
import com.o.opanadaoBackend.dto.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Product get(int productId) {
		
		return sessionFactory.getCurrentSession().get(Product.class, productId);
	}
	
	@Override
	public List<Product> list() {
		
		return sessionFactory.getCurrentSession().createQuery("FROM Product", Product.class).getResultList();
	}
	
	@Override
	public boolean add(Product product) {
		
		try {
			sessionFactory.getCurrentSession().persist(product);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@Override
	public boolean update(Product product) {
		
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@Override
	public boolean delete(Product product) {
		
		try {
			product.setActive(false);
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@Override
	public List<Product> listActiveProducts() {
		
		String selectActiveProducts = "FROM Product WHERE active = :active";
		return sessionFactory.getCurrentSession().createQuery(selectActiveProducts, Product.class).setParameter
				("active", true).getResultList();
	}
	
	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		
		String selectActiveProductsByCategory = "FROM Product WHERE active = :active AND categoryId = :categoryId";
		return sessionFactory.getCurrentSession().createQuery(selectActiveProductsByCategory, Product.class).setParameter
				("active", true).setParameter("categoryId", categoryId).getResultList();
	}
	
	@Override
	public List<Product> getLatestActiveProducts(int count) {
		
		String selectlatestActiveProducts = "FROM Product  WHERE active = :active ORDER BY id";
		return sessionFactory
				.getCurrentSession()
				.createQuery(selectlatestActiveProducts, Product.class)
				.setParameter("active", true)
				.setMaxResults(count)
				.getResultList();
	}
}
