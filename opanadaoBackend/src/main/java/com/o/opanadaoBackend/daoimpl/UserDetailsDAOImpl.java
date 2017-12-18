package com.o.opanadaoBackend.daoimpl;

import com.o.opanadaoBackend.dao.UserDetailsDAO;
import com.o.opanadaoBackend.dto.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("userDetailsDAO")
@Transactional
public class UserDetailsDAOImpl implements UserDetailsDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<User> list() {
		
		return sessionFactory.getCurrentSession().createQuery("FROM UserDetails", User.class).getResultList();
	}
	
	@Override
	public List<User> selectActiveList() {
		String query= "FROM UserDetails WHERE ENABLED = :enabled";
		return sessionFactory.getCurrentSession().createQuery(query, User.class).setParameter("enabled", true)
				.getResultList();
	}
	
	@Override
	public User get(int id) {
		
		return sessionFactory.getCurrentSession().get(User.class, id);
	}
	
	@Override
	public boolean add(User user) {
		
		try {
			sessionFactory.getCurrentSession().persist(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@Override
	public boolean update(User user) {
		
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@Override
	public boolean delete(User user) {
		
		try {
			user.setEnabled(false);
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
