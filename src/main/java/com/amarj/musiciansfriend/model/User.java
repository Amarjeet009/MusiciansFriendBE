package com.amarj.musiciansfriend.model;

import javax.persistence.Column;
/*import javax.persistence.Column;*/
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity
@Table(name="User")
@Component
public class User {
	
	@Id
	@NotEmpty(message = "Please Enter Your id")
	private String id;
	
	/*
	 * @Column(name="name") use when the column name is differ from the declared variable
     */	
	@NotEmpty(message = "Please Enter Your Name")
	private String name;
	
	@Min(5)
	@Max(10)
	@NotEmpty(message = "Please Enter Password")
	private String password;
	
	@Column(unique=true, nullable=false)
	private String mail;
	
	private String mobile;
	
	private String role;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
	
	
}
