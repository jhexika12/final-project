package com.stk.car.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.stk.car.model.ScheduleEntity;
import com.stk.car.service.ScheduleService;

@Controller
@RequestMapping(value = "/")
public class ScheduleController {
	
	
	@Autowired
	private ScheduleService scheduleService;
	

	/**
	 * getting the data from schedule
	 * 
	 * @return data of schedule
	 */
	@RequestMapping(value = "/newSchedule", method = RequestMethod.GET )
	public ModelAndView createSchedule(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("schedule");
		modelAndView.addObject("schedule", new ScheduleEntity());
		return modelAndView;
	}
	
	
	/**
	 * Adding data of schedukle
	 * 
	 * @param customer
	 * @param bindingResult
	 * @return entity schedule
	 */
	@RequestMapping(value = "/createSchedule", method = RequestMethod.POST )
	public ModelAndView createNewCustomer(@Valid ScheduleEntity schedule, BindingResult bindingResult){
		ModelAndView modelAndView = new ModelAndView();
		System.out.println("Creating new schedule" + schedule);
		scheduleService.createSchedule(schedule);
		modelAndView.addObject("successMsg","Schedule created...");
		modelAndView.addObject("schedule", schedule);
		modelAndView.setViewName("schedule");
		
		return modelAndView;
		
	}
	
	@RequestMapping(value = "/viewSchedule", method = RequestMethod.GET)
	public ModelAndView showSchedule( ){
		
		List<ScheduleEntity> scheduleEntities = scheduleService.getAllSchedule();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("viewSchedule");
		modelAndView.addObject("schedules",scheduleEntities);
		
		return modelAndView;
	}
	

		
}
