package com.stk.car.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.stk.car.model.ScheduleEntity;


@Repository
@Transactional
public class ScheduleRepository {
	
	@PersistenceContext(name = "car-company")
	private EntityManager entityManager;
	
	public void createSchedule(ScheduleEntity scheduleEntity){
		entityManager.persist(scheduleEntity);
		
			System.out.println("[REPO] Create schedule");
	}
	
	public void deleteSchedule(ScheduleEntity scheduleEntity){
		entityManager.remove(scheduleEntity);
		
			System.out.println("[REPO] Create schedule");
	}
	

	@SuppressWarnings("unchecked")
	public List<ScheduleEntity> findScheduleByDate(Date date){
		List<ScheduleEntity> scheduleEntities = entityManager.createQuery("SELECT schedule from ScheduleEntity schedule  WHERE schedule.date= :date")
				.setParameter("date", date)
				.getResultList();
		
		return  scheduleEntities;
	}
	

	@SuppressWarnings("unchecked")
	public List<ScheduleEntity> findAllSchedule(){
		List<ScheduleEntity> scheduleEntities = entityManager.createQuery("SELECT schedule FROM ScheduleEntity schedule")
				.getResultList();
		System.out.println("[REPO] Found all schedules");
		
		return scheduleEntities;
		
	}

}
