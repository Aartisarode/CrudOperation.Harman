package com.harman.model;

public class Person {
	private String name;
	private String email;
	private String Location;
	private int id;
	
	
	public Person()
	{
//		Default Constructor
	}
	
	public Person(String name, String email, String Location, int id) {
		super();
		this.name = name;
		this.email = email;
		this.Location = Location;
		this.id=id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	
	
	

}
