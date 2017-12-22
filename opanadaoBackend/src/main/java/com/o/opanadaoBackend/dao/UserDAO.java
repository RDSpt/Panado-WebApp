package com.o.opanadaoBackend.dao;

import com.o.opanadaoBackend.dto.*;

import java.util.List;

public interface UserDAO {
	
	boolean addUser(User user);
	
	boolean deleteUser(User user);
	
	User getByEmail(String email);
	
	boolean addAddress(Address address);
	
	Address getBillingAddress(User user);
	
	List<Address> getListShippingAddresses(User user);
}
