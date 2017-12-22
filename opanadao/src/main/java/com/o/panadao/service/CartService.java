package com.o.panadao.service;

import com.o.opanadaoBackend.dao.*;
import com.o.opanadaoBackend.dto.*;
import com.o.panadao.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service("cartService")
public class CartService {
	
	@Autowired
	private CartLineDAO cartLineDAO;
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private HttpSession httpSession;
	
	//returns cart of the logged in user
	private Cart getCart() {
		return ((UserModel) httpSession.getAttribute("userModel")).getCart();
	}
	
	//returns the cartLines
	public List getCartLines() {
		return cartLineDAO.list(this.getCart().getId());
	}
	
	public String updateCartLine(int cartLineId, int count) {
		CartLine cartLine = cartLineDAO.get(cartLineId);
		double oldTotal = cartLine.getTotal();
		Product product = cartLine.getProduct();
		// check if that much quantity is available or not
		if (product.getQuantity() < count) {
			return "result=unavailable";
		}
		// update the cart line
		cartLine.setProductCount(count);
		cartLine.setBuyingPrice(product.getPrice());
		cartLine.setTotal(product.getPrice() * count);
		cartLineDAO.update(cartLine);
		// update the cart
		Cart cart = this.getCart();
		cart.setTotal(cart.getTotal() - oldTotal + cartLine.getTotal());
		cartLineDAO.updateCart(cart);
		return "result=updated";
	}
	public String deleteCartLine(int cartLineId) {
		CartLine cartLine = cartLineDAO.get(cartLineId);
		if(cartLine == null){
			return "result=error";
		}else{
			//Update cart
			Cart cart = this.getCart();
			cart.setTotal(cart.getTotal()-cartLine.getTotal());
			cart.setCartLine(cart.getCartLine()-1);
			cartLineDAO.updateCart(cart);
			//remove cartLine
			cartLineDAO.delete(cartLine);
			return "result=deleted";
		}
	}
	public String addCartLine(int productId) {
		String response = null;
		
		Cart cart = this.getCart();
		
		CartLine cartLine = cartLineDAO.getByCartAndProduct(cart.getId(), productId);
		if(cartLine == null){
			//add new cartLine
			cartLine = new CartLine();
			//fetch product
			Product product = productDAO.get(productId);
			cartLine.setCartId(cart.getId());
			cartLine.setProduct(product);
			cartLine.setBuyingPrice(product.getPrice());
			cartLine.setProductCount(1);
			cartLine.setTotal(product.getPrice());
			cartLine.setAvailable(true);
			
			cartLineDAO.add(cartLine);
			cart.setCartLine(cart.getCartLine()+1);
			cart.setTotal(cart.getTotal()+cartLine.getTotal());
			cartLineDAO.updateCart(cart);
			response = "result=added";
		}else{
		
		}
		
		
		return response;
	}
}

