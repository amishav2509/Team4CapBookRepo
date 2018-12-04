package com.cg.capbook.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.Embedded;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class UserAccount {
	@Id
	private String email;
	private String firstName,lastName,password,gender,dob;
	
	private List<String> friendList;
	
	public UserAccount() {
		super();
	}
	public UserAccount(String email, String firstName, String lastName, String password, String gender, String dob,
			List<String> friendList) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.gender = gender;
		this.dob = dob;
		this.friendList = friendList;
	}



	public UserAccount(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	public List<String> getFriendList() {
		return friendList;
	}
	public void setFriendList(List<String> friendList) {
		this.friendList = friendList;
	}
	@Override
	public String toString() {
		return "UserAccount [email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + ", password="
				+ password + ", gender=" + gender + ", dob=" + dob + "]";
	}
	
}
