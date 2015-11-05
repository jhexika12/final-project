package com.stk.car.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.stk.car.model.EngineerInfoEntity;


@Repository
@Transactional
public class EngineerInfoRepository {

	@PersistenceContext(name= "car-company")
	private EntityManager entityManager;
	
	public void createEngineer(EngineerInfoEntity engineerInfoEntity){
		entityManager.persist(engineerInfoEntity);
		System.out.println("[REPO] Adding new engineer" + engineerInfoEntity);
	}
	
	
	public EngineerInfoEntity findEngineerByName(String name){
		EngineerInfoEntity engineerInfoEntity = (EngineerInfoEntity) entityManager.createQuery("SELECT engineer from EngineerInfoEntity engineer WHERE engineer.name = :name")
				.setParameter("name", name)
				.getSingleResult();
		
		return engineerInfoEntity;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<EngineerInfoEntity> findAllEngineer(){
		List<EngineerInfoEntity> engineerInfoEntities = entityManager.createQuery("SELECT engineer FROM EngineerInfoEntity engineer")
				.getResultList();
		
		return engineerInfoEntities;
		
	}
	
	public void deleteEngineer(EngineerInfoEntity engineerInfoEntity){
		entityManager.remove(engineerInfoEntity);
		System.out.println("[REPO] Delete engineer " + engineerInfoEntity);
	}
}
