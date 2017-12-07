package com.o.opanadaoBackend.dto;

import javax.persistence.*;

@Entity
@Table(name = "USER_DETAIL")
public class UserDetails {
	// ===== FIELDS ===== //
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String first_name;
	
	private String last_name;
	
	private String role;
	
	private boolean enabled;
	
	private String email;
	
	private String password;
	
	private String contact_number;
	
	// ===== ===== ===== //
	
	@Override
	public String toString() {
		
		return "UserDetails{" +
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
}

