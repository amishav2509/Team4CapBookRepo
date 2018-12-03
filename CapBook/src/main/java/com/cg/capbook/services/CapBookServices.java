package com.cg.capbook.services;

import com.cg.capbook.beans.UserAccount;
import com.cg.capbook.exceptions.AccountNotFoundException;
import com.cg.capbook.exceptions.CapBookServicesDownException;

public interface CapBookServices {
 public UserAccount acceptUserDetails(UserAccount user)throws CapBookServicesDownException;
 public UserAccount getUserDetails(String email) throws CapBookServicesDownException,AccountNotFoundException;
}
