package com.o.opanadaoBackend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.UUID;

@Entity
public class Product {
	
	// ===== FIELDS ===== //
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String code;
	
	@NotBlank(message = "Por favor insira o nome do Produto!")
	private String name;
	
	@JsonIgnore
	@NotBlank(message = "Por favor insira a descrição do Produto!")
	private String description;
	
	@Min(value = 1, message = "A quantidade não pode ser inferior a 1")
	private int quantity;
	
	@Column(name = "unit_price")
	@Min(value = 1,  message = "O preço não pode ser inferior a 1")
	private double price;
	@JsonIgnore
	@Column(name = "is_active")
	private boolean active;
	@JsonIgnore
	@Column(name = "category_id")
	private int categoryId;
	
	private int purchases;
	
	private int views;
	// ===== ===== ===== //
	
	public Product() {
		this.code = "PRD" + UUID.randomUUID().toString().substring(26).toUpperCase();
	}
	// ===== ===== ===== //
	
	@Override
	public String toString() {
		return "Product{" +
				"id=" + id +
				", code='" + code + '\'' +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", quantity=" + quantity +
				", price=" + price +
				", active=" + active +
				", categoryId=" + categoryId +
				", purchases=" + purchases +
				", views=" + views +
				'}';
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public boolean isActive() {
		return active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public int getCategoryId() {
		return categoryId;
	}
	
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	public int getPurchases() {
		return purchases;
	}
	
	public void setPurchases(int purchases) {
		this.purchases = purchases;
	}
	
	public int getViews() {
		return views;
	}
	
	public void setViews(int views) {
		this.views = views;
	}
}


