package com.cg.capbook.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class FriendList {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String idNumber;
	private String userMailID,friendEmailID;
	@ManyToOne
	private UserAccount userAccount;
	public FriendList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FriendList(String idNumber, String userMailID, String friendEmailID, UserAccount userAccount) {
		super();
		this.idNumber = idNumber;
		this.userMailID = userMailID;
		this.friendEmailID = friendEmailID;
		this.userAccount = userAccount;
	}
	
	public FriendList(String userMailID, String friendEmailID) {
		super();
		this.userMailID = userMailID;
		this.friendEmailID = friendEmailID;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getUserMailID() {
		return userMailID;
	}
	public void setUserMailID(String userMailID) {
		this.userMailID = userMailID;
	}
	public String getFriendEmailID() {
		return friendEmailID;
	}
	public void setFriendEmailID(String friendEmailID) {
		this.friendEmailID = friendEmailID;
	}
	public UserAccount getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}
	

}
