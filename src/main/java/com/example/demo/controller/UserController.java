package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private UserRepository userRepository;	
	
	@GetMapping("/users") 
	private String ListUsers(Model model) {
		model.addAttribute("users", userService.findAll()) ;	
		return"views/list";
		
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") int id, Model model) {
	    User user = userRepository.findById(id);
	     
	    model.addAttribute("user", user);
	    return "views/edit_user";
	}
	
	@PostMapping("/update/{id}")
	public String updateUser(@PathVariable("id") int id, @Valid User user, 
	  BindingResult result, Model model) {
	    if (result.hasErrors()) {
	        user.setId(id);
	        return "views/edit_user";
	    }
	         
	    userService.saveUser(user);
	    model.addAttribute("users",userService.findAll());
	    model.addAttribute("roles", userService.findAllrole()) ;
		model.addAttribute("domaines", userService.findAlldomaine()) ;
	    return "redirect:/users";
	}
	
}
