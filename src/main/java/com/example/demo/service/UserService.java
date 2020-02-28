package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Domaine;
import com.example.demo.model.Role;
import com.example.demo.model.User;

public interface UserService {

	public void saveUser (User user) ;
	public boolean isUserAlreadyPresent(User user) ;
	public User getUser (String email);
	public List<User> findAll();
	public List<Role> findAllrole();
	public List<Domaine> findAlldomaine();
}
