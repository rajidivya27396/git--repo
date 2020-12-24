package com.ideas2it.usermodule.serviceimpl;

import com.ideas2it.usermodule.dto.UserDto;
import com.ideas2it.usermodule.entity.User;
import com.ideas2it.usermodule.exception.AuthenticationFailedException;
import com.ideas2it.usermodule.jwt.JwtFunctions;
import com.ideas2it.usermodule.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Implementing security service
 *
 * @author Rajalakshmi
 */
@Service
public class AuthenticationService implements UserDetailsService {
    private UserRepository userRepo;


    @Autowired
    public AuthenticationService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepo.findByUsername(username);
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),new ArrayList<>());
    }

	}
