package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Domaine;
import com.example.demo.model.Role;


@Repository
public interface DomaineRepository extends JpaRepository<Domaine, Integer>{
	
	public Domaine findByDomaine(String domaine);
	public List<Domaine> findAll();

}
