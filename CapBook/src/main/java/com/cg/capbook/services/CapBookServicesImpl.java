package com.cg.capbook.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cg.capbook.beans.UserAccount;
import com.cg.capbook.daoservices.UserAccountDAO;
import com.cg.capbook.exceptions.AccountNotFoundException;
import com.cg.capbook.exceptions.CapBookServicesDownException;


@Component("capBookServices")
public class CapBookServicesImpl implements CapBookServices{

	@Autowired
	private UserAccountDAO userAccountDAO;
	
	@Override
	public UserAccount acceptUserDetails(UserAccount user) throws CapBookServicesDownException {
		return  userAccountDAO.save(user);
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

}
