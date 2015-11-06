package com.stk.car.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
	 * @param model
	 * @return entity schedule
	 */
	@RequestMapping(value = "/createSchedule", method = RequestMethod.POST )
	public String createNewCustomer(@Valid ScheduleEntity schedule, BindingResult bindingResult , ModelMap model){
		System.out.println("Creating new schedule" + schedule);
		if(bindingResult.hasErrors()){
			return "schedule";
		}
		scheduleService.createSchedule(schedule);
		model.addAttribute("successMsg","Schedule created...");
		model.addAttribute("schedule", schedule);
		
		return "schedule";
		
	}
	
	@RequestMapping(value = "/viewSchedule", method = RequestMethod.GET)
	public ModelAndView showSchedule( ){
		
		List<ScheduleEntity> scheduleEntities = scheduleService.getAllSchedule();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("viewSchedule");
		modelAndView.addObject("viewSchedule",scheduleEntities);
		return modelAndView;
	}
	

		
}
