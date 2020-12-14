package com.ideas2it.usermodule.serviceimpl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.ideas2it.usermodule.dto.UserDto;
import com.ideas2it.usermodule.exception.AuthenticationFailedException;
import com.ideas2it.usermodule.jwt.JwtFunctions;
@Service
public class UserVerification {

	private AuthenticationManager manager;
    private JwtFunctions jwt;
    public UserVerification(AuthenticationManager manager,JwtFunctions jwt)
    {
    	this.jwt=jwt;
    	this.manager=manager;
    }
	public String verifyUser(UserDto user) throws Exception {
		try {
		     manager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		    }
		catch(Exception e) {
		     throw new AuthenticationFailedException();
		    }
		return jwt.generateToken(user.getUsername());
		    }
}
