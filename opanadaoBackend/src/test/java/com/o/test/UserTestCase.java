package com.o.test;

import com.o.opanadaoBackend.dao.*;
import com.o.opanadaoBackend.dto.*;
import org.junit.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class UserTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static UserDetailsDAO userDetailsDAO;
	
	private User user;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.o.opanadaoBackend");
		context.refresh();
		userDetailsDAO = (UserDetailsDAO) context.getBean("userDetailsDAO");
		
	}
	
	@Test
	public void testAddCategory() {
		
		user = new User();
		user.setFirst_name("Customer3");
		user.setLast_name("Customer3");
		user.setContact_number("11111111");
		user.setEmail("customer3@customer3.com");
		user.setRole("CUSTOMER");
		user.setPassword("Customer3");
		assertEquals("Sucessfully added to Database", true, userDetailsDAO.add(user));
	}
	
	@Test
	public void testAddAdminUser(){
		user = new User();
		user.setFirst_name("Admin");
		user.setLast_name("Admin");
		user.setContact_number("11111111");
		user.setEmail("Admin@Admin.com");
		user.setRole("ADMIN");
		user.setPassword("Admin");
		assertEquals("Sucessfully added to Database", true, userDetailsDAO.add(user));
	}
	
	@Test
	public void testGetCategory() {
		
		user = userDetailsDAO.get(4);
		assertEquals("Succesfully fetched a Single Product from DB", "Customer3", user.getFirst_name());
		
	}
	
	@Test
	public void testUpdateCategory() {
		
		user = userDetailsDAO.get(4);
		user.setContact_number("111111110");
		assertEquals("Succesfully updated a Single Product from DB", true, userDetailsDAO.update(user));
		
	}
	
	@Test
	public void testDeleteCategory() {
		
		user = userDetailsDAO.get(4);
		assertEquals("Succesfully updated a Single Product from DB", true, userDetailsDAO.delete(user));
		
	}
	
	@Test
	public void testListCategory() {
		List<User> a = userDetailsDAO.selectActiveList();
		a.forEach(user -> System.out.println(user.getFirst_name()));
		assertEquals("Succesfully fetched a Products from DB", 3, userDetailsDAO.selectActiveList().size());
	}
	
}
