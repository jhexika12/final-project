package com.stk.car.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stk.car.model.UserEntity;
import com.stk.car.repository.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<UserEntity> getAllUsers(){
		List<UserEntity> userEntities = userRepository.findAllUsers();
		System.out.println("[SERV] Found all users");
		return userEntities;
	}
	
	public void createUser(UserEntity userEntity){
		System.out.println("[SERV] Inserting user");
		
		userRepository.createUser(userEntity);
		
	}
	
	public UserEntity getUserByUsername(String username){
		UserEntity userEntities = userRepository.findUserByUsername(username);
		System.out.println("[SERV] Found User: " + username);
		
		return userEntities;
	}

}
