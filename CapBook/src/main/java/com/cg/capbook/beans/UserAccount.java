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
	private Map<Integer, FriendList> friendList;
	@OneToMany(mappedBy="user")
	private Map<Integer, FriendRequest> friendRequest;
	@OneToMany(mappedBy="user")
	private Map<Integer, Status> status;
	
	public UserAccount() {
		// TODO Auto-generated constructor stub
	}
	public UserAccount(Map<Integer, FriendRequest> friendRequest) {
		super();
		this.friendRequest = friendRequest;
	}
	public UserAccount(String emailID, String firstName, String lastName, String password, String gender, String dob,
			Map<Integer, FriendList> friendList) {
		super();
		this.emailID = emailID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.gender = gender;
		this.dob = dob;
		this.friendList = friendList;
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
	public Map<Integer, FriendList> getFriendList() {
		return friendList;
	}
	public void setFriendList(Map<Integer, FriendList> friendList) {
		this.friendList = friendList;
	}

	public Map<Integer, FriendRequest> getFriendRequest() {
		return friendRequest;
	}
	public void setFriendRequest(Map<Integer, FriendRequest> friendRequest) {
		this.friendRequest = friendRequest;
	}
	
	public Map<Integer, Status> getStatus() {
		return status;
	}
	public void setStatus(Map<Integer, Status> status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "UserAccount [emailID=" + emailID + ", firstName=" + firstName + ", lastName=" + lastName + ", password="
				+ password + ", gender=" + gender + ", dob=" + dob + "]";
	}
	
}
