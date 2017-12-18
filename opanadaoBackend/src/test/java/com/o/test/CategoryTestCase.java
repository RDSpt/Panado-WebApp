package com.o.test;

import com.o.opanadaoBackend.dao.CategoryDAO;
import com.o.opanadaoBackend.dto.Category;
import org.junit.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertEquals;

public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.o.opanadaoBackend");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}
	
	@Test
	public void testAddCategory() {
		category = new Category();
		category.setName("Hamburger");
		category.setDescription("American sandwich");
		assertEquals("Sucessfully added to Database", true, categoryDAO.add(category));
	}
	
	@Test
	public void testGetCategory() {
		category = categoryDAO.get(1);
		assertEquals("Succesfully fetched a Single Product from DB", "Kebab", category.getName());
	}
	
	@Test
	public void testUpdateCategory() {
		category = categoryDAO.get(1);
		category.setDescription("Turkish sandwich");
		assertEquals("Succesfully updated a Single Product from DB", true, categoryDAO.update(category));
	}
	
	@Test
	public void testDeleteCategory() {
		category = categoryDAO.get(1);
		assertEquals("Succesfully updated a Single Product from DB", true, categoryDAO.delete(category));
	}
	
	@Test
	public void testListCategory() {
		assertEquals("Succesfully fetched a Products from DB", 1, categoryDAO.list().size());
	}
}
