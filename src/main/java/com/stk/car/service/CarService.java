package com.stk.car.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stk.car.model.CarDataEntity;
import com.stk.car.repository.CarRepository;

/**
 * Service of the car information
 * 
 * @author Yessica GC
 *
 */
@Service
public class CarService {
	
	@Autowired
	private CarRepository carRepository;
	
	/**
	 * Creating the new car {@link CarDataEntity}
	 * 
	 * @param carDataEntity
	 */
	public void createCar(CarDataEntity carDataEntity){
		System.out.println("[SERV] Inserting car");
		
		carRepository.createCar(carDataEntity);
		
	}
}
