package com.cg.capbook.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.capbook.beans.FriendList;
import com.cg.capbook.beans.FriendRequest;
import com.cg.capbook.beans.ProfilePicture;
import com.cg.capbook.beans.UserAccount;
import com.cg.capbook.daoservices.FriendListDAO;
import com.cg.capbook.daoservices.FriendRequestDAO;
import com.cg.capbook.daoservices.ProfilePicDAO;
import com.cg.capbook.daoservices.UserAccountDAO;
import com.cg.capbook.exceptions.AccountNotFoundException;
import com.cg.capbook.exceptions.CapBookServicesDownException;


@Component("capBookServices")
public class CapBookServicesImpl implements CapBookServices{

	@Autowired
	private UserAccountDAO userAccountDAO;
	
	@Autowired
	private ProfilePicDAO profilePicDAO;
	
	@Autowired
	private FriendListDAO friendListDAO;
	
	@Autowired
	private FriendRequestDAO friendRequestDAO;
	
	@Override
	public UserAccount acceptUserDetails(UserAccount user) throws CapBookServicesDownException {
		userAccountDAO.save(user);
		ProfilePicture profilePicture=new ProfilePicture(user.getEmailID(),null);
		profilePicDAO.save(profilePicture);
		return  user;
	}

	@Override
	public UserAccount getUserDetails(String emailID)
			throws CapBookServicesDownException, AccountNotFoundException {
		return userAccountDAO.findById(emailID).orElseThrow(()->new AccountNotFoundException("No such account exists."));
		
	}

	@Override
	public String changePassword(UserAccount user,String newPassword) throws CapBookServicesDownException, AccountNotFoundException {
		user.setPassword(newPassword);
		userAccountDAO.save(user);
		return "Password changed";
	}

	@Override
	public String getProfilePicture(String emailID) {
		ProfilePicture profilePicture=profilePicDAO.findById(emailID).get();
		return profilePicture.getPath();
	}

	@Override
	public String updateProfilePicture(String emailID, String newPath) {
		ProfilePicture profilePicture=profilePicDAO.findById(emailID).get();
		profilePicture.setPath(newPath);
		profilePicDAO.save(profilePicture);
		return profilePicture.getPath();
	}

	@Override
	public boolean acceptFriendRequest(String senderEmailID, String receiverEmailID) {
		FriendList friendList1=new FriendList(senderEmailID, receiverEmailID);
		FriendList friendList2=new FriendList(receiverEmailID, senderEmailID);
		friendListDAO.save(friendList1);
		friendListDAO.save(friendList2);
		friendRequestDAO.delete(friendRequestDAO.getFriendRequest(senderEmailID, receiverEmailID));
		return true;
	}

	@Override
	public List<FriendList> getFriendList(String emailID) {
		UserAccount user=userAccountDAO.findById(emailID).get();
		return friendListDAO.getFriendList(user);
	}

	@Override
	public String deleteUserAccount(String emailID) {
		userAccountDAO.deleteById(emailID);
		return "User Account deleted";
	}

	@Override
	public String sendFriendRequest(String senderEmailID, String receiverEmailID) {
		FriendRequest friendRequest=new FriendRequest(senderEmailID, receiverEmailID);
		friendRequestDAO.save(friendRequest);
		return "Friend Request Sent";
	}

	@Override
	public String rejectFriendRequest(String senderEmailID, String receiverEmailID) {
		friendRequestDAO.delete(friendRequestDAO.getFriendRequest(senderEmailID, receiverEmailID));
		return "Friend Request Deleted";
	}//for REJECTING and CANCELLING friend request

	@Override
	public String unfriend(String userMailID, String friendEmailID) {
		friendListDAO.delete(friendListDAO.getFriend(userMailID, friendEmailID));
		friendListDAO.delete(friendListDAO.getFriend( friendEmailID,userMailID));
		return "No more friends";
	}//confusion

}
