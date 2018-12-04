package com.cg.capbook.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProfilePicture {
	@Id
	private String email;
	private String path;
	private int status;
	public ProfilePicture() {
		super();
	}
	
	public ProfilePicture(String email) {
		super();
		this.email = email;
	}
	

	public ProfilePicture(String email, String path) {
		super();
		this.email = email;
		this.path = path;
	}

	public ProfilePicture(String email, String path, int status) {
		super();
		this.email = email;
		this.path = path;
		this.status = status;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
		return "ProfilePicture [email=" + email + ", path=" + path + ", status=" + status + "]";
	}
	
}
