package com.o.panadao.exception;

import java.io.Serializable;

public class ProductNotFoundException extends Exception implements Serializable {
	
	private String message;
	
	public ProductNotFoundException() {
		this.message = "Product is not available";
	}
	
	public ProductNotFoundException(String message) {
		this.message = System.currentTimeMillis() + ": " + message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
}
