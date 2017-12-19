package com.o.panadao.controller;

import com.o.opanadaoBackend.dao.UserDAO;
import com.o.opanadaoBackend.dto.User;
import com.o.panadao.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.*;

import javax.enterprise.inject.Model;
import javax.servlet.http.HttpSession;

@ControllerAdvice
public class GlobalController {
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private UserDAO userDAO;
	
	private UserModel userModel;
	
	@ModelAttribute("userModel")
	public UserModel getUserModel() {
		if (session.getAttribute("userModel") == null) {
			//add the user model
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			User           user           = userDAO.getByEmail(authentication.getName());
			if (user != null) {
				//create new user model
				userModel = new UserModel();
				userModel.setId(user.getId());
				userModel.setEmail(user.getEmail());
				userModel.setRole(user.getRole());
				userModel.setFullName(user.getFirst_name() + " " + user.getLast_name());
				//if Customer check for cart
				if (userModel.getRole().equals("CUSTOMER")) {
					userModel.setCart(user.getCart());
				}
				session.setAttribute("userModel",
				                     userModel);
				return userModel;
			}
		}
		return (UserModel) session.getAttribute("userModel");
	}
}
