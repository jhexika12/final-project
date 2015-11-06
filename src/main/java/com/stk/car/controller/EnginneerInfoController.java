package com.stk.car.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.stk.car.model.EngineerInfoEntity;
import com.stk.car.service.EngineerInfoService;


@Controller
@RequestMapping(value = "/")
public class EnginneerInfoController {
	
	@Autowired
	private EngineerInfoService engineerInfoService;
	
	@RequestMapping(value = "/newEngineer", method = RequestMethod.GET )
	public ModelAndView createEngineer(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("engineer");
		modelAndView.addObject("engineer", new EngineerInfoEntity());
		return modelAndView;
	}
	
	
	/**
	 * Adding data of customer
	 * 
	 * @param customer
	 * @param bindingResult
	 * @param model
	 * @return entity customer
	 */
	@RequestMapping(value = "/createEngineer", method = RequestMethod.POST )
	public String createNewEngineer(@Valid EngineerInfoEntity engineer, BindingResult bindingResult , ModelMap model){
		System.out.println("Creating new enginer" + engineer);
		if(bindingResult.hasErrors()){
			return "engineer";
		}
		
		engineerInfoService.createEngineer(engineer);
		model.addAttribute("successMsg","Engineer created...");
		model.addAttribute("engineer", new EngineerInfoEntity());
		
		return "engineer";
	}

}
