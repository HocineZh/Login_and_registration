package com.example.demo.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.Domaine;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.DomaineRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	BCryptPasswordEncoder encoder ;
	@Autowired
	RoleRepository roleRepository ;
	@Autowired
	UserRepository userRepository ;
	@Autowired
	DomaineRepository domaineRepository ;

	
	@Override
	public void saveUser(User user) {
		 user.setPassword(encoder.encode(user.getPassword()));
         user.setStatus("VERIFIED");
         Domaine domaine =  domaineRepository.findByDomaine(user.getDomaine());
         user.setDomaine_id(domaine.getId_domaine());
         Role userRole = roleRepository.findByRole(user.getRole()) ;
         user.setRoles(new HashSet <Role> (Arrays.asList(userRole)));
         userRepository.save(user);
         
	}

	@Override
	public boolean isUserAlreadyPresent(User user) {
	
		boolean isUserAlreadyExists = false;
		User existingUser = userRepository.findByEmail(user.getEmail());
		// If user is found in database, then then user already exists.
		if(existingUser != null){
			isUserAlreadyExists = true; 
		}
		return isUserAlreadyExists;
	}
	@Override
	public User getUser(String email) {
		return userRepository.findByEmail(email);
	};
	@Override
	public List<User> findAll(){
		return userRepository.findAll();
	};
	@Override
	public List<Role> findAllrole(){
		return roleRepository.findAll();
	};
	@Override
	public List<Domaine> findAlldomaine(){
		return domaineRepository.findAll();
	};
}
