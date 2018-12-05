package com.cg.capbook.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cg.capbook.beans.ProfilePicture;
import com.cg.capbook.beans.Status;
import com.cg.capbook.beans.UserAccount;
import com.cg.capbook.daoservices.ProfilePicDAO;
import com.cg.capbook.daoservices.StatusDAO;
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
	private StatusDAO statusDAO;
	
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
	public String updatePost(int statusID)throws CapBookServicesDownException {
	 Status status=statusDAO.findById(statusID).get();
		statusDAO.save(status);
		return "You just added a post on your timeline!";
	}

	@Override
	public String deletePost(int statusID) throws CapBookServicesDownException {
		statusDAO.deleteById(statusID);
		return "Post deleted!!";
	}

	@Override
	public String getPost(int statusID) throws CapBookServicesDownException {
		Status status=statusDAO.findById(statusID).get();
		return status.getStatus();
	}
	
	

	

}
