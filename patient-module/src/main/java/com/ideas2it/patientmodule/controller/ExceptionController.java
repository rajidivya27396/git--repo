package com.ideas2it.patientmodule.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ideas2it.patientmodule.exception.PatientNotFoundException;
/**
 * Implementing globalException Controller
 *
 * @author Rajalakshmi
 */
@ControllerAdvice
public class ExceptionController {
	@ExceptionHandler(value=PatientNotFoundException.class)
	public ResponseEntity<Object> exception(PatientNotFoundException exception) {
		return new ResponseEntity<>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
  }

