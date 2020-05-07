package com.cg.greatOutdoors.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductExceptionController {
	
	
	@ExceptionHandler(value=ProductException.class)
	
	public ResponseEntity<Object> handleException(ProductException exception){
		
		return new ResponseEntity(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
	 

}
