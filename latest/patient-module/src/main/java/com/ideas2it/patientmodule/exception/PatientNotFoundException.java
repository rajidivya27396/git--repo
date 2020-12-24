package com.ideas2it.patientmodule.exception;
/**
 * PatientNotFoundException class
 * 
 * @author Rajalakshmi
 */
public class PatientNotFoundException extends Exception {
	
	private static final long serialVersionUID = 209889081774419356L;
	private static final String DEFAULT_MESSAGE = "Specified patient does not exists";
	
	public PatientNotFoundException() {
		super(DEFAULT_MESSAGE);
	}
	public PatientNotFoundException(long id) {
		super(String.format("Patient id: %s is not found",id));
	}
}
