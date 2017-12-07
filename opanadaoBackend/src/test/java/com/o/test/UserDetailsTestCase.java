package com.o.test;

import com.o.opanadaoBackend.dao.*;
import com.o.opanadaoBackend.dto.*;
import org.junit.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class UserDetailsTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static UserDetailsDAO userDetailsDAO;
	
	private UserDetails userDetails;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.o.opanadaoBackend");
		context.refresh();
		userDetailsDAO = (UserDetailsDAO) context.getBean("userDetailsDAO");
		
	}
	
	@Test
	public void testAddCategory() {
		
		userDetails = new UserDetails();
		userDetails.setFirst_name("Customer3");
		userDetails.setLast_name("Customer3");
		userDetails.setContact_number("11111111");
		userDetails.setEmail("customer3@customer3.com");
		userDetails.setRole("CUSTOMER");
		userDetails.setPassword("Customer3");
		assertEquals("Sucessfully added to Database", true, userDetailsDAO.add(userDetails));
	}
	
	@Test
	public void testGetCategory() {
		
		userDetails = userDetailsDAO.get(4);
		assertEquals("Succesfully fetched a Single Product from DB", "Customer3", userDetails.getFirst_name());
		
	}
	
	@Test
	public void testUpdateCategory() {
		
		userDetails = userDetailsDAO.get(4);
		userDetails.setContact_number("111111110");
		assertEquals("Succesfully updated a Single Product from DB", true, userDetailsDAO.update(userDetails));
		
	}
	
	@Test
	public void testDeleteCategory() {
		
		userDetails = userDetailsDAO.get(4);
		assertEquals("Succesfully updated a Single Product from DB", true, userDetailsDAO.delete(userDetails));
		
	}
	
	@Test
	public void testListCategory() {
		List<UserDetails> a = userDetailsDAO.selectActiveList();
		a.forEach(user -> System.out.println(user.getFirst_name()));
		assertEquals("Succesfully fetched a Products from DB", 3, userDetailsDAO.selectActiveList().size());
	}
	
}
