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
	private UserAccount user;

	public Status() {
		super();
		}
	
	public Status(int statusID, String status) {
		super();
		this.statusID = statusID;
		this.status = status;
	}

	public int getStatusId() {
		return statusID;
	}

	public void setStatusId(int statusId) {
		this.statusID = statusId;
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

	public void setLike(int like) {
		this.likeStatus = like;
	}

	public int getUnlike() {
		return unlikeStatus;
	}

	public void setUnlike(int unlike) {
		this.unlikeStatus = unlike;
	}

	public UserAccount getUser() {
		return user;
	}

	public void setUser(UserAccount user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Status [statusId=" + statusID + ", emailID=" + emailID + ", status=" + status + ", like=" + likeStatus
				+ ", unlike=" + unlikeStatus + ", user=" + user + "]";
	}

	
}
