package com.cg.capbook.services;

import java.util.List;

import com.cg.capbook.beans.FriendList;
import com.cg.capbook.beans.UserAccount;
import com.cg.capbook.exceptions.AccountNotFoundException;
import com.cg.capbook.exceptions.CapBookServicesDownException;

public interface CapBookServices {
 public UserAccount acceptUserDetails(UserAccount userAccount)throws CapBookServicesDownException;
 public UserAccount getUserDetails(String emailID) throws CapBookServicesDownException,AccountNotFoundException;
 public String changePassword(UserAccount userAccount,String newPassword) throws CapBookServicesDownException,AccountNotFoundException;
 public String getProfilePicture(String emailID);
 public String updateProfilePicture(String emailID,String path);
 public String deleteUserAccount(String emailID);
 public List<FriendList> getFriendList(String emailID);
 public boolean acceptFriendRequest(String senderEmailID,String receiverEmailID);
 public String sendFriendRequest(String senderEmailID,String receiverEmailID );
 public String rejectFriendRequest(String senderEmailID,String receiverEmailID);
 public String unfriend(String userMailID,String friendMailID);
}
