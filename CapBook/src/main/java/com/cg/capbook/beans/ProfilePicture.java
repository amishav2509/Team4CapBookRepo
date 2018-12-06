package com.cg.capbook.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProfilePicture {
	@Id
	private String emailID;
	private String path;
	private int status;
	public ProfilePicture() {
		super();
	}
	
	public ProfilePicture(String emailID) {
		super();
		this.emailID = emailID;
	}
	

	public ProfilePicture(String emailID, String path) {
		super();
		this.emailID = emailID;
		this.path = path;
	}

	public ProfilePicture(String emailID, String path, int status) {
		super();
		this.emailID = emailID;
		this.path = path;
		this.status = status;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {

		return "ProfilePicture [emailID=" + emailID + ", path=" + path + ", status=" + status + "]";
	
	}
	
}
