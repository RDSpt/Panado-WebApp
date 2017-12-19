package com.o.panadao.controller;

import com.o.opanadaoBackend.dao.*;
import com.o.opanadaoBackend.dto.*;
import com.o.panadao.exception.ProductNotFoundException;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.*;
import java.net.Authenticator;

@Controller
public class PageController {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value = {"/", "/home", "/index"}, produces = "text/plain;charset=UTF-8")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title",
		             "Home");
		logger.info("Inside pageController index method - INFO");
		logger.debug("Inside pageController index method - DEBUG");
		mv.addObject("userClickHome",
		             true);
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
	
	@RequestMapping(value = "sobrenos", produces = "text/plain;charset=UTF-8")
	public ModelAndView sobrenos() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title",
		             "Sobre Nós");
		mv.addObject("userClickSobrenos",
		             true);
		return mv;
	}
	
	@RequestMapping(value = "contactos", produces = "text/plain;charset=UTF-8")
	public ModelAndView contactos() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title",
		             "Contactos");
		mv.addObject("userClickContactos",
		             true);
		return mv;
	}
	
	/*Products*/
	
	@RequestMapping(value = "produtos/", produces = "text/plain;charset=UTF-8")
	public ModelAndView allProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title",
		             "Produtos");
		mv.addObject("categories",
		             categoryDAO.list());
		mv.addObject("userClickAllProducts",
		             true);
		return mv;
	}
	
	@RequestMapping(value = "produtos/{id}/", produces = "text/plain;charset=UTF-8")
	public ModelAndView selectedProduct(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");
		//fetch single category
		Category category = null;
		category = categoryDAO.get(id);
		mv.addObject("title",
		             category.getName());
		mv.addObject("category",
		             category);
		mv.addObject("categories",
		             categoryDAO.list());
		mv.addObject("userClickSelectedProduct",
		             true);
		return mv;
	}
	
	@RequestMapping(value = "produtos/produto_desc/{id}/", produces = "text/plain;charset=UTF-8")
	public ModelAndView showSingleProduct(@PathVariable("id") int id) throws ProductNotFoundException {
		ModelAndView mv      = new ModelAndView("page");
		Product      product = productDAO.get(id);
		if (product == null) throw new ProductNotFoundException();
		Category categoryOfProduct = categoryDAO.get(product.getCategoryId());
		product.setViews(product.getViews() + 1);
		productDAO.update(product);
		mv.addObject("title",
		             product.getName());
		mv.addObject("product",
		             product);
		mv.addObject("productCategory",
		             categoryOfProduct);
		mv.addObject("userClickShowProduct",
		             true);
		return mv;
	}
	
	/*FLOWS*/
	
	@RequestMapping(value = "register", produces = "text/plain;charset=UTF-8")
	public ModelAndView register() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title",
		             "Sobre Nós");
		mv.addObject("userClickSobrenos",
		             true);
		return mv;
	}
	
	/*LOGIN*/
	@RequestMapping(value = "/login", produces = "text/plain;charset=UTF-8")
	public ModelAndView login(@RequestParam(name = "error", required = false) String error,
	                          @RequestParam(name ="logout", required = false) String logout) {
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("title",
		             "Login");
		if (error != null) {
			mv.addObject("message",
			             "Credenciais Inválidas");
		}
		if (logout != null) {
			mv.addObject("logout",
			             "Volte Sempre!");
		}
		
		return mv;
	}
	
	/*ACCESS DENIED*/
	@RequestMapping(value = "/access-denied", produces = "text/plain;charset=UTF-8")
	public ModelAndView accessDenied() {
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("title",
		             "403 - Acesso Rejeitado");
		mv.addObject("errorTitle",
		             "Por Favor Contacte um Administrador");
		mv.addObject("errorDescription",
		             "Não está autorizado a ver esta página");
		return mv;
	}
	
	/*LOGOUNT*/
	@RequestMapping(value = "/perform-logout", produces = "text/plain;charset=UTF-8")
	public String logount(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request,
			                                          response,
			                                          auth);
		}
		return "redirect:/login?logout";
	}
}
//jdbc:h2:tcp://localhost/~/opanadao
//sa
//