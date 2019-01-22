package com.AAA.BBB.PracticeSSSSSS;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotBlank
	private String name;

	@Pattern(regexp = "(^$|[0-9]{10})")

	private String mo_no;

	@Pattern(regexp = ".+@.+\\..+", message = "Please provide a valid email address")
	private String mail_id;

	public String getMo_no() {
		return mo_no;
	}

	public void setMo_no(String mo_no) {
		this.mo_no = mo_no;
	}

	public String getMail_id() {
		return mail_id;
	}

	public void setMail_id(String mail_id) {
		this.mail_id = mail_id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
