package com.stk.car.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stk.car.model.EngineerInfoEntity;
import com.stk.car.repository.EngineerInfoRepository;



@Service
public class EngineerInfoService {

	@Autowired
	private EngineerInfoRepository engineerInfoRepository;
	
	
	public List<EngineerInfoEntity> getAllEngineer(){
		List<EngineerInfoEntity> engineerInfoEntities = engineerInfoRepository.findAllEngineer();
		System.out.println("[SERV] Get all engineers");
		
		return engineerInfoEntities;
	}
	
	public void createEngineer(EngineerInfoEntity engineerInfoEntity){
		System.out.println("[SERV] Creating engineer");
		
		engineerInfoRepository.createEngineer(engineerInfoEntity);
	}
	
	public EngineerInfoEntity getEngineerByName(String name){
		EngineerInfoEntity engineerInfoEntity = engineerInfoRepository.findEngineerByName(name);
		System.out.println("[SERV] Get engineer by name");
		
		return engineerInfoEntity;
	}
	
	public boolean deleteEngineerByName(String name){
		
		EngineerInfoEntity engineerInfoEntity = engineerInfoRepository.findEngineerByName(name);
		
		if(engineerInfoEntity == null)
			return false;
		
		engineerInfoRepository.deleteEngineer(engineerInfoEntity);
		System.out.println("[SERV] Deleted engineer: " );
		
		return true;
	}
}
