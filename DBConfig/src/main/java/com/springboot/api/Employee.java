package com.springboot.api;

import jakarta.persistence.*;

@Entity
@Table(name = "New_Employees")
public class Employee {
	
	@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "name")
	private String name;

	@Column(name = "address")
	private String address;
	
	@Column(name = "email_address")
	private String emailId;
	
	
	
	public Employee() {
		
	}

	public Employee(int id, String name, String address, String emailId) {
		super();
		this.id = id;
		name = name;
		address = address;
		this.emailId = emailId;
	}

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
		name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		address = address;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	
	
	
}