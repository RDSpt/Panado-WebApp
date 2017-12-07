package com.o.opanadaoBackend.daoimpl;

import com.o.opanadaoBackend.dao.CategoryDAO;
import com.o.opanadaoBackend.dto.Category;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean add(Category category) {
		
		try {
			//add category to database
			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//Update Single Product
	@Override
	public boolean update(Category category) {
		
		try {
			//add category to database
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	//Delete Single Product
	
	@Override
	public boolean delete(Category category) {
		
		category.setActive(false);
		try {
			//add category to database
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public List<Category> list() {
		
		String selectActiveProduct = "FROM Category WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveProduct);
		
		query.setParameter("active", true);
		
		return query.getResultList();
	}
	
	//Getting Single Product based on ID
	@Override
	public Category get(int id) {
		
		return sessionFactory.getCurrentSession().get(Category.class, id);
	}
}
