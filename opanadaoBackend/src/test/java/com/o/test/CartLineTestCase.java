package com.o.test;

import com.o.opanadaoBackend.dao.*;
import com.o.opanadaoBackend.dto.*;
import org.junit.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.w3c.dom.UserDataHandler;

import static org.junit.Assert.assertTrue;

public class CartLineTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static CartLineDAO cartLineDAO;
	private static ProductDAO productDAO;
	private static UserDAO userDAO;
	
	private Product product;
	private User user;
	private Cart cart;
	private CartLine cartLine;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.o.opanadaoBackend");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");
		userDAO = (UserDAO) context.getBean("userDAO");
		cartLineDAO = (CartLineDAO) context.getBean("cartLineDAO");
	}
	
	@Test
	public void testAddNewCartLine() {
		//1. get the user
		user = userDAO.getByEmail("teste@teste.teste");
		//2.fetch the cart
		cart = user.getCart();
		//3.get the product
		product = productDAO.get(4);
		//4.create new cartline
		cartLine = new CartLine();
		cartLine.setBuyingPrice(product.getPrice());
		cartLine.setProductCount(cartLine.getProductCount()+1);
		cartLine.setTotal(cartLine.getProductCount()*product.getPrice());
		cartLine.setAvailable(true);
		cartLine.setCartId(cart.getId());
		
		cartLine.setProduct(product);
		
		assertTrue(cartLineDAO.add(cartLine));
		
		cart.setTotal(cart.getTotal()+cartLine.getTotal());
		cart.setCartLine(cart.getCartLine()+1);
		assertTrue(cartLineDAO.updateCart(cart));
	}
	
	
	/*@Test
	public void testUpdateCart() {
		cartLine = cartLineDAO.getByEmail("junit@jun.it");
		cartLine = user.getCart();
		System.out.println("===================================");
		System.out.println(cart.toString());
		System.out.println("===================================");
		cartLine.setTotal(20);
		cartLine.setCartLine(2);
		assertTrue(cartLineDAO.updateCart(cart));
	}*/
}
