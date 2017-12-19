package com.o.test;

import com.o.opanadaoBackend.dao.*;
import com.o.opanadaoBackend.dto.Product;
import org.junit.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

public class ProductTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static ProductDAO productDAO;
	
	private Product product;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.o.opanadaoBackend");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");
		
	}
	
	@Test
	public void testAddProduct(){
		product = new Product();
		product.setName("Panado com Kebab");
		product.setDescription("Panado com kebab");
		product.setCategoryId(2);
		product.setQuantity(30);
		product.setPrice(3);
		assertEquals("Sucessfully added to Database", true, productDAO.add(product));
	}
	
	@Test
	public void testGetCategory(){
		product = productDAO.get(2);
		assertEquals("Succesfully fetched a Single Product from DB", "Panado com Kebab", product.getName());
		
	}
	
	@Test
	public void testUpdateCategory(){
		product = productDAO.get(2);
		product.setDescription("Turkish sandwich");
		assertEquals("Succesfully updated a Single Product from DB", true, productDAO.update(product));
		
	}
	
	@Test
	public void testDeleteCategory(){
		product = productDAO.get(7);
		
		assertEquals("Succesfully updated a Single Product from DB", true ,productDAO.delete(product));
		
	}
	
	@Test
	public void testListActiveProducts(){
		assertEquals("Succesfully fetched a Products from DB", 6, productDAO.listActiveProducts().size());
	}
	
}