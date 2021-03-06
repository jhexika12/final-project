package com.stk.car.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stk.car.model.UserDataEntity;

/**
 * Repository of customer data 
 * 
 * @author Yessica GC
 *
 */
@Repository
@Transactional
public class UserDataRepository {
	
	@PersistenceContext(name= "car-company")
	private EntityManager entityManager;
	
	
	/**
	 * persistence of customer data {@link UserDataEntity}
	 * 
	 * @param userDataEntity
	 */
	public void createCustomer(UserDataEntity userDataEntity){
		entityManager.persist(userDataEntity);
		System.out.println("[REPO] Creating new customer");
	}

}
