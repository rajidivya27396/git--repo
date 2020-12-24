package com.ideas2it.usermodule.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Role")
public class Role extends AuditClass implements Serializable {

	private static final long serialVersionUID = 8708522863320625509L;
	@Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name="role_id")
    private long id;
    @Column(name="role_name", unique = true)
    private String name;
    @ManyToMany(cascade =CascadeType.ALL,mappedBy="roles")
    List<User> users;

}
