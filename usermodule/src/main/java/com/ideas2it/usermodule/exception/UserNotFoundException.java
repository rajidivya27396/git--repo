package com.ideas2it.usermodule.exception;
/**
 * UserNotFound exception implemented
 * 
 */
public class UserNotFoundException extends Exception {

    private static final String DEFAULT_MESSAGE = "Specified user is not found";
	private static final long serialVersionUID = -1895821339144249349L;
	public UserNotFoundException() {
		super(DEFAULT_MESSAGE);
	}
	public UserNotFoundException(long id) {
		super(String.format("User id: %s is not found",id));
	}
    
}
