package com.o.opanadaoBackend.dto;

import org.springframework.stereotype.Controller;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
public class Address implements Serializable {
	
	private static final long serialVersionUID = -4014375846116604042L;
	/*PRIVATE FIELDS*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private User user;
	
	@Column(name = "address_line_one")
	@NotBlank(message = "Indique a sua rua")
	private String addressLineOne;
	
	@NotBlank(message = "Indique a sua cidade")
	private String city;
	
	@NotBlank(message = "Indique o seu País")
	private String country;
	
	@Column(name = "postal_code")
	@NotBlank(message = "Indique o seu Código de Postal")
	private String postalCode;
	
	private boolean shipping;
	
	private boolean billing;
	
	/*METHODS*/
	
	@Override
	public String toString() {
		return "Address{" +
				"id=" + id +
				", user=" + user +
				", addressLineOne='" + addressLineOne + '\'' +
				", city='" + city + '\'' +
				", country='" + country + '\'' +
				", postalCode='" + postalCode + '\'' +
				", shipping=" + shipping +
				", billing=" + billing +
				'}';
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getAddressLineOne() {
		return addressLineOne;
	}
	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public boolean isShipping() {
		return shipping;
	}
	public void setShipping(boolean shipping) {
		this.shipping = shipping;
	}
	public boolean isBilling() {
		return billing;
	}
	public void setBilling(boolean billing) {
		this.billing = billing;
	}
}
