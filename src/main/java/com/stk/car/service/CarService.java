package com.stk.car.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stk.car.model.CarDataEntity;
import com.stk.car.repository.CarRepository;

@Service
public class CarService {
	
	@Autowired
	private CarRepository carRepository;
	
	public void createCar(CarDataEntity carDataEntity){
		System.out.println("[SERV] Inserting car");
		
		carRepository.createCar(carDataEntity);
		
	}
}
