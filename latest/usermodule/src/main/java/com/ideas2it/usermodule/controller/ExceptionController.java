package com.ideas2it.usermodule.controller;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ideas2it.usermodule.exception.AuthenticationFailedException;
import com.ideas2it.usermodule.exception.UserNotFoundException;
/**
 * Implementing globalException Controller
 *
 * @author Rajalakshmi
 */
@ControllerAdvice
public class ExceptionController {
 
	@ExceptionHandler(value=UserNotFoundException.class)
	public ResponseEntity<Object> exception(UserNotFoundException exception) {
		return new ResponseEntity<>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=AuthenticationFailedException.class)
	public ResponseEntity<Object> exception(AuthenticationFailedException exception) {
		return new ResponseEntity<>(exception.getMessage(),HttpStatus.FORBIDDEN);
	}
}
