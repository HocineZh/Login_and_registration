package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "domaine")
public class Domaine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_domaine")
	private int id_domaine;
	
	public int getId_domaine() {
		return id_domaine;
	}

	public void setId_domaine(int id_domaine) {
		this.id_domaine = id_domaine;
	}

	public String getDomaine() {
		return domaine;
	}

	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}

	public String getDomaine_description() {
		return domaine_description;
	}

	public void setDomaine_description(String domaine_description) {
		this.domaine_description = domaine_description;
	}

	@NotNull(message="Name of domaine is compulsory")
	@Column(name = "domaine_name")
	private String domaine;
	
	@NotNull(message="description of  domaine is compulsory")
	@Column(name = "domaine_description")
	private String domaine_description;
}
