package com.o.opanadaoBackend.dao;

import com.o.opanadaoBackend.dto.*;

import java.util.List;

public interface UserDetailsDAO {
	List<User> list();
	List<User> selectActiveList();
	
	User get(int id);
	
	boolean add(User user);
	boolean update(User user);
	boolean delete(User user);
}
