package com.springboot.api;

public class Students {
    
	private int id;
	private String name;
	private String course;
	private String address;
	
	public Students() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Students(int id, String name, String course, String address) {
		super();
		this.id = id;
		this.name = name;
		this.course = course;
		this.address = address;
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
		this.name = name;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
