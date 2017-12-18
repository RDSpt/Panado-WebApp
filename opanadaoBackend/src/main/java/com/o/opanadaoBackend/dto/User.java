package com.o.opanadaoBackend.dto;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

@Entity
@Table(name = "USER")
public class User implements Serializable {
	
	private static final long serialVersionUID = 4442663856943681758L;
	
	// ===== FIELDS ===== //
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "Por favor, preencha o seu primeiro nome")
	private String first_name;
	
	@NotBlank(message = "Por favor, preencha o seu Apelido")
	private String last_name;
	
	private String role = "CUSTOMER";
	
	private boolean enabled = true;
	
	@NotBlank(message = "Por favor, insira o seu E-mail")
	private String email;
	
	@NotBlank(message = "Por favor, insira a sua Password")
	private String password;
	
	@NotBlank(message = "Por favor, indique o seu contacto telefónico")
	private String contact_number;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private Cart cart;
	// ===== ===== ===== //
	@Transient
	private String confirmPassword;
	
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", first_name='" + first_name + '\'' +
				", last_name='" + last_name + '\'' +
				", role='" + role + '\'' +
				", enabled=" + enabled +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				", contact_number='" + contact_number + '\'' +
				'}';
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFirst_name() {
		return first_name;
	}
	
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	
	public String getLast_name() {
		return last_name;
	}
	
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getContact_number() {
		return contact_number;
	}
	
	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}
	
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
}

