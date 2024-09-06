package com.aot.bean;

import lombok.Data;

@Data
public class Student {
	private int id;
	private String name;
	private String dob;
	private String address;
	private String qualification;
	private String email;
	
	public Student(String name, String dob, String address, String qualification, String email) {
	
		this.name=name;
		this.dob=dob;
		this.address=address;
		this.qualification=qualification;
		this.email=email;
	}

	public Student() {
		super();
	}

	public Student(int id, String name, String dob, String address, String qualification, String email) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.address = address;
		this.qualification = qualification;
		this.email = email;
	}
}
