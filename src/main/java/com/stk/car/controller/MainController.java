package com.stk.car.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.stk.car.model.UserEntity;
import com.stk.car.service.UserService;

@Controller
public class MainController {
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value = "/showUsers", method = RequestMethod.GET)
	public ModelAndView showUSers(){
		System.out.println("[CONT] Showing all users");
		
		List<UserEntity> userEntity = userService.getAllUsers();
		
		ModelAndView modelAndView = new ModelAndView("users");
		modelAndView.addObject("userEntity",userEntity);
		
		return modelAndView;
	}
	
	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView welcomePage() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("title", "Spring Security Custom Login Form");
		modelAndView.addObject("message", "This is welcome page!");
		modelAndView.setViewName("hello");
		return modelAndView;

	}

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("title", "Spring Security Custom Login Form");
		modelAndView.addObject("message", "This is protected page!");
		modelAndView.setViewName("admin");

		return modelAndView;

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView modelAndView = new ModelAndView();
		if (error != null) {
			modelAndView.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			modelAndView.addObject("msg", "You've been logged out successfully.");
		}
		modelAndView.setViewName("login");

		return modelAndView;

	}

	


}
