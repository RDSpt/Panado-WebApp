package com.o.panadao.controller;

import com.o.panadao.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@RequestMapping("/show")
	public ModelAndView showCart(@RequestParam(name ="result", required = false) String result) {
		ModelAndView mv = new ModelAndView("page");
		
		if(result != null){
			switch (result){
				case"error":
					mv.addObject("message", "Não foi possivel actualizar");
					break;
				case "updated":
					mv.addObject("message", "Actualizado com sucesso");
					break;
			}
		}
		
		mv.addObject("title",
		             "Cart");
		mv.addObject("userClickShowCart",
		             true);
		mv.addObject("cartLines",
		             cartService.getCartLines());
		return mv;
	}
	
	@RequestMapping("/{cartLineId}/update")
	public String updateCart(@PathVariable int cartLineId, @RequestParam int count) {
		String response = cartService.updateCartLine(cartLineId,count);
		return "redirect:/cart/show?"+response;
	}
	
}
