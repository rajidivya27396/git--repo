package com.ideas2it.usermodule.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.ideas2it.usermodule.entity.Role;
import com.ideas2it.usermodule.entity.User;

import lombok.Data;

@Data
public class UserDto implements Serializable {

    private static final long serialVersionUID = 4025749602171865264L;
	private long id;
    private String username;
    private String password;
    private String email;
    private List<Role> roles;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private String createdUser;
    private String updatedUser;
    public static User dtoToEntity(UserDto dto) {
		    User entity=new User();
		    entity.setId(dto.getId());
	        entity.setUsername(dto.getUsername());
	        entity.setPassword(dto.getPassword());
	        entity.setEmail(dto.getEmail());
	        entity.setRoles(dto.getRoles());
	        entity.setCreatedDate(dto.getCreatedDate());
	        entity.setCreatedUser(dto.getCreatedUser());
	        entity.setUpdatedDate(dto.getUpdatedDate());
	        entity.setUpdatedUser(dto.getUpdatedUser());
	        return entity;
	  }
	  public static UserDto entityToDto(User entity) {
		    UserDto dto=new UserDto();
		    dto.setId(entity.getId());
	        dto.setUsername(entity.getUsername());
	        dto.setPassword(entity.getPassword());
	        dto.setEmail(entity.getEmail());
	        dto.setRoles(entity.getRoles());
	        dto.setCreatedDate(entity.getCreatedDate());
	        dto.setCreatedUser(entity.getCreatedUser());
	        dto.setUpdatedDate(entity.getUpdatedDate());
	        dto.setUpdatedUser(entity.getUpdatedUser());
	        return dto;
      }
	  public static List<UserDto> entityToDto(List<User> entity) {
		    List<UserDto> dto=new ArrayList<>();
		    for(int i=0;i<entity.size();i++)
		      dto.add(UserDto.entityToDto(entity.get(i)));
		    return dto;
	  }
}	  
	 

