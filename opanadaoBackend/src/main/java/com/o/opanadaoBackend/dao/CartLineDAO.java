package com.o.opanadaoBackend.dao;

import com.o.opanadaoBackend.dto.*;

import java.util.List;

public interface CartLineDAO {
	
	CartLine get(int id);
	
	boolean add(CartLine cartLine);
	
	boolean update(CartLine cartLine);
	
	boolean delete(CartLine cartLine);
	
	List list(int cartId);
	
	List listAvailable(int cartId);
	
	CartLine getByCartAndProduct(int cartId, int productId);
	
	boolean updateCart(Cart cart);
}
