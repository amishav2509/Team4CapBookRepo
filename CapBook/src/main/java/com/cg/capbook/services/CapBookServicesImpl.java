package com.cg.capbook.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cg.capbook.beans.ProfilePicture;
import com.cg.capbook.beans.UserAccount;
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
	
	@Override
	public UserAccount acceptUserDetails(UserAccount user) throws CapBookServicesDownException {
		userAccountDAO.save(user);
		ProfilePicture profilePicture=new ProfilePicture(user.getEmail(),null);
		profilePicDAO.save(profilePicture);
		return  user;
	}

	@Override
	public UserAccount getUserDetails(String email)
			throws CapBookServicesDownException, AccountNotFoundException {
		return userAccountDAO.findById(email).orElseThrow(()->new AccountNotFoundException("No such account exists."));
		
	}

	@Override
	public String changePassword(UserAccount user,String newPassword) throws CapBookServicesDownException, AccountNotFoundException {
		user.setPassword(newPassword);
		userAccountDAO.save(user);
		return "Password changed";
	}

	@Override
	public String getProfilePicture(String email) {
		ProfilePicture profilePicture=profilePicDAO.findById(email).get();
		return profilePicture.getPath();
	}

	@Override
	public String updateProfilePicture(String email, String newPath) {
		ProfilePicture profilePicture=profilePicDAO.findById(email).get();
		profilePicture.setPath(newPath);
		profilePicDAO.save(profilePicture);
		return profilePicture.getPath();
	}

	@Override
	public boolean acceptFriendRequest(String senderEmailID, String receiverEmailID) {
		UserAccount senderAccount=userAccountDAO.findById(senderEmailID).get();
		UserAccount receiverAccount=userAccountDAO.findById(receiverEmailID).get();
		List<String> myList1 = new ArrayList<String>(Arrays.asList(receiverEmailID));
		senderAccount.setFriendList(myList1);
		userAccountDAO.save(senderAccount);
		List<String> myList2 = new ArrayList<String>(Arrays.asList(senderEmailID));
		senderAccount.setFriendList(myList2);
		userAccountDAO.save(receiverAccount);
		return true;
	}

	@Override
	public List<String> getFriendList(String email) {
		UserAccount user=userAccountDAO.findById(email).get();
		return user.getFriendList();
	}

}
