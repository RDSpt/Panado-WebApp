package com.o.panadao.handler;

import com.o.opanadaoBackend.dao.UserDAO;
import com.o.opanadaoBackend.dto.*;
import com.o.panadao.model.RegisterModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class RegisterHandler {
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public RegisterModel init() {
		return new RegisterModel();
	}
	
	public void addUser(RegisterModel registerModel, User user) {
		registerModel.setUser(user);
	}
	public void addAddress(RegisterModel registerModel, Address address) {
		registerModel.setAddress(address);
	}
	public String saveAll(RegisterModel registerModel) {
		String transitionValue = "success";
		//fetch user
		User user = registerModel.getUser();
		if (user.getRole().equals("CUSTOMER")) {
			Cart cart = new Cart();
			cart.setUser(user);
			user.setCart(cart);
		}
		//encode password
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		//save user
		userDAO.addUser(user);
		//get the address
		Address address = registerModel.getAddress();
		address.setUser(user);
		address.setBilling(true);
		//save address
		userDAO.addAddress(address);
		return transitionValue;
	}
	
	public String validateUser(User user, MessageContext error) {
		String transitionValue = "success";
		if (!(user.getPassword().equals(user.getConfirmPassword()))) {
			transitionValue = "failure";
			error.addMessage(new MessageBuilder()
					                 .error()
					                 .source("confirmPassword")
					                 .defaultText("Passwords não correspondem")
					                 .build());
		}
		//check uniqueness of email
		if (userDAO.getByEmail(user.getEmail()) != null) {
			transitionValue = "failure";
			error.addMessage(new MessageBuilder()
					                 .error()
					                 .source("email")
					                 .defaultText("Email já registado")
					                 .build());
		}
		return transitionValue;
	}
}
