package com.brigelabz.model;

public class User {
	private String firstName;
	private String lastName;
	private String mobileNo;
	private String gender;
    private String email;
    private String password;
	public String getFirstName() {
		return firstName;
	}

	public String setFirstName(String firstName) {
		return this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String setLastName(String lastName) {
		return this.lastName = lastName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public String setMobileNo(String mobileNo) {
		return this.mobileNo = mobileNo;
	}

	public String getGender() {
		return gender;
	}

	public String setGender(String gender) {
		return this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public String setEmail(String email) {
		return this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public String setPassword(String password) {
		return this.password = password;
	}

}
