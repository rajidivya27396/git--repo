package com.ideas2it.usermodule.serviceimpl;

import java.util.List;
import java.util.Optional;

import javax.persistence.Cacheable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ideas2it.usermodule.aop.AopLogging;
import com.ideas2it.usermodule.dto.UserDto;
import com.ideas2it.usermodule.entity.User;
import com.ideas2it.usermodule.exception.UserNotFoundException;
import com.ideas2it.usermodule.repository.RoleRepository;
import com.ideas2it.usermodule.repository.UserElasticRepository;
import com.ideas2it.usermodule.repository.UserRepository;
import com.ideas2it.usermodule.service.UserService;

/**
 * User services are implemented for performing CRUD operation
 *
 * @author Rajalakshmi
 */
@Service
public class UserServiceImpl implements UserService {
	
	private static final int INITIAL_LOADING_COUNT = 100;
	private static final int SIZE = 20;
	private static final int DEFAULT_PAGE = 0;
    private UserRepository userRepo;
    private RoleRepository roleRepo;
    private UserElasticRepository elasticRepo;
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Autowired
    public UserServiceImpl(UserRepository userRepo,UserElasticRepository elasticRepo,RoleRepository roleRepo) {
        this.roleRepo = roleRepo;
        this.userRepo = userRepo;
        this.elasticRepo = elasticRepo;
    }
   
    @Override
    @AopLogging
    public UserDto saveUser(UserDto user) {
    	//elasticRepo.save(UserDto.dtoToEntity(user));
        return UserDto.entityToDto(userRepo.save(UserDto.dtoToEntity(user)));
    }
    
    @Override
    @AopLogging
    @CacheEvict("usercache")
    public void deleteUser(Optional<Long> id)throws UserNotFoundException {
        if(userRepo.findById(id.get()) == null)
          throw new UserNotFoundException(id.get());
        userRepo.deleteById(id.get());  
    }
    

    /**
     * Load users based on loading count (sorted by updated date in DESC) using entity manager
     *
     * @param count
     */
    @Override
    @AopLogging
    public List<UserDto> getUsers(int count) {
    	int loadingFactor = (count==0)? INITIAL_LOADING_COUNT:count;
    	return UserDto.entityToDto(entityManager.createQuery("SELECT p FROM User p ORDER BY p.updatedDate DESC"
    			,User.class).setMaxResults(loadingFactor).getResultList());
        
    }

	@Override
	public UserDto getUserByName(String name) {
		return UserDto.entityToDto(userRepo.findByUsername(name));
	}
	
	@Override
	public Page<User> getPager(Optional<Integer> pageno) {
		int page=pageno.get()<1 ? DEFAULT_PAGE: pageno.get()-1;
	    return userRepo.findAll(PageRequest.of(page,SIZE));
	}
	
	@Override
	public List<UserDto> getUsersByRole(String role) {
        return UserDto.entityToDto(elasticRepo.findByRoles(role));
	}
	
	@Override
	@AopLogging
	@CachePut("usercache")
	public UserDto updateUser(UserDto user) {
		return UserDto.entityToDto(userRepo.save(UserDto.dtoToEntity(user)));
	}
}
