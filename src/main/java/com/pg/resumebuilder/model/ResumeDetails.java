package com.pg.resumebuilder.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class ResumeDetails {
	
	@Id
	@GeneratedValue
	private int id;
	
	@NotNull
	@NotEmpty
	@ApiModelProperty(notes="name should neither null nor empty")
	private String name;
	
	private String college;
	
	private String degree;
	
	
	@Email
	private String email;

	private Long contact;

	public ResumeDetails() {
		super();
	}

	public ResumeDetails(@NotNull String name, String college, String degree, @NotNull @Email String email,
			@NotNull @Size(min = 10, max = 10) Long contact) {
		super();
		this.name = name;
		this.college = college;
		this.degree = degree;
		this.email = email;
		this.contact = contact;
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCollege() {
		return college;
	}

	public String getDegree() {
		return degree;
	}

	public String getEmail() {
		return email;
	}

	public Long getContact() {
		return contact;
	}

	@Override
	public String toString() {
		return "PersonalDetails [name=" + name + ", college=" + college + ", degree=" + degree + ", email=" + email
				+ ", contact=" + contact + "]";
	}

}
