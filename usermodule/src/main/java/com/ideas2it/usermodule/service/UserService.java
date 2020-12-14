package com.ideas2it.usermodule.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;

import com.ideas2it.usermodule.dto.UserDto;
import com.ideas2it.usermodule.entity.User;
import com.ideas2it.usermodule.exception.UserNotFoundException;

public interface UserService {

    UserDto saveUser(UserDto user);
    List<UserDto> getUsers(int count);
    void deleteUser(Optional<Long> id) throws UserNotFoundException;
    UserDto getUserByName(String name);
    Page<User> getPager(Optional<Integer> pageno);
    List<UserDto> getUsersByRole(String role);
    UserDto updateUser(UserDto userdto);

}
