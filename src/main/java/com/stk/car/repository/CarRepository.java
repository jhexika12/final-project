package com.stk.car.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stk.car.model.CarDataEntity;

/**
 * Repository of car information
 * 
 * @author Yessica GC
 *
 */
@Repository
@Transactional
public class CarRepository {
	
	@PersistenceContext(name= "car-company")
	private EntityManager entityManager;
	
	
	/**
	 * Persistence of car entity {@link CarDataEntity}
	 * 
	 * @param carDataEntity
	 */
	public void createCar(CarDataEntity carDataEntity){
		entityManager.persist(carDataEntity);
		System.out.println("[REPO] Creating Car");
	}

}
