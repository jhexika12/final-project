package com.stk.car.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.stk.car.model.UserDataEntity;
import com.stk.car.service.UserDataService;

@Controller
@RequestMapping(value = "/")
public class CustomerController {
	
	@Autowired
	private UserDataService userDataService;
	
	@RequestMapping(value = "/newCustomer", method = RequestMethod.GET )
	public ModelAndView createCustomer(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("customer");
		modelAndView.addObject("customer", new UserDataEntity());
		return modelAndView;
	}
	
	@RequestMapping(value = "/createCustomer", method = RequestMethod.POST )
	public String createNewCustomer(@Valid UserDataEntity customer, BindingResult bindingResult , ModelMap model){
		System.out.println("Creating new customer" + customer);
		if(bindingResult.hasErrors()){
			return "customer";
		}
		userDataService.createCustomer(customer);
		model.addAttribute("successMsg","Customer created...");
		model.addAttribute("customer", new UserDataEntity());
		
		return "customer";
	}

}
