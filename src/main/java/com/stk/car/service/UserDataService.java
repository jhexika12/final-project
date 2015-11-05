package com.stk.car.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stk.car.model.UserDataEntity;
import com.stk.car.repository.UserDataRepository;


@Service
public class UserDataService {
	
	@Autowired
	private UserDataRepository userDataRepository;
	
	public void createCustomer(UserDataEntity userDataEntity){
		System.out.println("[SERV] Inserting customer");
		
		userDataRepository.createCustomer(userDataEntity);
	}
	

}
