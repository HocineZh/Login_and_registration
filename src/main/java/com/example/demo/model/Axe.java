package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "axe")
public class Axe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_axe")
	private int id_axe;
	
	@NotNull(message="Name of axe is compulsory")
	@Column(name = "axe_name")
	private String axe_name;
	
	@NotNull(message="description of  axe is compulsory")
	@Column(name = "axe_description")
	private String axe_description;

	public int getId_axe() {
		return id_axe;
	}

	public void setId_axe(int id_axe) {
		this.id_axe = id_axe;
	}

	public String getAxe_name() {
		return axe_name;
	}

	public void setAxe_name(String axe_name) {
		this.axe_name = axe_name;
	}

	public String getAxe_description() {
		return axe_description;
	}

	public void setAxe_description(String axe_description) {
		this.axe_description = axe_description;
	}
	
	

}
