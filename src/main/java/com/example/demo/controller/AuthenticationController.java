package com.example.demo.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Controller
public class AuthenticationController {
	
	@Autowired
	UserService userService;
	@Autowired
	UserRepository userRepository;

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login"); // resources/template/login.html
		return modelAndView;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register() {
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user); 
		modelAndView.addObject("roles", userService.findAllrole()) ;
		modelAndView.addObject("domaines", userService.findAlldomaine()) ;
		modelAndView.setViewName("register"); // resources/template/register.html
		return modelAndView;
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home"); // resources/template/home.html
		return modelAndView;
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView adminHome() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin"); // resources/template/admin.html
		return modelAndView;
	}
	@RequestMapping(value = "/saisie", method = RequestMethod.GET)
	public ModelAndView SaisieHome() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("saisie"); // resources/template/admin.html
		return modelAndView;
	}
	@RequestMapping(value = "/validateur", method = RequestMethod.GET)
	public ModelAndView ValidateurHome() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("validateur"); // resources/template/admin.html
		return modelAndView;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registerUser (@Valid User user, BindingResult bindingResult,ModelMap modelMap) {
		ModelAndView modelAndView = new ModelAndView();
		//check for the validation
		if(bindingResult.hasErrors()) {
			modelAndView.addObject("successMessage", "Please Correct the error in form!");
			modelMap.addAttribute("bindingResult", bindingResult);
		}
		// we will save the user if no error
		else if(userService.isUserAlreadyPresent(user)){
			modelAndView.addObject("successMessage", "User already exist!");
		}
		else {
			userService.saveUser(user);
			modelAndView.addObject("successMessage", "User is register succeful!");
		}
		modelAndView.addObject("user",new User());
		modelAndView.addObject("roles", userService.findAllrole());
		modelAndView.addObject("domaines", userService.findAlldomaine());
		modelAndView.setViewName("register");
		return modelAndView ;
		
	}
}