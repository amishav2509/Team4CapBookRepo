package com.cg.capbook.services;

import java.util.List;

import com.cg.capbook.beans.UserAccount;
import com.cg.capbook.exceptions.AccountNotFoundException;
import com.cg.capbook.exceptions.CapBookServicesDownException;

public interface CapBookServices {
 public UserAccount acceptUserDetails(UserAccount user)throws CapBookServicesDownException;
 public UserAccount getUserDetails(String emailID) throws CapBookServicesDownException,AccountNotFoundException;
 public String changePassword(UserAccount user,String newPassword) throws CapBookServicesDownException,AccountNotFoundException;
 public String getProfilePicture(String emailID);
 public String updateProfilePicture(String emailID,String path);
 public String updatePost(int statusID)throws CapBookServicesDownException;
 public String deletePost(int statusID)throws CapBookServicesDownException;
 public String getPost(int statusID)throws CapBookServicesDownException;
}
