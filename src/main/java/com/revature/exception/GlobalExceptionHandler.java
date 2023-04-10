package com.revature.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value= {UserException.class})
	public ResponseEntity<Object> allServiceNotFoundException(UserException ex){
		ErrorResponse errorDetails = new ErrorResponse(ex.getMessage(),ex.getCause(),HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
	}

}
