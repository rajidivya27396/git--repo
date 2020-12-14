package com.ideas2it.usermodule.repository;

import com.ideas2it.usermodule.entity.Role;
import com.ideas2it.usermodule.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
public List<Role> findById(long id);

}