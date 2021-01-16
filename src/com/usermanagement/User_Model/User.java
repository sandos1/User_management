package com.usermanagement.User_Model;

public class User {
	private int userId;
	private String lastname;
	private String firstname;
	private String email;
	private String country;
	
	public User(int userId, String lastname, String firstname, String email, String country) {
		super();
		this.userId = userId;
		this.lastname = lastname;
		this.firstname = firstname;
		this.email = email;
		this.country = country;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCountry() {
		return country;
	}
	

	public void setCountry(String country) {
		this.country = country;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", lastname=" + lastname + ", firstname=" + firstname + ", email=" + email
				+ ", country=" + country + "]";
	}
	
}
