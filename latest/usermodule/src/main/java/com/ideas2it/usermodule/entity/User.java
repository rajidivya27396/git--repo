package com.ideas2it.usermodule.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name="User")
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName="userindex",type="user")
public class User extends AuditClass implements Serializable {
   
	private static final long serialVersionUID = -1740587770525734181L;
	@Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name="user_id")
    private long id;
	
    @Column(name="username")
    private String username;
    
    @Column(name="password")
    private String password;
    
    @Column(name="email")
    private String email;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="user_role",joinColumns = @JoinColumn(name="user_id"),inverseJoinColumns = @JoinColumn(name="role_id"))
    private List<Role> roles;
}
