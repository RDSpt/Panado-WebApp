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
	public List<UserDetails> list() {
		
		return sessionFactory.getCurrentSession().createQuery("FROM UserDetails", UserDetails.class).getResultList();
	}
	
	@Override
	public List<UserDetails> selectActiveList() {
		String query= "FROM UserDetails WHERE ENABLED = :enabled";
		return sessionFactory.getCurrentSession().createQuery(query, UserDetails.class).setParameter("enabled", true)
				.getResultList();
	}
	
	@Override
	public UserDetails get(int id) {
		
		return sessionFactory.getCurrentSession().get(UserDetails.class, id);
	}
	
	@Override
	public boolean add(UserDetails userDetails) {
		
		try {
			sessionFactory.getCurrentSession().persist(userDetails);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@Override
	public boolean update(UserDetails userDetails) {
		
		try {
			sessionFactory.getCurrentSession().update(userDetails);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@Override
	public boolean delete(UserDetails userDetails) {
		
		try {
			userDetails.setEnabled(false);
			sessionFactory.getCurrentSession().update(userDetails);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
