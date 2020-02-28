package com.example.demo.model;

import javax.persistence.Transient;import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "auth_user",//
uniqueConstraints = { //
        @UniqueConstraint(name = "auth_user_email_key", columnNames = "email") })
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "auth_user_id")
	private int id;
     
	@NotNull(message="firstname is compulsory")
	@Column(name = "first_name")
	private String name;
	
	@NotNull(message="last_name is compulsory")
	@Column(name = "last_name")
	private String lastName;
	
	@NotNull(message="email is compulsory")
	@Email(message ="Email is invalid")
	@Column(name = "email")
	private String email;
	
	@NotNull(message="Password is compulsory")
	@Length (min=8,message="Password should be at least 8 charachter")
	@Column(name = "password")
	private String password;

	

	@Column(name = "status")
	private String status;
	
	@NotNull(message="matricule is compulsory")
	@Length (min=8,message="Matricule should be at least 8 charachter")
	@Column(name = "matricule")
	private String matricule;
	
	@NotNull(message="Domaine is compulsory")
	@Column(name = "domaine_id")
	private int domaine_id;

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public int getDomaine_id() {
		return domaine_id;
	}

	public void setDomaine_id(int domaine_id) {
		this.domaine_id = domaine_id;
	}

	@Transient
	private String role ; 
	
	@Transient
	private String domaine ; 
	
	public String getDomaine() {

		return domaine;
	}

	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "auth_user_role", joinColumns = @JoinColumn(name = "auth_user_id"), inverseJoinColumns = @JoinColumn(name = "auth_role_id"))
	private Set<Role> roles;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	

}