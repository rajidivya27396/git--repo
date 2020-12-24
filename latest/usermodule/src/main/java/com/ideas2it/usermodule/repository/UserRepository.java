package com.ideas2it.usermodule.repository;

import com.ideas2it.usermodule.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    public User findByUsername(String username);
    //public List<User> findByRoles(String role);
}
