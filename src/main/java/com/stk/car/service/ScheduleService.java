package com.stk.car.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stk.car.model.ScheduleEntity;
import com.stk.car.repository.ScheduleRepository;


@Service
public class ScheduleService {
	
	@Autowired
	private ScheduleRepository scheduleRepository;
	
	public List<ScheduleEntity> getAllSchedule(){
		List<ScheduleEntity> scheduleEntities  = scheduleRepository.findAllSchedule();
		System.out.println("[SERV] Found all schedules");
		
		return scheduleEntities;
	}
	
	/**
	 * 
	 * 
	 * @param scheduleEntity
	 */
	public void createSchedule(ScheduleEntity scheduleEntity){
		System.out.println("[SERV] Inserting schedule");
		
		scheduleRepository.createSchedule(scheduleEntity);
		
	}
	
	public void deleteSchedule(ScheduleEntity scheduleEntity){
		System.out.println("[SERV] Deleting schedule");
		
		scheduleRepository.deleteSchedule(scheduleEntity);
		
	}
	
	
	public List<ScheduleEntity> getScheduleByDate(String date){
		List<ScheduleEntity> scheduleEntities = scheduleRepository.findScheduleByDate(date);
		System.out.println("[SERV] Found dates");
		
		return scheduleEntities;
	}

}
