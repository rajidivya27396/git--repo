package com.ideas2it.usermodule.exception;

public class AuthenticationFailedException extends Exception {

	private static final long serialVersionUID = 8342306196984719004L;
	private static final String AUTH_ERROR = "Incorrect username/password";
	public AuthenticationFailedException() {
		super(AUTH_ERROR);
	}
}
