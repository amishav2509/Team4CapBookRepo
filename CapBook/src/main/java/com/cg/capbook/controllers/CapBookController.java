package com.cg.capbook.controllers;

import java.util.List;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.capbook.beans.Status;
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
	public ResponseEntity<String> acceptUserDetails(@RequestBody UserAccount user){
		try {
			capBookServices.acceptUserDetails(user);
			//System.out.println("Yes");
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
		UserAccount user;
		try {
			user = capBookServices.getUserDetails(emailID);
			return new ResponseEntity<>(user,HttpStatus.OK);	
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
		UserAccount user;
		try {
			user = capBookServices.getUserDetails(emailID);
			if(user.getPassword().equals(oldPassword)){
				//session.setAttribute("user", user);
				capBookServices.changePassword(user, newPassword);
			 return new ResponseEntity<>(user,HttpStatus.OK);	
			}
			return new ResponseEntity<>(null,HttpStatus.OK);	
		} catch (CapBookServicesDownException | AccountNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	@RequestMapping(
			value="/updatePost",
			method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE
			)
	public ResponseEntity<String> updatePost(@RequestParam("statusID")int statusID){
		try {
			capBookServices.updatePost(statusID);
			//System.out.println("Yes");
			return new ResponseEntity<>("Post Updated successfully",HttpStatus.OK);
		} catch (CapBookServicesDownException e) {
			return new ResponseEntity<>("Capbook services are down",HttpStatus.OK);
		}
	}

	@RequestMapping(
			value="/deletePost",
			method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE
			)
	public ResponseEntity<String> deletePost(@RequestParam("statusID")int statusID){
		try {
			capBookServices.deletePost(statusID);
			//System.out.println("Yes");
			return new ResponseEntity<>("Post Deleted successfully",HttpStatus.OK);
		} catch (CapBookServicesDownException e) {
			return new ResponseEntity<>("Capbook services are down",HttpStatus.OK);
		}
	}
	
	@RequestMapping(
			value="/getPost",
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE,
			headers="Accept=application/json"
			)
	public ResponseEntity<String> getPost(@RequestParam("statusID") int statusID){
		String status;
		try {
			status = capBookServices.getPost(statusID);
			return new ResponseEntity<>(status,HttpStatus.OK);	
		} catch (CapBookServicesDownException e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
