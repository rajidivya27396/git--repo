package com.ideas2it.usermodule.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ideas2it.usermodule.dto.UserDto;
import com.ideas2it.usermodule.entity.User;
import com.ideas2it.usermodule.exception.UserNotFoundException;
import com.ideas2it.usermodule.jwt.JwtFunctions;
import com.ideas2it.usermodule.serviceimpl.UserServiceImpl;

/**
 * Implementing controller for usermodule
 *
 * @author Rajalakshmi
 */
@RestController
@RequestMapping("users")
public class UserModuleController
{
    private UserServiceImpl service;
      
    @Autowired
    public UserModuleController(UserServiceImpl service) {
        this.service=service;
    }
    
    @PostMapping("/register")
    public UserDto registerUser(@RequestBody UserDto userdto) {
        return UserDto.entityToDto(UserDto.dtoToEntity(service.saveUser(userdto)));
    }
    
    @PutMapping("/update")
    public UserDto updateUser(@RequestBody UserDto userdto) {
        return UserDto.entityToDto(UserDto.dtoToEntity(service.saveUser(userdto)));
    }
    
    @GetMapping("/showpage")
    public Page<User> showPage(@RequestParam("page") Optional<Integer> pageno) {
    	return service.getPager(pageno);
    }
    
    @GetMapping("/showall")
    public List<UserDto> showUsers(@RequestParam(name="count",required=false) int count) {
    	return service.getUsers(count);
    }
    
    @GetMapping("/name/{username}")
    public UserDto searchByName(@PathVariable("username") String username) {
        return service.getUserByName(username);
    }
    
    @GetMapping("/role")
    public List<UserDto> searchByRole(@RequestParam("roleId") String role) {
        return service.getUsersByRole(role);
    }
    
    @DeleteMapping("/remove/{id}")
    public void removeUsers(@PathVariable Optional<Long> id) throws UserNotFoundException {
    	service.deleteUser(id);
     
    }
}
