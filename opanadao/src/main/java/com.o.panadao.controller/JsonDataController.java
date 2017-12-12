
package com.o.panadao.controller;

import com.o.opanadaoBackend.dao.ProductDAO;
import com.o.opanadaoBackend.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping("/produtos/")
	@ResponseBody
	public List<Product> getAllProducts() {
		
		return productDAO.listActiveProducts();
	}
	
	@RequestMapping("/admin/produtos/")
	@ResponseBody
	public List<Product> getAllProductsForAdmin() {
		
		return productDAO.list();
	}
	
	@RequestMapping("/produtos/{id}/")
	@ResponseBody
	public List<Product> getAllProductsByCategory(@PathVariable("id") int id) {
		
		return productDAO.listActiveProductsByCategory(id);
	}
	
}
