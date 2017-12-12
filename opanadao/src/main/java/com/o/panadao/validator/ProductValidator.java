package com.o.panadao.validator;

import com.o.opanadaoBackend.dto.Product;
import org.springframework.validation.*;

public class ProductValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Product.class.equals(clazz);
	}
	@Override
	public void validate(Object target, Errors errors) {
		Product product = (Product) target;
		//file has been selected?
		if (product.getFile() == null || product.getFile().getOriginalFilename().equals("")) {
			errors.rejectValue("file", null, "Por favor selecione uma imagem para submeter!");
			return;
		}
		if (!(product.getFile().getContentType().equals("image/jpeg") ||
				product.getFile().getContentType().equals("image/png") ||
				product.getFile().getContentType().equals("image/gif"))) {
			errors.rejectValue("file", null, "Por favor selecione apenas ficheiros de imagem para submeter!");
			return;
		}
		
	}
}
