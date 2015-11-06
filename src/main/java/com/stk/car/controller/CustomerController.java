package com.stk.car.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.stk.car.model.UserDataEntity;
import com.stk.car.service.UserDataService;

/**
 * Adding new customer and users data controller
 * 
 * @author Yessica GC
 *
 */

@Controller
@RequestMapping(value = "/")
public class CustomerController {
	
	@Autowired
	private UserDataService userDataService;
	
	
	/**
	 * getting the data from customer
	 * 
	 * @return data of customer
	 */
	@RequestMapping(value = "/newCustomer", method = RequestMethod.GET )
	public ModelAndView createCustomer(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("customer");
		modelAndView.addObject("customer", new UserDataEntity());
		return modelAndView;
	}
	
	
	
	@RequestMapping(value = "/createCustomer", method = RequestMethod.POST )
	public ModelAndView createNewUser(@Valid UserDataEntity customer, BindingResult bindingResult ,ModelAndView modelAndView){
		System.out.println("Creating new customer" + customer);
		userDataService.createCustomer(customer);
		modelAndView.addObject("successMsg","Customer created...");
		modelAndView.addObject("customer", customer);
		
		modelAndView.setViewName("customer");
		return modelAndView;
	}

}
