package com.o.panadao.service;

import com.o.opanadaoBackend.dao.CartLineDAO;
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
		System.out.println("Product Quantity: "+product.getQuantity()+" count: "+count);
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
}

