package com.stk.car.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.stk.car.model.CarDataEntity;
import com.stk.car.service.CarService;


@Controller
@RequestMapping(value = "/")
public class CarController {
	
	@Autowired
	private CarService carService;
	
	@RequestMapping(value = "/newCar", method = RequestMethod.GET )
	public ModelAndView createCar(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("car");
		modelAndView.addObject("car", new CarDataEntity());
		return modelAndView;
	}
	
	@RequestMapping(value = "/createCar", method = RequestMethod.POST )
	public ModelAndView createNewCustomer(@Valid CarDataEntity car, BindingResult bindingResult ,ModelAndView modelAndView){
		System.out.println("Creating new car" + car);
		carService.createCar(car);
		modelAndView.addObject("successMsg","Car created...");
		modelAndView.addObject("car", new CarDataEntity());
		
		modelAndView.setViewName("car");
		return modelAndView;
	}

}
