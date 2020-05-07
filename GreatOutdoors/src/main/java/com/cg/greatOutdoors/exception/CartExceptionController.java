package com.cg.greatOutdoors.exception;

import javax.xml.bind.DataBindingException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CartExceptionController {
	
@ExceptionHandler(value=ProductException.class)
	
	public ResponseEntity<Object> handleException(DeleteIdException exception){
		
		return new ResponseEntity(exception.getMessage(),HttpStatus.NOT_FOUND);
	}

}
