package com.o.opanadaoBackend.dao;

import com.o.opanadaoBackend.dto.*;

import java.util.List;

public interface UserDetailsDAO {
	List<UserDetails> list();
	List<UserDetails> selectActiveList();
	
	UserDetails get(int id);
	
	boolean add(UserDetails userDetails);
	boolean update(UserDetails userDetails);
	boolean delete(UserDetails userDetails);
}
