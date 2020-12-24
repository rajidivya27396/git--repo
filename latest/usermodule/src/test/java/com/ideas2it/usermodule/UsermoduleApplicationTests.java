package com.ideas2it.usermodule;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ideas2it.usermodule.entity.Role;
import com.ideas2it.usermodule.entity.User;
import com.ideas2it.usermodule.repository.UserRepository;
import com.ideas2it.usermodule.serviceimpl.UserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsermoduleApplicationTests {

	@Autowired
	private UserServiceImpl service;
	@MockBean
	private UserRepository userRepo;
	
	@Test
	public void saveUser() {
		Role role=new Role();
		User user=new User(1,"raji","$%&@#","rajidivya@gmail.com",List.of(role));
        when(userRepo.save(user)).thenReturn(user);
    }
 
     @Test
     public void getUserByName() {
    	String username="raji";
    	Role role=new Role();
    	User user=new User(1,"raji","$%&@#","rajidivya@gmail.com",List.of(role));
     	when(userRepo.findByUsername(username)).thenReturn(user); 
     	assertEquals(username,service.getUserByName(username).getUsername());
    }
				
     @Test
	 public void updateUser() {
        Role role=new Role();
    	User user=new User(1,"raji","$%&@#","rajidivya@gmail.com",List.of(role));
        when(userRepo.save(user)).thenReturn(user);
    }
}
