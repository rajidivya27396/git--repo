package com.ideas2it.usermodule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ideas2it.usermodule.dto.UserDto;
import com.ideas2it.usermodule.jwt.JwtFunctions;
import com.ideas2it.usermodule.serviceimpl.AuthenticationService;
import com.ideas2it.usermodule.serviceimpl.UserVerification;

@RestController
public class AuthenticationController {
	
	private UserVerification service;
	
	@Autowired
	public AuthenticationController(UserVerification service) {
		this.service = service;
	}
	
	@PostMapping("/user-authentication")
	public String authenticateUser(@RequestBody UserDto userdto)throws Exception {
	    return service.verifyUser(userdto);
	}   
}
