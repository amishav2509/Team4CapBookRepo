package com.cg.capbook.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class Status {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int statusID;
	private String emailID,status;
	private int likeStatus,unlikeStatus;
	
	@ManyToOne
	private UserAccount userAccount;

	public Status() {
		super();
		}
	
	public Status(int statusID, String status) {
		super();
		this.statusID = statusID;
		this.status = status;
	}

	public int getStatusID() {
		return statusID;
	}

	public void setStatusID(int statusID) {
		this.statusID = statusID;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getLike() {
		return likeStatus;
	}

	public void setLike(int likeStatus) {
		this.likeStatus = likeStatus;
	}

	public int getUnlike() {
		return unlikeStatus;
	}

	public void setUnlike(int unlikeStatus) {
		this.unlikeStatus = unlikeStatus;
	}

	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

	@Override
	public String toString() {
		return "Status [statusId=" + statusID + ", emailID=" + emailID + ", status=" + status + ", likeStatus=" + likeStatus
				+ ", unlikeStatus=" + unlikeStatus + ", userAccount=" + userAccount + "]";
	}

	
}
