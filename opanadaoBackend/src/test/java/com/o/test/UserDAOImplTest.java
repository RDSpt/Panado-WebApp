package com.o.test;

import com.o.opanadaoBackend.dao.*;
import com.o.opanadaoBackend.dto.*;
import org.junit.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.Assert.*;

public class UserDAOImplTest {
	
	private static AnnotationConfigApplicationContext context;
	
	private static UserDAO userDAO;
	
	private User user;
	private Address address;
	private Cart cart;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.o.opanadaoBackend");
		context.refresh();
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	
	@Test
	public void createAdmin(){
		user = new User();
		user.setFirst_name("admin");
		user.setLast_name("admin");
		user.setEmail("admin@admin.admin");
		user.setContact_number("000000000");
		user.setRole("ADMIN");
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		user.setPassword(passwordEncoder.encode("admin"));
		assertTrue(userDAO.addUser(user));
	}
	
	@Test
	public void testAddCart() {
		//Create User
		user = new User();
		user.setFirst_name("ja");
		user.setLast_name("unit");
		user.setEmail("junita@jun.it");
		user.setContact_number("123456789");
		user.setRole("CUSTOMER");
		user.setPassword("1234");
		//Add User
		if (user.getRole().equals("CUSTOMER")) {
			//Create Cart
			cart = new Cart();
			cart.setUser(user);
			//Add Cart
			user.setCart(cart);
		}
		assertTrue(userDAO.addUser(user));
	}
	
	@Test
	public void testUpdateCart() {
		user = userDAO.getByEmail("junit@jun.it");
		cart = user.getCart();
		System.out.println("===================================");
		System.out.println(cart.toString());
		System.out.println("===================================");
		cart.setTotal(20);
		cart.setCartLine(2);
		assertTrue(userDAO.updateCart(cart));
	}
	
	@Test
	public void testAddAddress() {
		//ADD User
		//Create User
		user = new User();
		user.setFirst_name("j");
		user.setLast_name("unit");
		user.setEmail("junit@jun.it");
		user.setContact_number("123456789");
		user.setRole("CUSTOMER");
		user.setPassword("1234");
		//Add User
		assertTrue(userDAO.addUser(user));
		//Create User Address
		address = new Address();
		address.setAddressLineOne("Avenida da Liberdade");
		address.setCity("Lisboa");
		address.setPostalCode("1900");
		address.setCountry("Portugal");
		address.setBilling(true);
		address.setUser(user);
		assertTrue(userDAO.addAddress(address));
		//Add Shipping Address
		address = new Address();
		address.setAddressLineOne("Avenida da Liberdade");
		address.setCity("Lisboa");
		address.setPostalCode("1900");
		address.setCountry("Portugal");
		address.setShipping(true);
		address.setUser(user);
		assertTrue(userDAO.addAddress(address));
	}
	
	@Test
	public void testAddAddress2() {
		user = userDAO.getByEmail("junit@jun.it");
		address = new Address();
		address.setAddressLineOne("Avenida de Roma");
		address.setCity("Lisboa");
		address.setPostalCode("1900");
		address.setCountry("Portugal");
		address.setShipping(true);
		address.setUser(user);
		assertTrue(userDAO.addAddress(address));
	}
	
	@Test
	public void testGetAddresses() {
		user = userDAO.getByEmail("junit@jun.it");
		assertEquals(2,
		             userDAO.getListShippingAddresses(user).size());
		assertEquals("Lisboa",
		             userDAO.getBillingAddress(user).getCity());
	}
	
	@Test
	public void testAddComplete() {
		//Create New User
		user = new User();
		user.setFirst_name("Teste");
		user.setLast_name("Completo");
		user.setEmail("tc@teste.com");
		user.setContact_number("000000000");
		user.setPassword("1234");
		// CREATE CART
		cart = new Cart();
		cart.setCartLine(0);
		cart.setTotal(0);
		cart.setUser(user);
		user.setCart(cart);
		//ADD USER AND CART
		assertTrue(userDAO.addUser(user));
		// CREATE ADDRESS
		address = new Address();
		address.setAddressLineOne("Avenida da Liberdade");
		address.setShipping(true);
		address.setPostalCode("1900");
		address.setCity("Lisboa");
		address.setCountry("Portugal");
		address.setUser(user);
		assertTrue(userDAO.addAddress(address));
	}
}