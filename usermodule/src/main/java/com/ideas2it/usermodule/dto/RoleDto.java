package com.ideas2it.usermodule.dto;

import com.ideas2it.usermodule.entity.User;
import lombok.Data;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class RoleDto {
    private long id;
    private String name;
    private List<User> users;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private String createdUser;
    private String updatedUser;
}
