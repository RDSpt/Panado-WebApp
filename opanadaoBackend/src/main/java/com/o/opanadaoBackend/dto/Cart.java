package com.o.opanadaoBackend.dto;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Cart implements Serializable {
	
	private static final long serialVersionUID = -6961159931589148824L;
	
	/*PRIVATE FIELDS*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	private User user;
	
	private double total;
	
	@Column(name = "cart_line")
	private int cartLine;
	
	/*GETTER AND SETTER*/
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getCartLine() {
		return cartLine;
	}
	public void setCartLine(int cartLine) {
		this.cartLine = cartLine;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return "Cart{" +
				"id=" + id +
				"user=" + user.getId() +
				", total=" + total +
				", cartLine=" + cartLine +
				'}';
	}
}
