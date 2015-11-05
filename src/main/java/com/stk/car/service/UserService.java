package com.stk.car.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stk.car.model.UserEntity;
import com.stk.car.repository.UserRepository;

/**
* Service of the user
* 
* @author Yessica GC
*
*/
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	/**
	 * 
	 * 
	 * @return
	 */
	public List<UserEntity> getAllUsers(){
		List<UserEntity> userEntities = userRepository.findAllUsers();
		System.out.println("[SERV] Found all users");
		
		return userEntities;
	}
	
	/**
	 * 
	 * 
	 * @param userEntity
	 */
	public void createUser(UserEntity userEntity){
		System.out.println("[SERV] Inserting user");
		
		userEntity.setEnable(true);
		userRepository.createUser(userEntity);
		
	}
	
	public UserEntity getUserByUsername(String username){
		UserEntity userEntities = userRepository.findUserByUsername(username);
		System.out.println("[SERV] Found User: " + username);
		
		return userEntities;
	}

}
