package com.o.panadao.model;

import com.o.opanadaoBackend.dto.*;

import java.io.Serializable;

public class RegisterModel implements Serializable{
	
	private static final long serialVersionUID = -5070567253196191234L;
	private User user;
	private Address address;
	
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
}
