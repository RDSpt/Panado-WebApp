package com.o.panadao.controller;

import com.o.opanadaoBackend.dao.*;
import com.o.opanadaoBackend.dto.*;
import com.o.panadao.util.FileUploadUtility;
import com.o.panadao.validator.ProductValidator;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/gerir")
public class ManagementController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private ProductDAO productDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);
	
	/*Adicionar Produtos*/
	@RequestMapping(value = "/adicionarProdutos", method = RequestMethod.GET)
	public ModelAndView addProducts(@RequestParam(name = "operation", required = false) String operation) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Adicionar Produtos");
		mv.addObject("adicionarProduto", true);
		Product nProduct = new Product();
		nProduct.setActive(true);
		mv.addObject("product", nProduct);
		if (operation != null) {
			if (operation.equals("product")) {
				mv.addObject("message", "Produto submetido com sucesso!");
			}
		}
		return mv;
	}
	
	@RequestMapping(value = "/adicionarProdutos", method = RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct, BindingResult results,
	                                      Model model, HttpServletRequest request) {
		if (mProduct.getId() == 0) {
			new ProductValidator().validate(mProduct, results);
		}
		else {
			if (!mProduct.getFile().getOriginalFilename().equals("")) {
				new ProductValidator().validate(mProduct, results);
			}
		}
		//Check for errors
		if (results.hasErrors()) {
			model.addAttribute("title", "Adicionar Produtos");
			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("messageFail", "Submissão não concluida: Foram encontrados erros no formulario.");
			return "page";
		}
		logger.info(mProduct.toString());
		//Add product to DB
		if (mProduct.getId() == 0) {
			productDAO.add(mProduct);
		}
		else {
			productDAO.update(mProduct);
			model.addAttribute("message", mProduct.getName() + " actualizado com sucesso.");
			return "redirect:/gerir/produtos";
		}
		if (!mProduct.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFile(request, mProduct.getFile(), mProduct.getCode());
		}
		//Redirect to Same Page
		return "redirect:/gerir/adicionarProdutos?operation=product";
	}
	
	//Gestão de Produtos
	@RequestMapping(value = "/produtos")
	public ModelAndView showManageProducts(@RequestParam(name = "message", required = false) String message) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Gerir Produtos");
		mv.addObject("gerir", true);
		mv.addObject("message", message);
		return mv;
	}
	
	@RequestMapping(value = "/produtos/{id}/activar", method = RequestMethod.POST)
	@ResponseBody
	public String handlerProductActivation(@PathVariable(value = "id") int id) {
		//fetch current product
		Product product  = productDAO.get(id);
		boolean isActive = product.isActive();
		//Change status
		product.setActive(!isActive);
		productDAO.update(product);
		return (isActive) ? "\"" + product.getName() + "\" desactivo." : "\"" + product.getName() + "\" activo.";
	}
	
	@RequestMapping(value = "/adicionarProdutos/{id}", method = RequestMethod.GET)
	public ModelAndView showEditProducts(@PathVariable(value = "id") int id) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageProducts", true);
		mv.addObject("adicionarProduto", true);
		Product nProduct = productDAO.get(id);
		mv.addObject("title", "Actualizar \"" + nProduct.getName() + "\"");
		mv.addObject("product", nProduct);
		return mv;
	}
	
	@ModelAttribute("categories")
	public List<Category> getCategories() {
		return categoryDAO.list();
	}
	
	/*NEW CATEGORY*/
	
	@RequestMapping(value = "/adicionarCategorias", method = RequestMethod.GET)
	public ModelAndView addCategory(@RequestParam(name = "operation", required = false) String operation) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Adicionar Categoria");
		mv.addObject("adicionarCategoria", true);
		Product nProduct = new Product();
		nProduct.setActive(true);
		mv.addObject("product", nProduct);
		if (operation != null) {
			if (operation.equals("category")) {
				mv.addObject("message", "Categoria submetida com sucesso!");
			}
		}
		return mv;
	}
	
	@ModelAttribute("category")
	public Category getCategory() {
		return new Category();
	}
	
	@RequestMapping(value = "/categoria", method = RequestMethod.POST)
	public String handleCategorySubmission(@ModelAttribute Category category) {
		//Add new Category
		categoryDAO.add(category);
		return "redirect:/gerir/adicionarCategorias?operation=category";
	}
}
