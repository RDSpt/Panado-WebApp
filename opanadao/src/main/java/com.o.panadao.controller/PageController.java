package com.o.panadao.controller;

import com.o.opanadaoBackend.dao.*;
import com.o.opanadaoBackend.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.ws.rs.Path;

@Controller
public class PageController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value = {"/", "/home", "/index"}, produces = "text/plain;charset=UTF-8")
	public ModelAndView index() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		mv.addObject("userClickHome", true);
		return mv;
	}
	
	/*@RequestMapping(value = "produtos", produces = "text/plain;charset=UTF-8")
	public ModelAndView produtos(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Produtos");
		mv.addObject("products", categoryDAO.list());
		mv.addObject("userClickProdutos", true);
		return mv;
	}*/
	
	@RequestMapping(value = "" +
			"sobrenos", produces = "text/plain;charset=UTF-8")
	public ModelAndView sobrenos() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Sobre Nós");
		mv.addObject("userClickSobrenos", true);
		return mv;
	}
	
	@RequestMapping(value = "contactos", produces = "text/plain;charset=UTF-8")
	public ModelAndView contactos() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contactos");
		mv.addObject("userClickContactos", true);
		return mv;
	}
	
	/*Products*/
	
	@RequestMapping(value = "produtos/", produces = "text/plain;charset=UTF-8")
	public ModelAndView allProducts() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Produtos");
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickAllProducts", true);
		return mv;
	}
	
	@RequestMapping(value = "produtos/{id}/", produces = "text/plain;charset=UTF-8")
	public ModelAndView selectedProduct(@PathVariable("id") int id) {
		
		ModelAndView mv = new ModelAndView("page");
		//fetch single category
		Category category = null;
		category = categoryDAO.get(id);
		mv.addObject("title", category.getName());
		mv.addObject("category", category);
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickSelectedProduct", true);
		return mv;
	}
	
	@RequestMapping(value = "produtos/produto_desc/{id}/", produces = "text/plain;charset=UTF-8")
	public ModelAndView showSingleProduct(@PathVariable("id") int id){
		
		ModelAndView mv = new ModelAndView("page");
		
		Product product = productDAO.get(id);
		Category categoryOfProduct = categoryDAO.get(product.getCategoryId());
		product.setViews(product.getViews() +1);
		productDAO.update(product);
		mv.addObject("title", product.getName());
		mv.addObject("product",product);
		mv.addObject("productCategory",categoryOfProduct);
		mv.addObject("userClickShowProduct",true);
		
		return mv;
	}
	
}

//jdbc:h2:tcp://localhost/~/opanadao
//sa
//