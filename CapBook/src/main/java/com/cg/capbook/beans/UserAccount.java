package com.cg.capbook.beans;



import java.util.Map;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class UserAccount {
	@Id
	private String emailID;
	private String firstName,lastName,password,gender,dob;
	
	@OneToMany(mappedBy="user")
	private Map<Integer,Status> status;
	
	public UserAccount() {
		super();
	}
	public UserAccount(String emailID, String firstName, String lastName, String password, String gender, String dob) {
		super();
		this.emailID = emailID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.gender = gender;
		this.dob = dob;
		//this.friendList = friendList;
	}



	public UserAccount(String emailID, String password) {
		super();
		this.emailID = emailID;
		this.password = password;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
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
	
	@Override
	public String toString() {
		return "UserAccount [email=" + emailID + ", firstName=" + firstName + ", lastName=" + lastName + ", password="
				+ password + ", gender=" + gender + ", dob=" + dob + "]";
	}
	
}
