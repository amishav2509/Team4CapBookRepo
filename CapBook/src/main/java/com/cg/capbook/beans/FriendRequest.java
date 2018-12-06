package com.cg.capbook.beans;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class FriendRequest {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String idNumber;
	private String senderMailID,receiverMailID;
	@ManyToOne
	private UserAccount userAccount;
	public FriendRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FriendRequest(String senderMailID, String receiverMailID) {
		super();
		
		this.senderMailID = senderMailID;
		this.receiverMailID = receiverMailID;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getSenderMailID() {
		return senderMailID;
	}
	public void setSenderMailID(String senderMailID) {
		this.senderMailID = senderMailID;
	}
	public String getReceiverMailID() {
		return receiverMailID;
	}
	public void setReceiverMailID(String receiverMailID) {
		this.receiverMailID = receiverMailID;
	}
	
	
}
