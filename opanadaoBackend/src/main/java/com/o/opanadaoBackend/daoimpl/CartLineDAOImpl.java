package com.o.opanadaoBackend.daoimpl;

import com.o.opanadaoBackend.dao.CartLineDAO;
import com.o.opanadaoBackend.dto.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("cartLineDAO")
@Transactional
public class CartLineDAOImpl implements CartLineDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public CartLine get(int id) {
		return sessionFactory.getCurrentSession()
		                     .get(CartLine.class,
		                          id);
	}
	@Override
	public boolean add(CartLine cartLine) {
		try {
			//add category to database
			sessionFactory.getCurrentSession().persist(cartLine);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean update(CartLine cartLine) {
		try {
			//add category to database
			sessionFactory.getCurrentSession().update(cartLine);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean delete(CartLine cartLine) {
		try {
			//add category to database
			sessionFactory.getCurrentSession().delete(cartLine);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public List list(int cartId) {
		String query = "FROM CartLine WHERE cartId = :cartId";
		return sessionFactory.getCurrentSession()
		                     .createQuery(query)
		                     .setParameter("cartId",
		                                   cartId)
		                     .getResultList();
	}
	@Override
	public List listAvailable(int cartId) {
		String query = "FROM CartLine WHERE cartId = :cartId AND available = :available";
		return sessionFactory.getCurrentSession()
		                     .createQuery(query)
		                     .setParameter("cartId",
		                                   cartId)
		                     .setParameter("available",
		                                   true)
		                     .getResultList();
	}
	@Override
	public CartLine getByCartAndProduct(int cartId, int productId) {
		String query = "FROM CartLine WHERE cartId = :cartId AND product.id = :productId";
		try {
			return sessionFactory.getCurrentSession()
			                     .createQuery(query,
			                                  CartLine.class)
			                     .setParameter("cartId",
			                                   cartId)
			                     .setParameter("productId",
			                                   productId)
			                     .getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public boolean updateCart(Cart cart) {
		try {
			sessionFactory.getCurrentSession().update(cart);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
