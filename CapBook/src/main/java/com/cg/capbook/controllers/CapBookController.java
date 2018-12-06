package com.cg.capbook.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.capbook.beans.FriendList;
import com.cg.capbook.beans.UserAccount;
import com.cg.capbook.exceptions.AccountNotFoundException;
import com.cg.capbook.exceptions.CapBookServicesDownException;
import com.cg.capbook.services.CapBookServices;
@RestController
public class CapBookController {
	//String msg=null;
	@Autowired
	private CapBookServices capBookServices;
	@RequestMapping(
			value="/acceptUserDetails",
			method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE
			)
	public ResponseEntity<String> acceptUserDetails(@RequestBody UserAccount userAccount){
		try {
			capBookServices.acceptUserDetails(userAccount);
			System.out.println("Yes");
			return new ResponseEntity<>("User Registered successfully",HttpStatus.OK);
		} catch (CapBookServicesDownException e) {
			return new ResponseEntity<>("Capbook services are down",HttpStatus.OK);
		}
	
	}

	@RequestMapping(
			value="/getUserDetails",
			produces=MediaType.APPLICATION_JSON_VALUE,
			headers="Accept=application/json"
			)
	public ResponseEntity<UserAccount> getUserDetails(@RequestParam("emailID") String emailID){
		UserAccount userAccount;
		try {
			userAccount = capBookServices.getUserDetails(emailID);
			 return new ResponseEntity<>(userAccount,HttpStatus.OK);	
		} catch (CapBookServicesDownException | AccountNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	@RequestMapping(
			value="/changePassword",
					method=RequestMethod.POST,
			produces=MediaType.APPLICATION_JSON_VALUE
			
			)
	public ResponseEntity<UserAccount> changePassword(@RequestParam("emailID") String emailID, @RequestParam("oldPassword") String oldPassword,@RequestParam("newPassword") String newPassword){
		UserAccount userAccount;
		try {
			userAccount = capBookServices.getUserDetails(emailID);
			if(userAccount.getPassword().equals(oldPassword)){
				//session.setAttribute("user", user);
				capBookServices.changePassword(userAccount, newPassword);
			 return new ResponseEntity<>(userAccount,HttpStatus.OK);	
			}
			return new ResponseEntity<>(null,HttpStatus.OK);	
		} catch (CapBookServicesDownException | AccountNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(
			value="/getProfilePicture",
			produces=MediaType.APPLICATION_JSON_VALUE,
			headers="Accept=application/json"
			)
	public ResponseEntity<String> getProfilePicture(@RequestParam("emailID") String emailID){
		 return new ResponseEntity<>( capBookServices.getProfilePicture(emailID),HttpStatus.OK);
		
	}
	
	@RequestMapping(
			value="/updateProfilePhoto",
					method=RequestMethod.POST,
			produces=MediaType.APPLICATION_JSON_VALUE
			
			)
	public ResponseEntity<UserAccount> updateProfilePhoto(@RequestParam("emailID") String emailID, @RequestParam("path") String path){
		UserAccount userAccount;
		try {
			userAccount = capBookServices.getUserDetails(emailID);
			capBookServices.updateProfilePicture(emailID, path);
			 return new ResponseEntity<>(userAccount,HttpStatus.OK);	
		} catch (CapBookServicesDownException | AccountNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
		
		@RequestMapping(
				value="/acceptFriendRequest",
				method=RequestMethod.POST,
				consumes=MediaType.APPLICATION_JSON_VALUE
				)
		public ResponseEntity<String> acceptFriendRequest(@RequestBody UserAccount senderUser,@RequestBody UserAccount receiverUser) throws CapBookServicesDownException{
			capBookServices.acceptFriendRequest(senderUser.getEmailID(),receiverUser.getEmailID());
			return new ResponseEntity<>("Friend Added successfully",HttpStatus.OK);
	}
		
		@RequestMapping(
				value="/deleteUserAccount",
				method=RequestMethod.POST,
				consumes=MediaType.APPLICATION_JSON_VALUE
				)
		public ResponseEntity<String> deleteUserAccount(@RequestParam("emailID") String emailID,@RequestParam("password") String password){
			try {
				UserAccount userAccount = capBookServices.getUserDetails(emailID);
				if(userAccount.getPassword().equals(password))
				capBookServices.deleteUserAccount(emailID);
				System.out.println("Deleted");
				return new ResponseEntity<>("User Account deleted successfully",HttpStatus.OK);
			} catch (CapBookServicesDownException | AccountNotFoundException e) {
				return new ResponseEntity<>("Capbook services are down",HttpStatus.OK);
			}
		
		}
		
		@RequestMapping(
				value="/getFriendList",
				produces=MediaType.APPLICATION_JSON_VALUE,
				headers="Accept=application/json"
				)
		public ResponseEntity<List<FriendList>> getFriendList(@RequestParam("emailID") String emailID){
				List<FriendList> list=capBookServices.getFriendList(emailID);
				 return new ResponseEntity<>(list,HttpStatus.OK);	
			
		}
		
		@RequestMapping(
				value="/acceptFriendRequest",
				produces=MediaType.APPLICATION_JSON_VALUE,
				headers="Accept=application/json"
				)
		public ResponseEntity<String> acceptFriendRequest(@RequestParam("senderEmailID") String senderEmailID,@RequestParam("receiverEmailID") String receiverEmailID){
				capBookServices.acceptFriendRequest(senderEmailID, receiverEmailID);
				 return new ResponseEntity<>("friend Request accepted",HttpStatus.OK);	
		}	
		
		@RequestMapping(
				value="/sendFriendRequest",
				produces=MediaType.APPLICATION_JSON_VALUE,
				headers="Accept=application/json"
				)
		public ResponseEntity<String> sendFriendRequest(@RequestParam("senderEmailID") String senderEmailID,@RequestParam("receiverEmailID") String receiverEmailID){
				capBookServices.sendFriendRequest(senderEmailID, receiverEmailID);
				 return new ResponseEntity<>("friend Request sent",HttpStatus.OK);	
		}
		
		@RequestMapping(
				value="/rejectFriendRequest",
				produces=MediaType.APPLICATION_JSON_VALUE,
				headers="Accept=application/json"
				)
		public ResponseEntity<String> rejectFriendRequest(@RequestParam("senderEmailID") String senderEmailID,@RequestParam("receiverEmailID") String receiverEmailID){
				capBookServices.rejectFriendRequest(senderEmailID, receiverEmailID);
				 return new ResponseEntity<>("friend Request rejectes/cancelled",HttpStatus.OK);	
		}	
		@RequestMapping(
				value="/unfriend",
				produces=MediaType.APPLICATION_JSON_VALUE,
				headers="Accept=application/json"
				)
		public ResponseEntity<String> unfriend(@RequestParam("userMailID") String userMailID,@RequestParam("friendMailID") String friendMailID){
				capBookServices.unfriend(userMailID, friendMailID);
				 return new ResponseEntity<>("no more friends",HttpStatus.OK);	
		}
		
}
