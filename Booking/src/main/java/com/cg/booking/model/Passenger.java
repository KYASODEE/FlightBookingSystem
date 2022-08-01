package com.cg.booking.model;

import org.hibernate.validator.constraints.Range;

public class Passenger {

	private String firstName;
	private String lastName;
	@Range(min = 5, max = 120, message = "age must be 5 to 100")
	private Integer age;
	private String gender;

	public Passenger() {
		super();
	}

	public Passenger(String firstName, String lastName,
			@Range(min = 5, max = 120, message = "age must be 5 to 100") Integer age, String gender) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Passenger [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", gender=" + gender
				+ "]";
	}
}
