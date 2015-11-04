package com.stk.car.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import com.stk.car.model.UserEntity;

@Repository
public class UserRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	
	public void createUser(UserEntity userEntity){
		entityManager.persist(userEntity);
			System.out.println("[REPO] Cre");
	}
	
	
	public UserEntity findUserByUsername(String username){
		UserEntity userEntity = (UserEntity) entityManager.createQuery("SELECT user from UserEntity user WHERE user.username = :username")
				.setParameter("username", username)
				.getSingleResult();
		
		return userEntity;
	}
	
	@SuppressWarnings("unchecked")
	public List<UserEntity> findAllUsers(){
		List<UserEntity> userEntities = entityManager.createQuery("SELECT user FROM UserEntity user")
				.getResultList();
		System.out.println("[REPO] Found all users");
		
		return userEntities;
		
	}
	
}
