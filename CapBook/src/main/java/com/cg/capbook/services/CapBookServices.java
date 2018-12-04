package com.cg.capbook.services;

import java.util.List;

import com.cg.capbook.beans.UserAccount;
import com.cg.capbook.exceptions.AccountNotFoundException;
import com.cg.capbook.exceptions.CapBookServicesDownException;

public interface CapBookServices {
 public UserAccount acceptUserDetails(UserAccount user)throws CapBookServicesDownException;
 public UserAccount getUserDetails(String email) throws CapBookServicesDownException,AccountNotFoundException;
 public String changePassword(UserAccount user,String newPassword) throws CapBookServicesDownException,AccountNotFoundException;
 public String getProfilePicture(String email);
 public String updateProfilePicture(String email,String path);
 public boolean acceptFriendRequest(String senderEmailID,String receiverEmailID);
 public List<String> getFriendList(String email);
}
